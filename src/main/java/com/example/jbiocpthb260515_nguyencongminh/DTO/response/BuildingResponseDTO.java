package com.example.jbiocpthb260515_nguyencongminh.DTO.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuildingResponseDTO {

    private String buildingName;

    private Double buildingArea;

    private String areaUnit;

    private LocalDateTime startDate;

    private Integer time;

    private String timeUnit;

    private String design;

    private String content;

    private Integer status;
}
