package sng.com.testhvn.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sng.com.testhvn.R;

/**
 * Created by son.nguyen on 3/19/2016.
 */
public class BaseLoadingFragment extends BaseFragment {
    View mLoading;
    ViewGroup mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_loading, container, false);
        mLoading = (View) view.findViewById(R.id.loading);
        mContent = (ViewGroup) view.findViewById(R.id.content);
        return view;
    }

    private void showLoading() {
        if (isViewNull()) {
            return;
        }
        mLoading.setVisibility(View.VISIBLE);
        mContent.setVisibility(View.GONE);
    }

    private void showContent() {
        if (isViewNull()) {
            return;
        }
        mContent.setVisibility(View.VISIBLE);
        mLoading.setVisibility(View.GONE);
    }

    private boolean isViewNull() {
        if (null == mLoading || null == mContent) {
            return true;
        } else {
            return false;
        }
    }
}
