package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.escalab.model.Maquina;

public interface IMaquinaService extends ICRUD<Maquina>{
	Page<Maquina> listarPageable(Pageable pageable);
}	
