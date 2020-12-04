package ar.edu.unlam.pb1.JuegosJava;

public class Posiciones {
	String nombrePosicion;
	int valorInicial;

	public Posiciones(String nombrePosicion, int valorInicial) {
		this.nombrePosicion = nombrePosicion;
		this.valorInicial = valorInicial;

	}

	public String getNombrePosicion() {
		return nombrePosicion;
	}

	public void setNombrePosicion(String nombrePosicion) {
		this.nombrePosicion = nombrePosicion;
	}

	public int getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}

	public int cargaDePosiciones() {
		int cargaDePosiciones = 1;
		return cargaDePosiciones;
	}

	public String toString() {

		return nombrePosicion;

	}

}
