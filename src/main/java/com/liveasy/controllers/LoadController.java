package com.liveasy.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.liveasy.entities.Load;
import com.liveasy.services.LoadService;

@RestController
@RequestMapping("/loads")
public class LoadController {
    @Autowired
    private LoadService loadService;

    @GetMapping
    public ResponseEntity<List<Load>> getAllLoads() {
        List<Load> loads = loadService.getAllLoads();
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Load load = loadService.getLoadById(loadId);
        return new ResponseEntity<>(load, HttpStatus.OK);
    }

    @GetMapping("/shipper/{shipperId}")
    public ResponseEntity<List<Load>> getLoadsByShipperId(@PathVariable UUID shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    @PostMapping("/shipper/{shipperId}")
    public ResponseEntity<Load> saveLoad(@PathVariable UUID shipperId, @RequestBody Load load) {
        Load savedLoad = loadService.saveLoadWithShipper(shipperId, load);
        return new ResponseEntity<>(savedLoad, HttpStatus.CREATED);
    }

    @PutMapping("/shipper/{shipperId}/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @RequestBody Load updatedLoad,@PathVariable UUID shipperId) {
        Load updatedLoadEntity = loadService.updateLoad(loadId, updatedLoad,shipperId);

        return new ResponseEntity<>(updatedLoadEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}