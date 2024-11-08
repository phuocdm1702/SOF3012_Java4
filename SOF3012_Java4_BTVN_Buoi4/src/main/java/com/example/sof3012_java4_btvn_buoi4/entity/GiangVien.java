package com.example.sof3012_java4_btvn_buoi4.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "giang_vien")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ma;
    private String ten;
    private Long tuoi;
    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
    @Column(name = "dia_chi")
    private String diaChi;
}
