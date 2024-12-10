package com.example.th02296_sd19309_final_sof3012.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "phong_ban")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PhongBan {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "loai_phong_ban_id",referencedColumnName = "id")
    private LoaiPhongBan lpb;

    @Column(name = "ma")
    private String ma;


    @Column(name = "ten")
    private String ten;

    @Column(name = "so_luong")
    private Integer soLuong;


    @Column(name = "ghi_chu")
    private String ghiChu;

}