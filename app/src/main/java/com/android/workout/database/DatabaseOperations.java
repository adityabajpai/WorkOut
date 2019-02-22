package com.android.workout.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.workout.adapters.WorkoutData;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations{
    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqlite;

    public DatabaseOperations(Context context) {
        this.dbHelper = new DatabaseHelper(context);
    }

    public int CheckDBEmpty() {
        this.sqlite = this.dbHelper.getReadableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT count(*) FROM ");
        stringBuilder.append(DatabaseHelper.f3363c);
        Cursor rawQuery = this.sqlite.rawQuery(stringBuilder.toString(), null);
        rawQuery.moveToFirst();
        return rawQuery.getInt(0) > 0 ? 1 : 0;
    }

    public int deleteTable() {
        this.sqlite = this.dbHelper.getWritableDatabase();
        int delete = this.sqlite.delete(DatabaseHelper.f3363c, null, null);
        this.sqlite.close();
        return delete;
    }

    public List<WorkoutData> getAllDaysProgress() {
        List<WorkoutData> arrayList = new ArrayList();
        this.sqlite = this.dbHelper.getReadableDatabase();
        if (this.sqlite != null) {
            SQLiteDatabase sQLiteDatabase = this.sqlite;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select * from ");
            stringBuilder.append(DatabaseHelper.f3363c);
            Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
            if (rawQuery.moveToFirst()) {
                while (!rawQuery.isAfterLast()) {
                    WorkoutData workoutData = new WorkoutData();
                    workoutData.setDay(rawQuery.getString(rawQuery.getColumnIndex(DatabaseHelper.f3364d)));
                    workoutData.setProgress(rawQuery.getFloat(rawQuery.getColumnIndex(DatabaseHelper.f3365e)));
                    rawQuery.moveToNext();
                    arrayList.add(workoutData);
                }
            }
            this.sqlite.close();
        }
        return arrayList;
    }

    public float getExcDayProgress(String str) {
        this.sqlite = this.dbHelper.getReadableDatabase();
        float f = 0.0f;
        if (this.sqlite != null) {
            SQLiteDatabase sQLiteDatabase = this.sqlite;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select * from ");
            stringBuilder.append(DatabaseHelper.f3363c);
            stringBuilder.append(" where ");
            stringBuilder.append(DatabaseHelper.f3364d);
            stringBuilder.append(" = '");
            stringBuilder.append(str);
            stringBuilder.append("'");
            Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
            if (rawQuery.moveToFirst()) {
                f = rawQuery.getFloat(rawQuery.getColumnIndex(DatabaseHelper.f3365e));
            }
            this.sqlite.close();
        }
        return f;
    }

    public long insertExcALLDayData() {
        long j = 0;
        try {
            this.sqlite = this.dbHelper.getWritableDatabase();
            for (int i = 1; i <= 30; i++) {
                ContentValues contentValues = new ContentValues();
                String str = DatabaseHelper.f3364d;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Day ");
                stringBuilder.append(i);
                contentValues.put(str, stringBuilder.toString());
                contentValues.put(DatabaseHelper.f3365e, Double.valueOf(0.0d));
                if (this.sqlite != null) {
                    try {
                        j = this.sqlite.insert(DatabaseHelper.f3363c, null, contentValues);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
            this.sqlite.close();
            return j;
        } catch (Throwable e2) {
            e2.printStackTrace();
            this.sqlite.close();
            return j;
        }
    }

    public int insertExcDayData(String str, float f) {
        int i = 0;
        try {
            this.sqlite = this.dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.f3365e, Float.valueOf(f));
            if (this.sqlite != null) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("UPDATE ");
                    stringBuilder.append(DatabaseHelper.f3363c);
                    stringBuilder.append(" SET ");
                    stringBuilder.append(DatabaseHelper.f3365e);
                    stringBuilder.append(" = ");
                    stringBuilder.append(f);
                    stringBuilder.append(" WHERE ");
                    stringBuilder.append(DatabaseHelper.f3364d);
                    stringBuilder.append(" = '");
                    stringBuilder.append(str);
                    stringBuilder.append("'");
                    stringBuilder.toString();
                    SQLiteDatabase sQLiteDatabase = this.sqlite;
                    String str2 = DatabaseHelper.f3363c;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(DatabaseHelper.f3364d);
                    stringBuilder2.append("='");
                    stringBuilder2.append(str);
                    stringBuilder2.append("'");
                    i = sQLiteDatabase.update(str2, contentValues, stringBuilder2.toString(), null);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            this.sqlite.close();
            return i;
        } catch (Throwable e2) {
            e2.printStackTrace();
            this.sqlite.close();
            return 0;
        }
    }
}
