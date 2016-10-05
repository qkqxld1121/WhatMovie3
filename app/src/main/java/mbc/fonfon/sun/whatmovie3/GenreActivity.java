package mbc.fonfon.sun.whatmovie3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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
public class GenreActivity extends AppCompatActivity {

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
    Button Action;
    Button SF;
    Button Horror;
    Button Drama;
    Button Comedy;
    Button Ani;
    Button Melo;
    Button More;


    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_distinct);

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

        Action = (Button)findViewById(R.id.action);
        Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='액션'";
                String color = "Action";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);

            }
        });

        SF = (Button)findViewById(R.id.sf);
        SF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='SF'";
                String color = "SF";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);
            }
        });

        Horror = (Button)findViewById(R.id.horror);
        Horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='공포'";
                String color = "Horror";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);
            }
        });

        Drama = (Button)findViewById(R.id.drama);
        Drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='드라마'";
                String color = "Drama";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);
            }
        });

        Comedy = (Button)findViewById(R.id.comedy);
        Comedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='로코'";
                String color = "Comedy";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);
            }
        });

        Ani = (Button)findViewById(R.id.ani);
        Ani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='코메디'";
                String color = "Ani";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);
            }
        });

        Melo = (Button)findViewById(R.id.melo);
        Melo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='멜로'";
                String color = "Melo";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
                startActivity(intent);
            }
        });

        More = (Button)findViewById(R.id.more);
        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genre = "SELECT * FROM movieDRAMA where genre ='더보기'";
                String color = "More";
                Intent intent =  new Intent(getApplicationContext(), GenreActivity.class);
                intent.putExtra("genre", genre);
                intent.putExtra("color", color);
                finish();
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

        Intent intent = getIntent();
        String genre = intent.getStringExtra("genre");
        String color2 = intent.getStringExtra("color");

        if(color2.equals("Action")) {
            Action.setTextColor(Color.RED);
        }
        if(color2.equals("SF")) {
            SF.setTextColor(Color.RED);
        }
        if(color2.equals("Horror")) {
            Horror.setTextColor(Color.RED);
        }
        if(color2.equals("Drama")) {
            Drama.setTextColor(Color.RED);
        }
        if(color2.equals("Comedy")) {
            Comedy.setTextColor(Color.RED);
        }
        if(color2.equals("Ani")) {
            Ani.setTextColor(Color.RED);
        }
        if(color2.equals("Melo")) {
            Melo.setTextColor(Color.RED);
        }
        if(color2.equals("More")) {
            More.setTextColor(Color.RED);
        }


        cursor = sqlDB.rawQuery(genre,null);


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
