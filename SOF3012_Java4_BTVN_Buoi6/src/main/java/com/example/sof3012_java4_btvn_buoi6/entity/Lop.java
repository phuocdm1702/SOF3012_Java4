package com.example.sof3012_java4_btvn_buoi6.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "lop")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ma;
    private String ten;
}
