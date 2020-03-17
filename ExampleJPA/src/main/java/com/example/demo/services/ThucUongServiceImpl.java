package com.example.demo.services;

import com.example.demo.models.ThucUong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.ThucUongRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ThucUongServiceImpl implements ThucUongService {
  @Autowired
  ThucUongRepository thucUongRepo;
    @Override
    public List<ThucUong> getAllTU() {
        return (List<ThucUong>) thucUongRepo.findAll();
    }

    @Override
    public Optional<ThucUong> getTUById(Long id) {
        return thucUongRepo.findById(id);
    }

    @Override
    public void saveOrUpdate(ThucUong thucuong) {
        thucUongRepo.save(thucuong);
    }

    @Override
    public void deleteTU(Long id) {
        thucUongRepo.deleteById(id);
    }
}
