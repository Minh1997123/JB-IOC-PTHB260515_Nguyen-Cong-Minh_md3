package com.example.jbiocpthb260515_nguyencongminh.repository;

import com.example.jbiocpthb260515_nguyencongminh.entity.Building;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    Boolean findByBuildingName(String buildingName);
    Page<Building> findByBuildingNameContainingIgnoreCase(String buildingName , Pageable pageRequest);
    Page<Building> findByStatus(Integer status, Pageable pageRequest);

    Boolean existsBuildingByBuildingName(String buildingName);

    @Modifying
    @Transactional
    @Query("UPDATE Building b SET b.status = :status WHERE b.id = :id AND b.status != 2")
    void updateStatusBuilding(@Param("id") Long id, @Param("status") Integer status);

}
