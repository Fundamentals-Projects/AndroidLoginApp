package com.omug.android_login_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private List <Product> products;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> prodList) {
        this.products = prodList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.list_row,null);
            holder=new ViewHolder();
            holder.name=convertView.findViewById(R.id.txtPrdName);
            holder.price=convertView.findViewById(R.id.txtPrdPrice);
            holder.img=convertView.findViewById(R.id.imgPrd);
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        holder.name.setText(products.get(position).getProductName());
        holder.price.setText(String.valueOf(products.get(position).getPrice()));
        holder.img.setImageResource(products.get(position).getImage());

        return convertView;
    }

    static class ViewHolder{
        //create attributes that match the components of list_row.xml
        private TextView name,price;
        private ImageView img;

    }
}
