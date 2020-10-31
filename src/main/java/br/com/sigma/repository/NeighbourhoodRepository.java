package br.com.sigma.repository;

import br.com.sigma.model.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeighbourhoodRepository extends JpaRepository<Neighbourhood, Integer> {
}
