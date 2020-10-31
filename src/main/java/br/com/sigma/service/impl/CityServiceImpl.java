package br.com.sigma.service.impl;

import br.com.sigma.model.City;
import br.com.sigma.service.CityService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends GenericServiceImpl<City,Integer> implements CityService {
}
