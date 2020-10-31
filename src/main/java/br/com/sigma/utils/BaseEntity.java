package br.com.sigma.utils;

public interface BaseEntity<ID> {
    ID getId();
    void setId(ID id);
}
