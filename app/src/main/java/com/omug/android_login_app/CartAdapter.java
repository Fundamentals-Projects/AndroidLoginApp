package com.omug.android_login_app;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends BaseAdapter{
    private List<Cart> shoppingCart;
    private LayoutInflater inflater;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.shoppingCart = cartList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return shoppingCart.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingCart.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartAdapter.ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.cart_row,null);
            holder=new CartAdapter.ViewHolder();
            holder.product = convertView.findViewById(R.id.cartProduct);
            holder.quantity = convertView.findViewById(R.id.productQuantity);
            convertView.setTag(holder);
        }
        else
            holder=(CartAdapter.ViewHolder)convertView.getTag();
        holder.product.setText(shoppingCart.get(position).getProduct().getProductName());
        holder.quantity.setText(String.valueOf(shoppingCart.get(position).getQty()));

        return convertView;
    }

    static class ViewHolder{
        //create attributes that match the components of cart_row.xml
        private TextView product, quantity;

    }

}
