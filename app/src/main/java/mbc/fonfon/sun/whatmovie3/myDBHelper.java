package mbc.fonfon.sun.whatmovie3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by soldesk on 2016-09-08.
 */
public class myDBHelper extends SQLiteOpenHelper {
    public myDBHelper(Context context){
        super(context,"movieDB",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE movieDRAMA ( id integer primary key autoincrement, name text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists movieDRAMA");
        onCreate(db);
    }
}