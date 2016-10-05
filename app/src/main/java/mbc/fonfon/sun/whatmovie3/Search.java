package mbc.fonfon.sun.whatmovie3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by soldesk on 2016-09-09.
 */
public class Search extends Activity {

    ListView listView;
    String str;
    String resName;
    String packName; // 패키지명
    int resID;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    Cursor cursor;

    ArrayAdapter<String> adapter;
    ArrayList<String> arr = new ArrayList<String>();

    EditText Editgo;
    Button Buttongo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ww);

        // 1.데이터만들기
        //  arr.add("Java");
        //  arr.add("Jsp");
        //  arr.add("Android");
        Editgo = (EditText) findViewById(R.id.editgo);
        Buttongo = (Button) findViewById(R.id.buttongo);

        Buttongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String go = Editgo.getText().toString(); // 하정우 입력하면 "하정우" 받아옴
                Intent intent = new Intent(getApplicationContext(), Search.class);
                intent.putExtra("go", go);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.movielist);
        ArrayList<MyCustomDTO> list = new ArrayList<MyCustomDTO>();
        MyCustomDTOAdapter adapter = new MyCustomDTOAdapter(getApplicationContext(),
                R.layout.mymovielist,
                list);
        myHelper = new myDBHelper(this);

        sqlDB = myHelper.getReadableDatabase();

        Intent intent = getIntent();
        String go = intent.getStringExtra("go");
        cursor = sqlDB.rawQuery("SELECT * FROM movieDRAMA where actor = '" + go + "' or title = '" + go + "'", null);

        while (cursor.moveToNext()) {
            str = cursor.getString(7);
            resName = "@drawable/" + str + "0";
            packName = this.getPackageName();
            resID = getResources().getIdentifier(resName, "drawable", packName);
            list.add(new MyCustomDTO(cursor.getString(1), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                    resID));
        }

        cursor.close();
        sqlDB.close();
        listView.setAdapter(adapter);
    }
}