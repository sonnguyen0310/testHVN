package sng.com.testhvn.util;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okio.BufferedSink;
import retrofit.client.Header;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by son.nguyen on 3/19/2016.
 */
public class TrustingOkClient extends OkClient {

    static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s
    static final int READ_TIMEOUT_MILLIS = 20 * 1000; // 20s

    private static OkHttpClient generateDefaultOkHttp() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        client.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);


        final TrustManager[] certs = new TrustManager[]{new X509TrustManager() {

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkServerTrusted(final X509Certificate[] chain,
                                           final String authType) throws CertificateException {
            }

            @Override
            public void checkClientTrusted(final X509Certificate[] chain,
                                           final String authType) throws CertificateException {
            }
        }};

        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(null, certs, new SecureRandom());
        } catch (final java.security.GeneralSecurityException ex) {
        }

        try {
            final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(final String hostname,
                                      final SSLSession session) {
                    return true;
                }
            };
            client.setHostnameVerifier(hostnameVerifier);
            client.setSslSocketFactory(ctx.getSocketFactory());
        } catch (final Exception e) {
        }
        return client;
    }

    private final OkHttpClient client;

    public TrustingOkClient() {
        this(generateDefaultOkHttp());
    }

    public TrustingOkClient(OkHttpClient client) {
        if (client == null) throw new NullPointerException("client == null");
        this.client = client;
    }

    @Override
    public Response execute(Request request) throws IOException {
        return parseResponse(client.newCall(createRequest(request)).execute());
    }

    static com.squareup.okhttp.Request createRequest(Request request) {
        com.squareup.okhttp.Request.Builder builder = new com.squareup.okhttp.Request.Builder()
                .url(request.getUrl())
                .method(request.getMethod(), createRequestBody(request.getBody()));

        List<Header> headers = request.getHeaders();
        for (int i = 0, size = headers.size(); i < size; i++) {
            Header header = headers.get(i);
            String value = header.getValue();
            if (value == null) value = "";
            builder.addHeader(header.getName(), value);
        }

        return builder.build();
    }

    static Response parseResponse(com.squareup.okhttp.Response response) {
        return new Response(response.request().urlString(), response.code(), response.message(),
                createHeaders(response.headers()), createResponseBody(response.body()));
    }

    private static RequestBody createRequestBody(final TypedOutput body) {
        if (body == null) {
            return null;
        }
        final MediaType mediaType = MediaType.parse(body.mimeType());
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return mediaType;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                body.writeTo(sink.outputStream());
            }

            @Override
            public long contentLength() {
                return body.length();
            }
        };
    }

    private static TypedInput createResponseBody(final ResponseBody body) {
        try {
            if (body.contentLength() == 0) {
                return null;
            }
            return new TypedInput() {
                @Override
                public String mimeType() {
                    MediaType mediaType = body.contentType();
                    return mediaType == null ? null : mediaType.toString();
                }

                @Override
                public long length() {
                    try {
                        return body.contentLength();
                    } catch (Exception exception) {
                        System.out.println(exception.toString());
                    }
                    throw new Error("createResponseBody has invalid length for its response");
                }

                @Override
                public InputStream in() throws IOException {
                    return body.byteStream();
                }
            };
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
        throw new Error("createResponseBody has invalid content length for its response");
    }

    private static List<Header> createHeaders(Headers headers) {
        int size = headers.size();
        List<Header> headerList = new ArrayList<Header>(size);
        for (int i = 0; i < size; i++) {
            headerList.add(new Header(headers.name(i), headers.value(i)));
        }
        return headerList;
    }

}