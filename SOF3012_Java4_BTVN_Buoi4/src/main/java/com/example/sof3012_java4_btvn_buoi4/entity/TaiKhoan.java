package com.example.sof3012_java4_btvn_buoi4.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tai_khoan")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TaiKhoan {
    private String username;
    private String pass;
}
