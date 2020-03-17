package com.example.demo.repositories;

import com.example.demo.models.ThucUong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ThucUongRepository extends JpaRepository<ThucUong, Long> {

}
