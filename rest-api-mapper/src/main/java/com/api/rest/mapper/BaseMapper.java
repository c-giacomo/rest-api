package com.api.rest.mapper;

public interface BaseMapper<T, V> {

    V map(T t);

    T mapReverse(V v);
}
