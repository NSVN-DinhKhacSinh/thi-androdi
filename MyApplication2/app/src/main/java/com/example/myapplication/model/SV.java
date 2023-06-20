package com.example.myapplication.model;

import java.io.Serializable;

public class SV implements Serializable {
    private  int ma_Sv;
    private String ten_Sv;
    private String nam_sinh;
    private String que_quan;
    private String nam_hoc;

    public SV() {
    }

    public SV(int ma_Sv, String ten_Sv, String nam_sinh, String que_quan, String nam_hoc) {
        this.ma_Sv = ma_Sv;
        this.ten_Sv = ten_Sv;
        this.nam_sinh = nam_sinh;
        this.que_quan = que_quan;
        this.nam_hoc = nam_hoc;
    }

    public SV(String ten_Sv, String nam_sinh, String que_quan, String nam_hoc) {
        this.ten_Sv = ten_Sv;
        this.nam_sinh = nam_sinh;
        this.que_quan = que_quan;
        this.nam_hoc = nam_hoc;
    }

    public int getMa_Sv() {
        return ma_Sv;
    }

    public void setMa_Sv(int ma_Sv) {
        this.ma_Sv = ma_Sv;
    }

    public String getTen_Sv() {
        return ten_Sv;
    }

    public void setTen_Sv(String ten_Sv) {
        this.ten_Sv = ten_Sv;
    }

    public String getNam_sinh() {
        return nam_sinh;
    }

    public void setNam_sinh(String nam_sinh) {
        this.nam_sinh = nam_sinh;
    }

    public String getQue_quan() {
        return que_quan;
    }

    public void setQue_quan(String que_quan) {
        this.que_quan = que_quan;
    }

    public String getNam_hoc() {
        return nam_hoc;
    }

    public void setNam_hoc(String nam_hoc) {
        this.nam_hoc = nam_hoc;
    }
}
