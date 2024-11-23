package com.example.sof3012_java4_btvn_buoi9.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chiTietSanPham")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCTSP")
    private int id;

    @Column
    private int soLuongTon;
    @Column
    private Float donGia;
    @Column(name = "barcode")
    private Long barCode;

    @Column
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "idDonViTinh",referencedColumnName = "idDonViTinh")
    private DonViTinh donViTinh;

}
