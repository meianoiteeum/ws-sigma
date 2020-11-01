package br.com.sigma.service;

import br.com.sigma.dto.CompanyDTO;
import br.com.sigma.model.Company;
import br.com.sigma.utils.GenericService;
import org.springframework.http.ResponseEntity;

public interface CompanyService extends GenericService<Company, Integer> {
    ResponseEntity create(CompanyDTO company);
    ResponseEntity read(Integer id);
    ResponseEntity update(Integer id, CompanyDTO company);
    ResponseEntity delete(Integer id);
}
