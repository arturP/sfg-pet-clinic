package io.artur.spring.sfgpetclinic.repositories;

import io.artur.spring.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
