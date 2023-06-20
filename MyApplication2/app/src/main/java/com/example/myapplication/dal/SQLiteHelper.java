package com.example.myapplication.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Lop;
import com.example.myapplication.model.SV;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DBN ="tkb.db";
    private static int version =1;
    public SQLiteHelper(@Nullable Context context) {
        super(context, DBN, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE SinhVien (" +
                "maSV  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenSV TEXT, namSinh TEXT, queQuan TEXT, namHoc TEXT )";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE Class (" +
                " maClass INTEGER PRIMARY KEY AUTOINCREMENT, tenClass TEXT, moTa TEXT) ";

        db.execSQL(sql2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public List<SV> getAll(){
        List<SV> listSV = new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
//        db.execSQL("DELETE FROM SinhVien");
        Cursor rs= db.query("SinhVien",null, null,null,null,null,null);
        while (rs!=null && rs.moveToNext()){
            int maSV=rs.getInt(0);
            String tenSv = rs.getString(1);
            String namSinh = rs.getString(2);
            String queQuan = rs.getString(3);
            String namHoc = rs.getString(4);
            listSV.add(new SV(maSV,tenSv,namSinh,queQuan,namHoc));
        }
        return listSV;
    }

    public long addSV(SV i){
        ContentValues contentValues =new ContentValues();
        contentValues.put("tenSV",i.getTen_Sv());
        contentValues.put("namSinh",i.getNam_sinh());
        contentValues.put("queQuan",i.getQue_quan());
        contentValues.put("namHoc",i.getNam_hoc());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.insert("SinhVien",null,contentValues);
    }
    public int updateSV(SV i){
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenSV",i.getTen_Sv());
        contentValues.put("namSinh",i.getNam_sinh());
        contentValues.put("queQuan",i.getQue_quan());
        contentValues.put("namHoc",i.getNam_hoc());
        SQLiteDatabase db = getWritableDatabase();
        return db.update("SinhVien",contentValues,"maSv=?",new String[]{ Integer.toString(i.getMa_Sv()) } );
    }
    public int deleteSV(int i){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("SinhVien","maSv=?",new String[]{ Integer.toString(i) } );
    }

    public List<Lop> getAllClass(){
        List<Lop> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor rs = db.query("Class",null,null,null,null,null,null);
        while (rs!=null && rs.moveToNext()){
            int ma=rs.getInt(0);
            String ten = rs.getString(1);
            String mota= rs.getString(2);
            list.add(new Lop(ma,ten,mota));
        }
        return  list;
    }

    public long addClass(Lop i){
        ContentValues values = new ContentValues();
        values.put("tenClass",i.getTen_lop());
        values.put("moTa",i.getMo_ta());
        SQLiteDatabase sb= getWritableDatabase();
        return  sb.insert("Class",null,values);
    }

    public int updateClass(Lop i){
        ContentValues values = new ContentValues();
        values.put("tenClass",i.getTen_lop());
        values.put("moTa",i.getMo_ta());
        SQLiteDatabase db =getWritableDatabase();
        return  db.update("Class",values,"maClass=?",new String[]{Integer.toString(i.getMa_lop())});
    }

    public int delteClass(int i){
        SQLiteDatabase db =getWritableDatabase();
        return  db.delete("Class","maClass=?",new String[]{Integer.toString(i)});
    }
}
