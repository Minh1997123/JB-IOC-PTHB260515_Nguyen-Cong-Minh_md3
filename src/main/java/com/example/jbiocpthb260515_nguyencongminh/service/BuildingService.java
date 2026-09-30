package com.example.jbiocpthb260515_nguyencongminh.service;

import com.example.jbiocpthb260515_nguyencongminh.DTO.request.BuildingRequestDTO;
import com.example.jbiocpthb260515_nguyencongminh.DTO.response.APIResponse;
import com.example.jbiocpthb260515_nguyencongminh.DTO.response.BuildingResponseDTO;
import com.example.jbiocpthb260515_nguyencongminh.entity.Building;
import com.example.jbiocpthb260515_nguyencongminh.repository.BuildingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

//    lấy toàn bộ danh sách và phân trang
    public APIResponse<List<BuildingResponseDTO>> getBuildings(Integer page , Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Building> buildingPage = buildingRepository.findAll(pageRequest);

        List<BuildingResponseDTO> buildingResponseDTOS = buildingPage.getContent().stream().map((building)->{
            return  new BuildingResponseDTO(building.getBuildingName() , building.getBuildingArea(), building.getAreaUnit() , building.getStartDate(), building.getTime() , building.getTimeUnit(),building.getDesign()  , building.getContent() , building.getStatus());
        }).toList();
        return new APIResponse<>(true , "success" , buildingResponseDTOS , 200 );
    }

//    tao moi
    public  APIResponse<String> createBuilding( BuildingRequestDTO buildingRequestDTO) throws Exception {
            Boolean hasBuildingName = buildingRepository.existsBuildingByBuildingName(buildingRequestDTO.getBuildingName());
            if(hasBuildingName){
                throw new Exception("trùng tên");
            }
            Building building = Building.builder().buildingName(buildingRequestDTO.getBuildingName()).buildingArea(buildingRequestDTO.getBuildingArea()).areaUnit(buildingRequestDTO.getAreaUnit()).startDate(buildingRequestDTO.getStartDate()).time(buildingRequestDTO.getTime()).timeUnit(buildingRequestDTO.getTimeUnit()).design(buildingRequestDTO.getDesign()).content(buildingRequestDTO.getContent()).status(buildingRequestDTO.getStatus()).build();

            buildingRepository.save(building);
            return new APIResponse(true ,  "success" , "Đã tạo thành công" , 201 );

    }

//    cap nhap
    public APIResponse<String>  updateBuilding( Long id , BuildingRequestDTO buildingRequestDTO ) throws Exception {
        Boolean hasBuildingName = buildingRepository.existsBuildingByBuildingName(buildingRequestDTO.getBuildingName());
        if(hasBuildingName){
            throw new Exception("trùng tên");
        }
        Building building = Building.builder().id(id).buildingName(buildingRequestDTO.getBuildingName()).buildingArea(buildingRequestDTO.getBuildingArea()).areaUnit(buildingRequestDTO.getAreaUnit()).startDate(buildingRequestDTO.getStartDate()).time(buildingRequestDTO.getTime()).timeUnit(buildingRequestDTO.getTimeUnit()).design(buildingRequestDTO.getDesign()).content(buildingRequestDTO.getContent()).status(buildingRequestDTO.getStatus()).build();
        buildingRepository.save(building);
        return new APIResponse(true ,  "success" , "Đã cập nhật thành công" , 200 );
    }

//    cap nhap trang thai
    public APIResponse<String>  editStatusBuilding( Long id ,Integer status) throws Exception {
        buildingRepository.updateStatusBuilding(id , status);
        return new APIResponse(true ,  "success" , "Đã cập nhật thành công" , 200 );
    }


//    tim kiem
    public APIResponse<List<BuildingResponseDTO>> searchBuildings(String buildingName , Integer status ,  Integer page, Integer pageSize , String sortBy ) {
        List<BuildingResponseDTO>  buildingList = new ArrayList<>();
        Pageable pageRequest = PageRequest.of(page, pageSize, Sort.by(sortBy));

        if(sortBy.equals("buildingName")){
            Page<Building> buildingPage = buildingRepository.findByBuildingNameContainingIgnoreCase(buildingName, pageRequest);
            buildingPage.getContent().forEach((building)->{
                 BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO(building.getBuildingName() , building.getBuildingArea(), building.getAreaUnit() , building.getStartDate(), building.getTime() , building.getTimeUnit(),building.getDesign()  , building.getContent() , building.getStatus());
                 buildingList.add(buildingResponseDTO);
             });
        }
        if (sortBy.equals("status")){
            Page<Building> buildingPage  = buildingRepository.findByStatus(status, pageRequest);
            buildingPage.getContent().forEach((building)->{
                BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO(building.getBuildingName() , building.getBuildingArea(), building.getAreaUnit() , building.getStartDate(), building.getTime() , building.getTimeUnit(),building.getDesign()  , building.getContent() , building.getStatus());
                buildingList.add(buildingResponseDTO);
            });

        }
        return new APIResponse(true ,  "success" , buildingList , 200 );
    }
}
