package com.salesianostriana.kilo.services;

import com.salesianostriana.kilo.entities.Clase;
import com.salesianostriana.kilo.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository repository;

    public Clase add(Clase c) {
        return repository.save(c);
    }

    public Optional<Clase> findById(Long id) {
        return repository.findById(id);
    }

    public List<Clase> findAll(){
        return repository.findAll();
    }
}