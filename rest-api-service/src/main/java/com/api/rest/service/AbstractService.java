package com.api.rest.service;

import com.api.rest.mapper.BaseMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*****
 *
 * @param <I> id of object to search
 * @param <R> repository
 * @param <M> mapper
 * @param <E> entity type
 * @param <D> dto type
 */

@RequiredArgsConstructor
public abstract class AbstractService<I, R extends JpaRepository<E, I>, M extends BaseMapper<E, D>, E, D> {

    protected final M mapper;
    protected final R repository;

    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::map);
    }

    public List<D> findAll() {
        return repository.findAll().stream().map(mapper::map).toList();
    }

    public D findById(I id) {
        return repository.findById(id).map(mapper::map).orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
    }

    public D create(D dto) {
        E entity = mapper.mapReverse(dto);
        return mapper.map(repository.save(entity));
    }

    public D update(I id, D dto) {
        E entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
        mapper.mapReverse(dto, entity);
        return mapper.map(repository.save(entity));
    }

    public void delete(I id) {
        repository.deleteById(id);
    }
}
