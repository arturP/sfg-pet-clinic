package io.artur.spring.sfgpetclinic.services.map;

import io.artur.spring.sfgpetclinic.model.BaseEntity;

import java.util.*;

/**
 *
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> storage = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(storage.values());
    }

    T findById(ID id) {
        return storage.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            storage.put(object.getId(), object);
        }
        return object;
    }

    void deleteById(ID id) {
        storage.remove(id);
    }

    void delete(T object) {
        storage.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        if (this.storage.isEmpty()) {
            return 1L;
        } else {
            return Collections.max(this.storage.keySet()) + 1L;
        }
    }
}
