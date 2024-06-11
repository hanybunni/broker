package com.ise.broker.sql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ise.broker.sql.entities.Asset;
import com.ise.broker.sql.repositories.AssetRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")

public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Asset> getAssetById(@PathVariable Long id) {
        return assetRepository.findById(id);
    }
    
}
