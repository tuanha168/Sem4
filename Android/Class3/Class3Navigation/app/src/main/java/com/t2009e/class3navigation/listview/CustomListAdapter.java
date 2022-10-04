package com.t2009e.class3navigation.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.t2009e.class3navigation.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    List<ListItem> listJobs;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context aContext, List<ListItem> list) {
        this.listJobs = list;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listJobs.size();
    }

    @Override
    public Object getItem(int i) {
        return listJobs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null) {
            view = layoutInflater.inflate(R.layout.list_row, null);
            viewHolder = new ViewHolder();

            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            viewHolder.tvPosition = (TextView) view.findViewById(R.id.tvPosition);
            viewHolder.tvLocation = (TextView) view.findViewById(R.id.tvLocation);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvTitle.setText(listJobs.get(i).getTitle());
        viewHolder.tvPosition.setText(listJobs.get(i).getPosition());
        viewHolder.tvLocation.setText(listJobs.get(i).getLocation());

        return view;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvPosition;
        TextView tvLocation;
    }
}
