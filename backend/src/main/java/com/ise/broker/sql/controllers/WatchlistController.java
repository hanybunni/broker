package com.ise.broker.sql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ise.broker.sql.entities.Watchlist;
import com.ise.broker.sql.repositories.WatchlistRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/watchlists")

public class WatchlistController {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @GetMapping
    public List<Watchlist> getAllWatchlist() {
        return watchlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Watchlist> getWatchlistById(@PathVariable Long id) {
        return watchlistRepository.findById(id);
    }
    
}
