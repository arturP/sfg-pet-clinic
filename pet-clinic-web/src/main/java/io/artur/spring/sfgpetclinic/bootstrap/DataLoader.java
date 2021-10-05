package io.artur.spring.sfgpetclinic.bootstrap;

import io.artur.spring.sfgpetclinic.model.Owner;
import io.artur.spring.sfgpetclinic.model.Vet;
import io.artur.spring.sfgpetclinic.services.OwnerService;
import io.artur.spring.sfgpetclinic.services.VetService;
import io.artur.spring.sfgpetclinic.services.map.OwnerServiceMap;
import io.artur.spring.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Weston");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        ownerService.save(owner1);
        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);
        System.out.println("Loaded Vets.....");
    }
}
