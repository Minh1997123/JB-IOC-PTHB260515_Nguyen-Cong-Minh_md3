package com.example.jbiocpthb260515_nguyencongminh.controller;

import com.example.jbiocpthb260515_nguyencongminh.DTO.request.BuildingRequestDTO;
import com.example.jbiocpthb260515_nguyencongminh.DTO.response.APIResponse;
import com.example.jbiocpthb260515_nguyencongminh.DTO.response.BuildingResponseDTO;
import com.example.jbiocpthb260515_nguyencongminh.repository.BuildingRepository;
import com.example.jbiocpthb260515_nguyencongminh.service.BuildingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/building")
public class BuildingController {
        private final BuildingService buildingService;

        public BuildingController(BuildingService buildingService) {
            this.buildingService = buildingService;
        }


    @GetMapping
    public ResponseEntity<APIResponse<List<BuildingResponseDTO>>> getBuildings(@RequestParam(defaultValue = "0" ,required = false ) Integer page, @RequestParam(defaultValue = "5" ,required = false) Integer pageSize) {
        APIResponse<List<BuildingResponseDTO>>  data =  buildingService.getBuildings(page, pageSize);
        return   ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<APIResponse<String>> createBuildings(@Valid @RequestBody BuildingRequestDTO buildingRequestDTO) throws Exception {
            APIResponse<String> data = buildingService.createBuilding(buildingRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<String>>  updateBuildings( @PathVariable Long id , @Valid @RequestBody BuildingRequestDTO buildingRequestDTO) throws Exception  {
        APIResponse<String> data = buildingService.updateBuilding(id ,buildingRequestDTO);
        return ResponseEntity.ok(data);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<APIResponse<String>>  editBuildings(@PathVariable Long id , @RequestParam Integer status) throws Exception {
            APIResponse<String>  data = buildingService.editStatusBuilding(id , status);
            return ResponseEntity.ok(data);
    }

    @GetMapping("/search")
    public ResponseEntity<APIResponse<List<BuildingResponseDTO>>>  deleteBuildings(@RequestParam String buildingName, @RequestParam Integer status  , @RequestParam Integer page , @RequestParam Integer pageSize , @RequestParam String sortBy) throws Exception {
        APIResponse<List<BuildingResponseDTO>> data = buildingService.searchBuildings(buildingName , status , page , pageSize , sortBy);
        return ResponseEntity.ok(data);
    }
}
