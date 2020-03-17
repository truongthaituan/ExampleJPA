package com.example.demo.controllers;

import com.example.demo.models.ThucUong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ThucUongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Optional;

@Controller
public class ThucUongController {
    @Autowired
    ThucUongService thucUongService;
    @RequestMapping(value = "thucuongs", method = RequestMethod.GET)
    public ResponseEntity<List<ThucUong>> findAllProduct() {
        List<ThucUong> thucUongs = thucUongService.getAllTU();
        if (thucUongs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(thucUongs, HttpStatus.OK);
    }
    @RequestMapping(value = "/thucuongs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ThucUong> getThucUongById(@PathVariable("id") Long id) {
        Optional<ThucUong> thucUong = thucUongService.getTUById(id);
        if (!((Optional) thucUong).isPresent()) {
            return new ResponseEntity<>(thucUong.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(thucUong.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/thucuongs",
            method = RequestMethod.POST)
    public ResponseEntity<ThucUong> createThucuong(@RequestBody ThucUong thucUong, UriComponentsBuilder builder) {
        thucUongService.saveOrUpdate(thucUong);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(thucUong.getMatu()).toUri());
        return new ResponseEntity<>(thucUong, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/thucuongs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ThucUong> updateThucuong(@PathVariable("id") Long id, @RequestBody ThucUong thucUong) {
        Optional<ThucUong> currentThucuong = thucUongService.getTUById(id);
        if (!currentThucuong.isPresent()) {
            return new ResponseEntity<>(currentThucuong.get(), HttpStatus.NO_CONTENT);
        }
        currentThucuong.get().setTenTU(thucUong.getTenTU());
        currentThucuong.get().setPrice(thucUong.getPrice());
        currentThucuong.get().setMota(thucUong.getMota());
        thucUongService.saveOrUpdate(currentThucuong.get());
        return new ResponseEntity<>(currentThucuong.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/thucuongs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ThucUong> deleteThucuong(@PathVariable("id") Long id) {
        Optional<ThucUong> thucUong = thucUongService.getTUById(id);
        if (!thucUong.isPresent()) {
            return new ResponseEntity<>(thucUong.get(), HttpStatus.NO_CONTENT);
        }
        thucUongService.deleteTU(id);
        return new ResponseEntity<>(thucUong.get(), HttpStatus.OK);
    }
}
