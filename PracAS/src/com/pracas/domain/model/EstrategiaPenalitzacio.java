package com.pracas.domain.model;

public class EstrategiaPenalitzacio implements IEstrategiaPuntuacio {

	private int puntuacioEncert;
	private int puntuacioError;
	
	@Override
	public int calcularPuntuacio(int nEncerts, int nErrors) {
		return ((nEncerts * puntuacioEncert) - (nErrors * puntuacioError));
	}

	public void setPuntuacioEncert(int puntuacioEncert) {
		this.puntuacioEncert = puntuacioEncert;
	}

	public void setPuntuacioError(int puntuacioError) {
		this.puntuacioError = puntuacioError;
	}

}
