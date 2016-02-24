package com.example.anhtt.leangson.typetoken;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anhtt.leangson.R;

import java.util.List;

/**
 * Created by anhtt on 09/08/2015.
 */
public class CustomAdapter extends ArrayAdapter<ListHelper> {
    List<ListHelper> listHelpers;
    private Context mContext;
    private LayoutInflater layoutInflater;
    public CustomAdapter(Context context,int posstion,List<ListHelper> listHelpers){
        super(context,posstion,listHelpers);
        this .mContext = context;
        this.listHelpers = listHelpers;
        this.layoutInflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listHelpers.size();
    }

    public class ViewHolder{
        TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView ==null){
            convertView =layoutInflater.inflate(R.layout.item_custom,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tvGson);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ListHelper listHelper = listHelpers.get(position);
        viewHolder.textView.setText(listHelper.getName() +"  - " +listHelper.getApi() + " - " +listHelper.getVersion());
        return convertView;
    }
}
