package com.example.controller;

import com.example.dto.DataResponse;
import com.example.service.DataService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/get-data")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DataController {

    @Autowired
    private DataService dataService;

    @Operation(summary = "Get all data into DB", description = "Get all data into DB")
    @GetMapping
    public ResponseEntity<List<DataResponse>> getAllData() {
        List<DataResponse> responses = dataService.getAllData();
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Get Extern data from a REST API", description = "Retrieves a data entry by its ID")
    @GetMapping("/{idExtern}")
    public ResponseEntity<DataResponse> getDataByIdExtern(@PathVariable Long idExtern) {
        DataResponse response = dataService.getDataFromRestById(idExtern);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

}