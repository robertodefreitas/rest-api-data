package com.example.service;

import com.example.dto.DataRequest;
import com.example.dto.DataResponse;
import com.example.entity.DataEntity;
import com.example.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public DataResponse saveData(DataRequest request) {
        DataEntity entity = new DataEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());

        DataEntity saved = dataRepository.save(entity);
        return convertToResponse(saved);
    }

    public DataResponse getDataById(Long id) {
        return dataRepository.findById(id)
                .map(this::convertToResponse)
                .orElse(null);
    }

    public List<DataResponse> getAllData() {
        return dataRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public List<DataResponse> getDataByEmail(String email) {
        return dataRepository.findByEmail(email)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public DataResponse updateData(Long id, DataRequest request) {
        return dataRepository.findById(id)
                .map(entity -> {
                    entity.setName(request.getName());
                    entity.setEmail(request.getEmail());
                    entity.setMessage(request.getMessage());
                    DataEntity updated = dataRepository.save(entity);
                    return convertToResponse(updated);
                })
                .orElse(null);
    }

    public void deleteData(Long id) {
        dataRepository.deleteById(id);
    }

    private DataResponse convertToResponse(DataEntity entity) {
        return new DataResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getMessage(),
                entity.getCreatedAt()
        );
    }
}