package com.example.bartek.marcin.listViewClasses;

import android.content.ContentProvider;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bartek.marcin.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 26.04.2016.
 */
public class DataListAdapter extends ArrayAdapter{
    List list = new ArrayList();

    static class DataHandler{
        TextView templateField;
        EditText templateInput;
    }

    public DataListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout,parent,false);
            handler = new DataHandler();
            handler.templateField = (TextView) row.findViewById(R.id.template_field);
            handler.templateInput = (EditText) row.findViewById(R.id.template_input);
            row.setTag(handler);
        }
        else{
            handler = (DataHandler) row.getTag();
        }

        TemplatesDataListProvider listProvider;
        listProvider = (TemplatesDataListProvider) this.getItem(position);
        handler.templateField.setText(listProvider.getDataField());
        handler.templateInput.setText(listProvider.getInputField());
        return row;
    }
}
