package com.example.jbiocpthb260515_nguyencongminh.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BuildingRequestDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String buildingName;

    @NotNull
    private Double buildingArea;

    @NotBlank
    @Size(min = 1, max = 100)
    private String areaUnit;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private Integer time;

    @NotBlank
    @Size(min = 1, max = 10)
    private String timeUnit;

    @NotBlank
    @Size(min = 1, max = 255)
    private String design;

    @NotBlank
    @Size(min = 1, max = 255)
    private String content;

    @NotNull
    private Integer status;
}
