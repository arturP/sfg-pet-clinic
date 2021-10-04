package io.artur.spring.sfgpetclinic.services;

import io.artur.spring.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 *
 */
public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
