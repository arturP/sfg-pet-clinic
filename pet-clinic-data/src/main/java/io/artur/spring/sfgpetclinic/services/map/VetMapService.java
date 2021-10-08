package io.artur.spring.sfgpetclinic.services.map;

import io.artur.spring.sfgpetclinic.model.Speciality;
import io.artur.spring.sfgpetclinic.model.Vet;
import io.artur.spring.sfgpetclinic.services.SpecialityService;
import io.artur.spring.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 *
 */
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            Set<Speciality> specialities = object.getSpecialities();
            if (specialities != null) {
                specialities.forEach(speciality -> {
                    if (speciality.getId() == null) {
                        speciality.setId(specialityService.save(speciality).getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }
}
