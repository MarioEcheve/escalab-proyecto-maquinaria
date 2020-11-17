package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.TipoMaquina;

public interface ITipoMaquinaRepo extends JpaRepository<TipoMaquina, Integer> {

}
