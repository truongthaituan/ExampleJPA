package com.example.demo.services;

import com.example.demo.models.ThucUong;

import java.util.List;
import java.util.Optional;

public interface ThucUongService {
    List<ThucUong> getAllTU();
    Optional<ThucUong> getTUById(Long id);
    void saveOrUpdate(ThucUong thucUong);
    void deleteTU(Long id);
}
