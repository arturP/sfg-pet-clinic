package io.artur.spring.sfgpetclinic.services.map;

import io.artur.spring.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private Long OWNER_ID = 1L;
    private String LAST_NAME = "Murphy";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(OWNER_ID);
        owner.setLastName(LAST_NAME);
        ownerMapService.save(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNER_ID);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void saveWithId() {
        Long secondId = 2L;
        Owner second = new Owner();
        second.setId(secondId);
        Owner savedOwner = ownerMapService.save(second);

        assertEquals(secondId, savedOwner.getId());

    }

    @Test
    public void saveNoId() {
        Owner owner = new Owner();
        Owner saved = ownerMapService.save(owner);

        assertNotNull(saved);
        assertNotNull(saved.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertTrue(ownerMapService.findAll().isEmpty());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);
        assertTrue(ownerMapService.findAll().isEmpty());
    }

    @Test
    void findByLastName() {
        Owner ownerWithName = new Owner();
        String lastName = "LastNameToFind";
        ownerWithName.setLastName(lastName);
        Owner saved = ownerMapService.save(ownerWithName);
        assertNotNull(saved);

        Owner findOwner = ownerMapService.findByLastName(lastName);
        assertNotNull(findOwner);
        assertEquals(lastName, findOwner.getLastName());
    }
}