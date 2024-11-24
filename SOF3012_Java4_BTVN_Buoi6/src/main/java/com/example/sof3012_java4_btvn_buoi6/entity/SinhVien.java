package com.example.sof3012_java4_btvn_buoi6.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "sinh_vien")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ma;

    private String ten;

    private Long tuoi;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "gioi_tinh")
    private int gioiTinh;

    @ManyToOne // pho bien
    @JoinColumn(name = "lop_id", referencedColumnName = "id")
    private Lop lop;

}
