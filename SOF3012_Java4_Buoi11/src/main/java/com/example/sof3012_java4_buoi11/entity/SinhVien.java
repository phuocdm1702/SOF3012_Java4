package com.example.sof3012_java4_buoi11.entity;




public class SinhVien {
    private String maSSV;
    private String ten;
    private int tuoi;

    public SinhVien() {
    }

    public SinhVien(String maSSV, String ten, int tuoi) {
        this.maSSV = maSSV;
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public String getMaSSV() {
        return maSSV;
    }

    public void setMaSSV(String maSSV) {
        this.maSSV = maSSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSSV='" + maSSV + '\'' +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}
