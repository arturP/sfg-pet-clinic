package io.artur.spring.sfgpetclinic.repositories;

import io.artur.spring.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
