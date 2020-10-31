package br.com.sigma.utils;

public interface FilterMapper<E extends BaseEntity, F> {
    E convertFilterToEntity(F filterDTO);
}
