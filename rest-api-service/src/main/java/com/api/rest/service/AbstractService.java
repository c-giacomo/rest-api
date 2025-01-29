package com.api.rest.service;

import com.api.rest.mapper.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/*****
 *
 * @param <I> id of object to search
 * @param <R> repository
 * @param <M> mapper
 * @param <T> source type
 * @param <V> return type
 */


public abstract class AbstractService<I, R extends JpaRepository<T, I>, M extends BaseMapper<T, V>, T, V> {

    protected M mapper;
    protected R repository;

    public Page<V> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::map);
    }

    public List<V> findAll() {
        return repository.findAll().stream().map(mapper::map).toList();
    }

    public Optional<V> findById(I id) {
        return repository.findById(id).map(obj -> mapper.map(obj));
    }
}
