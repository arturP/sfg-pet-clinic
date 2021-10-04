package io.artur.spring.sfgpetclinic.services;

import io.artur.spring.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 *
 */
public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
