package mbc.fonfon.sun.whatmovie3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-08.
 */
public class MyCustomDTOAdapter extends BaseAdapter {


    Context ctx;
    int layout;
    ArrayList<MyCustomDTO> list;
    LayoutInflater inf;

    public MyCustomDTOAdapter(Context ctx, int layout, ArrayList<MyCustomDTO> list){
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;

        inf=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=inf.inflate(layout,null);
        }


        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView view_count = (TextView)convertView.findViewById(R.id.view_count);
        TextView director = (TextView)convertView.findViewById(R.id.director);
        TextView date = (TextView)convertView.findViewById(R.id.date);
        ImageView img = (ImageView)convertView.findViewById(R.id.poster);

        MyCustomDTO dto = list.get(position);

        title.setText(dto.getTitle());
        view_count.setText(dto.getView_count());
        director.setText(dto.getDirector());
        date.setText(dto.getDate());

        img.setImageResource(dto.imgName);

        return convertView;
    }
}