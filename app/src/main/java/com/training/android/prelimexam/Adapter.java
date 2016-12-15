package com.training.android.prelimexam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dyste on 12/16/2016.
 */

public class Adapter extends ArrayAdapter<Task> {

    private Context mContext;
    private int mResource;
    private List<Task> mList;


    public Adapter(Context context, int resource, List<Task> list) {
        super(context, resource, list);

        this.mContext = context;
        this.mList = list;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Task task = mList.get(position);
        if (task != null) {
            if (holder.mEtTitle != null) {
                holder.mEtTitle.setText("Title: " + task.getTitle());
            }
            if (holder.mEtDesc != null) {
                holder.mEtDesc.setText("Description: " + task.getDesc());
            }
            if (holder.mEtTime != null) {
                holder.mEtTime.setText("Time " + task.getTime());
            }
            if (holder.mEtDate != null) {
                holder.mEtDate.setText("Date:" + task.getDate());
            }

        }
        return convertView;
    }

    public static class ViewHolder {
        TextView mEtTitle;
        TextView mEtDesc;
        TextView mEtTime;
        TextView mEtDate;

        public ViewHolder(View v) {
            TextView mEtTitle = (TextView) v.findViewById(R.id.etTitle);
            TextView mEtDesc = (TextView) v.findViewById(R.id.etDesc);
            TextView mEtTime = (TextView) v.findViewById(R.id.etTime);
            TextView mEtDate = (TextView) v.findViewById(R.id.etDate);

        }

    }
}
