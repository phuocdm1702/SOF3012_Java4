package com.example.sof3012_java4_btvn_buoi5.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "may_tinh")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MayTinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ma;

    @Column(name = "ten")
    private String ten;
    @Column(name = "gia")
    private float gia;

    @Column(name = "bo_nho")
    private String boNho;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "hang")
    private String hang;

    @Column(name = "mieu_ta")
    private String mieuTa;


}
