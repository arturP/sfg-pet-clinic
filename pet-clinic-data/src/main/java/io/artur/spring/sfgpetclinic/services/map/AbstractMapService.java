package io.artur.spring.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> storage = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(storage.values());
    }

    T findById(ID id) {
        return storage.get(id);
    }

    T save(ID id, T object) {
        storage.put(id, object);
        return object;
    }

    void deleteById(ID id) {
        storage.remove(id);
    }

    void delete(T object) {
        storage.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
