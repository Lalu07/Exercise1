package firdaus.rizkika.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return dataKontak.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataKontak.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview,null);
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(dataKontak.classNamaArrayList.get(i).getName());

        return view;
    }

    Context mContex;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;

    public ListViewAdapter(Context context){
        mContex = context;
        inflater = LayoutInflater.from(mContex);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(dataKontak.classNamaArrayList);
    }

    public class ViewHolder{
        TextView name;
    }
}
