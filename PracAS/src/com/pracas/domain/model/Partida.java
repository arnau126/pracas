package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pracas.domain.controller.AdapterFactory;

public class Partida {
	
	@Id
	private int idPartida;
	@Basic
	private boolean acabada;
	@Basic
	private boolean guanyada;
	@Basic
	private int errors;
	//@Basic
	//private Jugador jugadorPartidaActual;
	//private Jugador jugadorPartidaJugada; // TODO
	@ManyToOne
	@JoinColumn(name="ID_PARAULA")
	private Paraula paraula;
	
	private IEstrategiaPuntuacio estrategiaPuntuacio;
	
	private List<Casella> caselles;

	public Partida(int _idPartida, Categoria _categoria, Jugador _jugadorPartidaActual) {
		super();
		acabada = false;
		guanyada = false;
		errors = 0;
		idPartida = _idPartida;
		if (_jugadorPartidaActual.getMes2PartidesGuanyades()) {
			estrategiaPuntuacio = AdapterFactory.getInstance().getEstrategiaPenalitzacio();
		} else {
			estrategiaPuntuacio = AdapterFactory.getInstance().getEstrategiaNoPenalitzacio();
		}
		paraula = _categoria.getParaulaAleatoria();
		caselles = new ArrayList<Casella>();
		int pos = 0;
		for (char ch : paraula.getNom().toCharArray()) {
			//Casella c = new Casella(pos, ch); // TODO
			//caselles.add(c)
			pos++;
		}
		_jugadorPartidaActual.setPartidaActual(this);
	}
	
	public void getDadesInicials() {
		Parametres.getInstance().getNombreMaximErrors();
		//estrategiaPuntuacio.calcularPuntuacio(nEncerts, nErrors); //TODO
	}
	
	public void ferJugada(int pos, Lletra lletra) {
		Casella casella = caselles.get(pos);
		if (!casella.intentarLletra(lletra)) {
			errors++;
			if (errors > Parametres.getInstance().getNombreMaximErrors()) // TODO > o >= ??
				acabada = true;
			int numEncerts = 0;
			for (Casella c : caselles) {
				if (c.isEncert())
					numEncerts++;
			}
			if (numEncerts == caselles.size()) {
				acabada = true;
				guanyada = true;
			}
			estrategiaPuntuacio.calcularPuntuacio(numEncerts, errors);
		}
	}
	
	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public boolean isAcabada() {
		return acabada;
	}

	public void setAcabada(boolean acabada) {
		this.acabada = acabada;
	}

	public boolean isGuanyada() {
		return guanyada;
	}

	public void setGuanyada(boolean guanyada) {
		this.guanyada = guanyada;
	}

	public int getErrors() {
		return errors;
	}

	public void setErrors(int errors) {
		this.errors = errors;
	}

	/*public Jugador getJugadorPartidaActual() {
		return jugadorPartidaActual;
	}

	public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
		this.jugadorPartidaActual = jugadorPartidaActual;
	}*/
	
	

}
