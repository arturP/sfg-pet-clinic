package io.artur.spring.sfgpetclinic.services;

import io.artur.spring.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 *
 */
public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
