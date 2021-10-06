package io.artur.spring.sfgpetclinic.bootstrap;

import io.artur.spring.sfgpetclinic.model.Owner;
import io.artur.spring.sfgpetclinic.model.PetType;
import io.artur.spring.sfgpetclinic.model.Vet;
import io.artur.spring.sfgpetclinic.services.OwnerService;
import io.artur.spring.sfgpetclinic.services.PetTypeService;
import io.artur.spring.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);
        System.out.println("Loaded PetTypes.....");

        Owner owner = new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Weston");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        ownerService.save(owner1);
        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Wendy");
        vet2.setLastName("Knox");
        vetService.save(vet2);
        System.out.println("Loaded Vets.....");
    }
}
