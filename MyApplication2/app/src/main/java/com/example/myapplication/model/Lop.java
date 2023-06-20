package com.example.myapplication.model;

import java.io.Serializable;

public class Lop implements Serializable {
    private int ma_lop;
    String ten_lop, mo_ta;

    public Lop() {
    }

    public Lop(int ma_lop, String ten_lop, String mo_ta) {
        this.ma_lop = ma_lop;
        this.ten_lop = ten_lop;
        this.mo_ta = mo_ta;
    }

    public Lop(String ten_lop, String mo_ta) {
        this.ten_lop = ten_lop;
        this.mo_ta = mo_ta;
    }

    public int getMa_lop() {
        return ma_lop;
    }

    public void setMa_lop(int ma_lop) {
        this.ma_lop = ma_lop;
    }

    public String getTen_lop() {
        return ten_lop;
    }

    public void setTen_lop(String ten_lop) {
        this.ten_lop = ten_lop;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
}
