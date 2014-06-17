package com.pracas.domain.controller;

import java.util.Set;

import com.pracas.domain.model.Partida;

public interface ICtrlPartida {

	public Partida getPartida(int idPartida);
	
	public Set<Partida> getAll();
	
}
