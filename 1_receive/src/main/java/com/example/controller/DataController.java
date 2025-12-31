package com.example.controller;

import com.example.dto.DataRequest;
import com.example.dto.DataResponse;
import com.example.service.DataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;


@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DataController {

    @Autowired
    private DataService dataService;

    @Operation(summary = "Create data entry", description = "Saves a new data entry")
    @PostMapping
    public ResponseEntity<DataResponse> createData(@Valid @RequestBody DataRequest request) {
        DataResponse response = dataService.saveData(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getDataById(@PathVariable Long id) {
        DataResponse response = dataService.getDataById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DataResponse>> getAllData() {
        List<DataResponse> responses = dataService.getAllData();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<DataResponse>> getDataByEmail(@PathVariable String email) {
        List<DataResponse> responses = dataService.getDataByEmail(email);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> updateData(
            @PathVariable Long id,
            @Valid @RequestBody DataRequest request) {
        DataResponse response = dataService.updateData(id, request);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        dataService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}