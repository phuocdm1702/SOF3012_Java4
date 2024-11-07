package com.example.sof3012_java4_buoi1.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "category")
@Entity // TRUY VAN TREN THUC THE => KHONG CO ENTITY
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {
    /**
     * J3: JDBC - Java DataBase Connectity
     * => Truy van SQL
     * J4: Hibernate => Truy van HQL(Hibernate Query Languagge)
     * ORM(Object Relational Mapping)
     * => Mapping ca quan he (1-1, 1-N...)
     * => Truy van tren thuc the
     * =>Bien cac class trong entity => Thanh Table
     */

    @Id // Mapping khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // KHOA CHINH TU TANG
    @Column(name = "id") // TEN CUA 1 COT TRONG DB
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;
    @Column(name = "category_name")
    private String categoryName;


}
