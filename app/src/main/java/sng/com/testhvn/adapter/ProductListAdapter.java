package sng.com.testhvn.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import sng.com.testhvn.R;
import sng.com.testhvn.model.Product;
import sng.com.testhvn.ui.fragment.HomeFragment;

/**
 * Created by son.nguyen on 3/19/2016.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private HomeFragment.OnProductListListener listListener;
    private ArrayList<Product> mList;

    public ProductListAdapter(Context context, HomeFragment.OnProductListListener listener) {
        setOnItemClickListener(listener);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_detail_item, parent, false);
        return new ProductViewHolder(view, listListener);
    }

    public void setData(ArrayList<Product> list) {
        if (null == mList) {
            mList = new ArrayList<>();
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    private void setOnItemClickListener(HomeFragment.OnProductListListener onItemClickListener) {
        listListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        if (holder != null && position < mList.size()) {
            holder.setData(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }
}

class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTitle;
    private TextView mPrice;
    private TextView mDescription;
    private HomeFragment.OnProductListListener onItemClickListener;

    public ProductViewHolder(View v, HomeFragment.OnProductListListener onItemClickListener) {
        super(v);
        mTitle = (TextView) v.findViewById(R.id.tv_title);
        mPrice = (TextView) v.findViewById(R.id.tv_price);
        mDescription = (TextView) v.findViewById(R.id.tv_description);
        this.onItemClickListener = onItemClickListener;
        v.setOnClickListener(this);
    }

    public void setData(Product product) {
        mTitle.setText(product.getProductName() +"");
        mPrice.setText(product.getPrice()+"");
        mDescription.setText(product.getDescription()+"");
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick();
    }
}