package br.com.sigma.service.impl;

import br.com.sigma.model.Country;
import br.com.sigma.service.CountryService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends GenericServiceImpl<Country,Integer> implements CountryService {
}
