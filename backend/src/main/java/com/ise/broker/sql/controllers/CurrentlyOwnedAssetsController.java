package com.ise.broker.sql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ise.broker.sql.entities.CurrentlyOwnedAssets;
import com.ise.broker.sql.repositories.CurrentlyOwnedAssetsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currentlyOwnedAssets")

public class CurrentlyOwnedAssetsController {

    @Autowired
    private CurrentlyOwnedAssetsRepository currentlyOwnedAssetsRepository;

    @GetMapping
    public List<CurrentlyOwnedAssets> getAllCurrentlyOwnedAssets() {
        return currentlyOwnedAssetsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CurrentlyOwnedAssets> getCurrentlyOwnedAssetsById(@PathVariable Long id) {
        return currentlyOwnedAssetsRepository.findById(id);
    }
    
}
