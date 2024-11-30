/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author azizb
 */
@Entity
@Table(name = "bengkel")
public class ModelBengkel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private int no;
    
    @Column(name = "namabarang", nullable = false, length = 50)
    private String namabarang;
    
    @Column(name = "kategori", nullable = false, length = 25)
    private String kategori;
    
    @Column(name = "stok", nullable = false)
    private int stok;
    
    @Column(name = "harga", nullable = false)
    private float harga;

    public ModelBengkel(int no, String namabarang, String kategori, int stok, float harga) {
        this.no = no;
        this.namabarang = namabarang;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public ModelBengkel() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNamaBarang() {
        return namabarang;
    }

    public void setNamaBarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }  
}
