package io.artur.spring.sfgpetclinic.services.map;

import io.artur.spring.sfgpetclinic.model.Visit;
import io.artur.spring.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 *
 */
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null ||
        visit.getPet().getType() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit!");
        }

        return super.save(visit);
    }
}