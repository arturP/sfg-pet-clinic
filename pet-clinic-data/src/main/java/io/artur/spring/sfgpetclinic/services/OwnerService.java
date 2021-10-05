package io.artur.spring.sfgpetclinic.services;

import io.artur.spring.sfgpetclinic.model.Owner;


/**
 *
 */
public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
