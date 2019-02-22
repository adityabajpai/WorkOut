package com.android.workout.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static int f3361a = 1;
    /* renamed from: b */
    static String f3362b = "FitDB";
    /* renamed from: c */
    static String f3363c = "exc_day";
    /* renamed from: d */
    static String f3364d = "day";
    /* renamed from: e */
    static String f3365e = "progress";
    /* renamed from: f */
    String f3366f;

    public DatabaseHelper(Context context) {
        super(context, f3362b, null, f3361a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ");
        stringBuilder.append(f3363c);
        stringBuilder.append(" (");
        stringBuilder.append(f3364d);
        stringBuilder.append(" TEXT, ");
        stringBuilder.append(f3365e);
        stringBuilder.append(" REAL)");
        this.f3366f = stringBuilder.toString();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(this.f3366f);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
