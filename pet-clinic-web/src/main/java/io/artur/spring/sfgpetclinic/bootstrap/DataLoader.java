package io.artur.spring.sfgpetclinic.bootstrap;

import io.artur.spring.sfgpetclinic.model.*;
import io.artur.spring.sfgpetclinic.services.OwnerService;
import io.artur.spring.sfgpetclinic.services.PetTypeService;
import io.artur.spring.sfgpetclinic.services.SpecialityService;
import io.artur.spring.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
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
        owner.setAddress("123 Brickelel");
        owner.setCity("Miami");
        owner.setTelephone("11223344");

        Pet dog1 = new Pet();
        dog1.setType(savedDog);
        dog1.setBirthDate(LocalDate.now());
        dog1.setOwner(owner);
        dog1.setName("Rosco");

        owner.getPets().add(dog1);

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        owner1.setAddress("123 Brickelel");
        owner1.setCity("Miami");
        owner1.setTelephone("11223344");

        Pet fionaCat = new Pet();
        fionaCat.setName("Miauu");
        fionaCat.setOwner(owner1);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setType(savedCat);
        owner1.getPets().add(fionaCat);

        ownerService.save(owner1);

        System.out.println("Loaded Owners.....");

        Speciality radiologySpec = new Speciality();
        radiologySpec.setDescription("radiology");

        Speciality surgerySpec = new Speciality();
        surgerySpec.setDescription("surgery");

        Speciality dentSpec = new Speciality();
        dentSpec.setDescription("dental");

        Speciality savedRadiology = specialityService.save(radiologySpec);
        Speciality savedSurgery = specialityService.save(surgerySpec);
        Speciality savedDentist = specialityService.save(dentSpec);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Wendy");
        vet2.setLastName("Knox");
        vet2.getSpecialities().add(savedDentist);
        vetService.save(vet2);
        System.out.println("Loaded Vets.....");
    }
}
