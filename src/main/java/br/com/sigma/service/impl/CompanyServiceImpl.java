package br.com.sigma.service.impl;

import br.com.sigma.model.Company;
import br.com.sigma.service.CompanyService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends GenericServiceImpl<Company,Integer> implements CompanyService {
}
