package br.com.sigma.repository;

import br.com.sigma.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateReposiory extends JpaRepository<State,Integer> {
}
