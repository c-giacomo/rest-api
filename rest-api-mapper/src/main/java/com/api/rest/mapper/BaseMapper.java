package com.api.rest.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<T, V> {

    V map(T t);

    T mapReverse(V v);

    T mapReverse(V v, @MappingTarget T t);
}
