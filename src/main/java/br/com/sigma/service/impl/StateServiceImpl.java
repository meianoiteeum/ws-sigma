package br.com.sigma.service.impl;

import br.com.sigma.model.State;
import br.com.sigma.service.StateService;
import br.com.sigma.utils.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl extends GenericServiceImpl<State,Integer> implements StateService {
}
