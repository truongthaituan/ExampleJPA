package com.example.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "thucuong")
public class ThucUong {
    @Id
    @Column(name = "MaTU")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matu;
    @Column(name = "tenTU")
    private String tenTU;
    @Column(name = "price")
    private Float price;
    @Column(name = "mota")
    private String mota;

    public ThucUong(String tenTU, Float price, String mota) {
        this.tenTU = tenTU;
        this.price = price;
        this.mota = mota;
    }

    public ThucUong() {
    }


    public Long getMatu() {
        return matu;
    }

    public void setMatu(Long matu) {
        this.matu = matu;
    }

    public String getTenTU() {
        return tenTU;
    }

    public void setTenTU(String tenTU) {
        this.tenTU = tenTU;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
