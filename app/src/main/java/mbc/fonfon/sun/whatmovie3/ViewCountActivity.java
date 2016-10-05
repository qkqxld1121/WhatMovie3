package mbc.fonfon.sun.whatmovie3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class ViewCountActivity extends AppCompatActivity {

    ListView listView;
    int index;
    String str;
    String resName;
    String packName; // 패키지명
    int resID;


    Button Movie;
    Button Number;
    Button Star;
    Button Genre;
    Button Search_button;


    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_count);

        listView = (ListView) findViewById(R.id.movielist);
        Movie = (Button)findViewById(R.id.movie);
        Number = (Button)findViewById(R.id.number);
        Star = (Button)findViewById(R.id.star);
        Genre = (Button)findViewById(R.id.genre);
        Search_button = (Button)findViewById(R.id.serchgo);

        Movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(), WhatMovie3Activity.class);
                finish();
                startActivity(intent);
            }
        });


        Number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(), ViewCountActivity.class);
                finish();
                startActivity(intent);
            }
        });

        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(), StarActivity.class);
                finish();
                startActivity(intent);
            }
        });

        Genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='액션'";
                String color = "Action";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                startActivity(intent);
            }
        });

        Search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });

        index = 0;

        final ArrayList<MyCustomDTO> list = new ArrayList<MyCustomDTO>();

        MyCustomDTOAdapter adapter = new MyCustomDTOAdapter(getApplicationContext(),
                R.layout.mymovielist,
                list);

        myHelper = new myDBHelper(this);

        sqlDB = myHelper.getReadableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM movieDRAMA order by viewcount desc",null);


        while(cursor.moveToNext())
        {
            str = cursor.getString(8);
            resName = "@drawable/"+str+"0";
            packName = this.getPackageName();
            resID = getResources().getIdentifier(resName, "drawable", packName);
            list.add(new MyCustomDTO(cursor.getString(1),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    resID));

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),MovieInfoActivity.class);

                intent.putExtra("title",list.get(position).getTitle());
                startActivity(intent);
            }
        });

        cursor.close();
        sqlDB.close();
        listView.setAdapter(adapter);
    }

}