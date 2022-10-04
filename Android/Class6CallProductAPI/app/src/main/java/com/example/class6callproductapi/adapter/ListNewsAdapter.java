package com.example.class6callproductapi.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.class6callproductapi.R;
import com.example.class6callproductapi.model.Customer;

import java.util.List;

public class ListNewsAdapter extends BaseAdapter {
    private List<Customer> listNews;
    private Activity activity;

    public ListNewsAdapter(List<Customer> listNews, Activity activity) {
        this.listNews = listNews;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listNews.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.customer_item, parent, false);
            ViewHolder holder = new ViewHolder();

            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvEmail = convertView.findViewById(R.id.tvEmail);
            holder.tvAddress = convertView.findViewById(R.id.tvAddress);
            holder.imgCover = convertView.findViewById(R.id.imgCover);
            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();

        Customer model = listNews.get(position);

        holder.tvName.setText(model.getName());
        holder.tvEmail.setText(model.getEmail());
        holder.tvAddress.setText(model.getAddress());

        //if (model.getExcerpt() != null) {
        //    holder.tvContent.setText(model.getExcerpt().getRendered());
        //}
        //if (model.getBetter_featured_image() != null) {
        //    Glide.with(activity).load(model.getBetter_featured_image().getSource_url()).into(holder.imgCover);
        //}
        return convertView;
    }

    public static class ViewHolder {
        TextView tvName;
        TextView tvEmail;
        ImageView imgCover;
        TextView tvAddress;
    }
}
