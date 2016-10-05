package mbc.fonfon.sun.whatmovie3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by soldesk on 2016-09-08.
 */

public class MovieInfoActivity extends AppCompatActivity{

    myDBHelper myHelper;
    Cursor cursor;
    SQLiteDatabase sqlDB;
    TextView title,actor,summary;
    ImageView poster,background;
    String resName,packName,resName2,packName2;
    int resID,resID2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_movie);

        title = (TextView)findViewById(R.id.title2);
        actor = (TextView)findViewById(R.id.actor2);
        summary = (TextView)findViewById(R.id.summary);

        poster = (ImageView)findViewById(R.id.second);
        background = (ImageView)findViewById(R.id.first);

        Intent intent = getIntent();
        String text = intent.getStringExtra("title");

       myHelper = new myDBHelper(this);
       sqlDB = myHelper.getReadableDatabase();
       cursor = sqlDB.rawQuery("SELECT * FROM movieDRAMA where title = '"+text+"'",null);

        while(cursor.moveToNext()) {

            title.setText(cursor.getString(1));
            actor.setText(cursor.getString(6));
            summary.setText(cursor.getString(7));

            resName = "@drawable/" + cursor.getString(8)+"0";
            packName = this.getPackageName();
            resID = getResources().getIdentifier(resName, "drawable", packName);

            poster.setImageResource(resID);

        }

        sqlDB.close();
        cursor.close();
    }
}
