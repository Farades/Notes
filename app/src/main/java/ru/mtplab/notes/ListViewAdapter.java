package ru.mtplab.notes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *  ListViewAdaper - кастомный адаптер для связи модели и ListView
 */
public class ListViewAdapter extends BaseAdapter {

    private ArrayList<Note> dataList;
    private Context context;

    public ListViewAdapter(Context context, ArrayList<Note> dataList) {
        super();
        this.dataList = dataList;
        this.context = context;
    }

    public void clear() {
        dataList.clear();
        this.notifyDataSetChanged();
    }

    public void add(Note note) {
        dataList.add(note);
        this.notifyDataSetChanged();
        Log.e("Debug", "Add note [" + note + "] to note list");
    }

    public void remove(int position) {
        if (dataList != null) {
            dataList.remove(position);
            this.notifyDataSetChanged();
        }
    }

    public void update(int index, String data) {
        dataList.get(index).update(data);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int index) {
        return dataList.get(index);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_item, null, false);
        TextView itemNumber = (TextView) itemView.findViewById(R.id.iNumber);
        TextView itemTitle = (TextView) itemView.findViewById(R.id.iTitle);
        TextView itemDate = (TextView) itemView.findViewById(R.id.iDate);

        itemNumber.setText(String.valueOf(arg0 + 1));
        itemTitle.setText(dataList.get(arg0).toString());
        itemDate.setText(dataList.get(arg0).getDate());

        return itemView;
    }
}