package io.artur.spring.sfgpetclinic.services.springbootdatajpa;

import io.artur.spring.sfgpetclinic.model.Owner;
import io.artur.spring.sfgpetclinic.repositories.OwnerRepository;
import io.artur.spring.sfgpetclinic.repositories.PetRepository;
import io.artur.spring.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    private Owner owner;
    private static final Long OWNER_ID = 1L;
    private static final String OWNER_LAST_NAME = "Murphy";
    private static final String OWNER_FIRST_NAME = "John";
    private static final String OWNER_ADDRESS = "st. 1st";
    private static final String OWNER_TELEPHONE = "123-123-3344";

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(OWNER_ID);
        owner.setTelephone(OWNER_TELEPHONE);
        owner.setFirstName(OWNER_FIRST_NAME);
        owner.setLastName(OWNER_LAST_NAME);
        owner.setAddress(OWNER_ADDRESS);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner found = service.findById(OWNER_ID);

        verify(ownerRepository).findById(anyLong());
        assertNotNull(found);
        assertEquals(OWNER_ID, found.getId());
    }

    @Test
    void findAll() {
        Owner second = new Owner();
        second.setId(2L);
        Owner third = new Owner();
        third.setId(3L);
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);
        owners.add(second);
        owners.add(third);
        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> found = service.findAll();

        verify(ownerRepository).findAll();
        assertNotNull(found);
        assertEquals(owners.size(), found.size());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner saved = service.save(owner);
        verify(ownerRepository).save(any());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        service.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        String lastName = "Smith";
        Long id = 1L;
        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(lastName);

        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);

        Owner foundOwner = service.findByLastName(lastName);
        assertNotNull(foundOwner);
        assertEquals(id, foundOwner.getId());
        assertEquals(lastName, foundOwner.getLastName());

        verify(ownerRepository).findByLastName(anyString());
    }
}