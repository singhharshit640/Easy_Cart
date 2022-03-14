package com.sleepingpandaaa.easycart;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "QRdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table QRData(qrcode VARCHAR unique, name TEXT NOT NULL, price INTEGER NOT NULL)");
        DB.execSQL("insert into QRData values('204603202674', 'Lays', '20.0')");
        DB.execSQL("insert into QRData values('241310706996', 'Kit Kat', '10.0')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists QRData");
        onCreate(DB);
    }


    public Cursor readparticulardata(String qrcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from QRData where qrcode = " + qrcode, null);
        return cursor;
    }
}



