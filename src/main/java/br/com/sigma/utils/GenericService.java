package br.com.sigma.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<E extends BaseEntity<ID>, ID> {
    E saveOrUpdate(E entity);

    Page<E> getAllPaginated(Example<E> example, Pageable pageable);

    Optional<E> get(ID id);

    void removeById(ID id);
}
