package com.example.jbiocpthb260515_nguyencongminh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "building_name" , nullable = false , unique = true)
    private String buildingName;

    @Column(name = "building_area" , nullable = false)
    private Double buildingArea;

    @Column(name = "area_unit" , nullable = false)
    private String areaUnit;

    @Column(name  = "start_date" , nullable = false)
    private LocalDateTime startDate;

    @Column(name = "time" , nullable = false)
    private Integer time;

    @Column(name = "time_unit" , nullable = false)
    private String timeUnit;

    @Column(name = "design" , nullable = false)
    private String design;

    @Column(name = "content" , nullable = true)
    private String content;

    @Column(name = "status" , columnDefinition = "SMALLINT DEFAULT '1'")
    private Integer status;
}
