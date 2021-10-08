package io.artur.spring.sfgpetclinic.repositories;

import io.artur.spring.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
