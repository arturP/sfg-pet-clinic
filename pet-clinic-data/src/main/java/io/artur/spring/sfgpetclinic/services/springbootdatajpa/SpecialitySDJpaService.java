package io.artur.spring.sfgpetclinic.services.springbootdatajpa;

import io.artur.spring.sfgpetclinic.model.Speciality;
import io.artur.spring.sfgpetclinic.repositories.SpecialtyRepository;
import io.artur.spring.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Speciality findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();

        specialtyRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
