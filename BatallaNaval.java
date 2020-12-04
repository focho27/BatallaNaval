package ar.edu.unlam.pb1.JuegosJava;

public class BatallaNaval {
	String juego = " ";
	private Posiciones posiciones[][];
	private Posiciones posicionesBarco2[][];
	private Posiciones posicionesBarco3[][];
	private Posiciones posicionesBarco4[][];
	private boolean barco1Cayo = false;
	private boolean barco2Cayo = false;
	private boolean barco3Cayo = false;
	private int contador;
	private int contadorBarco1;
	private int contador1;
	private int contador2;
	private int cargaDeBarcoPosibilidad;

	public BatallaNaval() {
		this.posiciones = new Posiciones[7][4];
		this.contador = 0;
		this.contadorBarco1 = 0;
		this.contador1 = 0;
		this.contador2 = 0;
		this.cargaDeBarcoPosibilidad = 0;
		this.posicionesBarco2 = new Posiciones[7][4];
		this.posicionesBarco3 = new Posiciones[7][4];
		this.posicionesBarco4 = new Posiciones[7][4];
	}

	/*
	 * public void validarPosiciones() { for (int z =0;z<posiciones.length;z++) {
	 * for(int h=0;h<posiciones[z].length;h++ ) { if((z == 0 && h == 3)||( z == 1 &&
	 * h == 3 )||( z == 2 && h == 3 )||( z == 3 && h == 3 )||( z == 4 && h == 3 )||(
	 * z == 5 && h == 3 )||( z == 6 && h == 3 )) {
	 * 
	 * } } } }
	 */
	public boolean cargarBarco(int z, int y) {
		cargaDeBarcoPosibilidad = 0;
		boolean barcoCargado = false;
		for (int i = 0; i < posiciones.length; i++) {
			for (int f = 0; f < posiciones[i].length; f++) {
				if ((posiciones[i][f].getValorInicial() == z) || (posiciones[i][f].getValorInicial() == y)) {
					if ((posiciones[i][f].getValorInicial() == z)) {
						cargaDeBarcoPosibilidad++;
					}
					if ((posiciones[i][f].getValorInicial() == (y)) && (posiciones[i][f].getValorInicial() == (z + 4)
							|| posiciones[i][f].getValorInicial() == (z - 4)
							|| posiciones[i][f].getValorInicial() == (z + 1)
							|| posiciones[i][f].getValorInicial() == (z - 1))) {
						cargaDeBarcoPosibilidad++;

					}
				}
			}

		}
		if (cargaDeBarcoPosibilidad == 2) {
			barcoCargado = true;
			for (int i = 0; i < posiciones.length; i++) {
				for (int f = 0; f < posiciones[i].length; f++) {
					if ((posiciones[i][f].getValorInicial() == z) || (posiciones[i][f].getValorInicial() == y)) {
						posicionesBarco2[i][f] = posiciones[i][f];
						posiciones[i][f].setNombrePosicion("O");

					}

				}
			}
		}

		return barcoCargado;
	}

	public boolean cargarBarco(int z, int y, int x) {
		cargaDeBarcoPosibilidad = 0;
		boolean barcoCargado = false;
		for (int i = 0; i < posiciones.length; i++) {
			for (int f = 0; f < posiciones[i].length; f++) {
				if ((posiciones[i][f].getValorInicial() == z) || (posiciones[i][f].getValorInicial() == y)
						|| (posiciones[i][f].getValorInicial() == x)) {
					if ((posiciones[i][f].getValorInicial() == z)) {
						cargaDeBarcoPosibilidad++;
					}
					if ((posiciones[i][f].getValorInicial() == y) && (posiciones[i][f].getValorInicial() == (z + 4)
							|| posiciones[i][f].getValorInicial() == (z - 4)
							|| posiciones[i][f].getValorInicial() == (z + 1)
							|| posiciones[i][f].getValorInicial() == (z - 1))) {
						cargaDeBarcoPosibilidad++;
					}
					// (posiciones[i][f].getValorInicial()==(z+8)||posiciones[i][f].getValorInicial()==(z-8)||posiciones[i][f].getValorInicial()==(z+2)||posiciones[i][f].getValorInicial()==(z-2))
					if ((posiciones[i][f].getValorInicial() == x)) {
						if (y == (z + 1)) {
							if ((x == (z + 2)
									&& (y != 3 && y != 7 && y != 11 && y != 15 && y != 19 && y != 23 && y != 27))
									|| (x == (z - 1))) {
								cargaDeBarcoPosibilidad++;
							}
						} else if (y == (z - 1)) {
							if ((x == (z - 2)
									&& (y != 0 && y != 4 && y != 8 && y != 12 && y != 16 && y != 20 && y != 24))
									|| (x == (z + 1))) {
								cargaDeBarcoPosibilidad++;
							}
						} else if (y == (z + 4)) {
							if (x == (z + 8) || (x == (z - 4))) {
								cargaDeBarcoPosibilidad++;
							}

						} else if (y == (z - 4)) {
							if (x == (z - 8) || (x == (z + 4))) {
								cargaDeBarcoPosibilidad++;
							}

						}
					}

				}
			}
		}
		if (cargaDeBarcoPosibilidad == 3) {
			barcoCargado = true;
			for (int i = 0; i < posiciones.length; i++) {
				for (int f = 0; f < posiciones[i].length; f++) {
					if ((posiciones[i][f].getValorInicial() == z) || (posiciones[i][f].getValorInicial() == y)
							|| (posiciones[i][f].getValorInicial() == x)) {
						posicionesBarco3[i][f] = posiciones[i][f];
						posiciones[i][f].setNombrePosicion("O");
					}

				}
			}
		}

		return barcoCargado;
	}

	public boolean cargarBarco(int z, int y, int x, int w) {
		cargaDeBarcoPosibilidad = 0;
		boolean barcoCargado = false;
		for (int i = 0; i < posiciones.length; i++) {
			for (int f = 0; f < posiciones[i].length; f++) {
				if ((posiciones[i][f].getValorInicial() == z) || (posiciones[i][f].getValorInicial() == y)
						|| (posiciones[i][f].getValorInicial() == x) || (posiciones[i][f].getValorInicial() == w)) {
					if ((posiciones[i][f].getValorInicial() == z)) {
						cargaDeBarcoPosibilidad++;
					}
					if ((posiciones[i][f].getValorInicial() == y) && (posiciones[i][f].getValorInicial() == (z + 4)
							|| posiciones[i][f].getValorInicial() == (z - 4)
							|| posiciones[i][f].getValorInicial() == (z + 1)
							|| posiciones[i][f].getValorInicial() == (z - 1))) {
						cargaDeBarcoPosibilidad++;
					}
					if ((posiciones[i][f].getValorInicial() == x)) {
						if (y == (z + 1)) {
							if ((x == (z + 2)
									&& (y != 3 && y != 7 && y != 11 && y != 15 && y != 19 && y != 23 && y != 27))
									|| (x == (z - 1))) {
								cargaDeBarcoPosibilidad++;
							}
						} else if (y == (z - 1)) {
							if ((x == (z - 2)
									&& (y != 0 && y != 4 && y != 8 && y != 12 && y != 16 && y != 20 && y != 24))
									|| (x == (z + 1))) {
								cargaDeBarcoPosibilidad++;
							}
						} else if (y == (z + 4)) {
							if (x == (z + 8) || (x == (z - 4))) {
								cargaDeBarcoPosibilidad++;
							}

						} else if (y == (z - 4)) {
							if (x == (z - 8) || (x == (z + 4))) {
								cargaDeBarcoPosibilidad++;
							}

						}
					}
					if ((posiciones[i][f].getValorInicial() == w)) {
						if (y == (z + 1)) {
							if (((w == (z + 3))
									&& (y != 3 && y != 7 && y != 11 && y != 15 && y != 19 && y != 23 && y != 27)
									&& (x != 3 && x != 7 && x != 11 && x != 15 && x != 19 && x != 23 && x != 27))
									|| ((x == (z - 1)) && (w == (z - 2)))) {
								cargaDeBarcoPosibilidad++;
							}
						} else if (y == (z - 1)) {
							if ((w == (z - 3)
									&& (x != 0 && x != 4 && x != 8 && x != 12 && x != 16 && x != 20 && x != 24)
									&& (y != 0 && y != 4 && y != 8 && y != 12 && y != 16 && y != 20 && y != 24))
									|| ((x == (z + 1)) && (w == (z + 2)))) {
								cargaDeBarcoPosibilidad++;
							}
						} else if (y == (z - 4)) {
							if ((w == (z - 12)) || ((x == (z + 4)) && (w == (z + 8)))) {
								cargaDeBarcoPosibilidad++;
							}

						} else if (y == (z + 4)) {
							if ((w == (z + 12)) || ((x == (z - 4)) && (w == (z - 8)))) {
								cargaDeBarcoPosibilidad++;
							}

						}
					}
					/*
					 * if((posiciones[i][f].getValorInicial()==w)&&(posiciones[i][f].getValorInicial
					 * ()==(z+12)||posiciones[i][f].getValorInicial()==(z-12)||posiciones[i][f].
					 * getValorInicial()==(z+3)||posiciones[i][f].getValorInicial()==(z-3))) {
					 * cargaDeBarcoPosibilidad++; }
					 */
				}

			}
		}
		if (cargaDeBarcoPosibilidad == 4) {
			barcoCargado = true;
			for (int i = 0; i < posiciones.length; i++) {
				for (int f = 0; f < posiciones[i].length; f++) {
					if ((posiciones[i][f].getValorInicial() == z) || (posiciones[i][f].getValorInicial() == y)
							|| (posiciones[i][f].getValorInicial() == x) || (posiciones[i][f].getValorInicial() == w)) {
						posicionesBarco4[i][f] = posiciones[i][f];
						posiciones[i][f].setNombrePosicion("O");
					}

				}
			}
		}
		return barcoCargado;
	}

	public Posiciones[][] getJuego() {
		return posiciones;
	}

	public boolean barco1Caido() {
		boolean barcoCaido = false;

		if (barco1Cayo == true) {
			return barco1Cayo;
		}
		return barcoCaido;
	}

	public boolean barco2Caido() {
		boolean barcoCaido = false;

		if (barco2Cayo == true) {
			return barco2Cayo;
		}
		return barcoCaido;
	}

	public boolean barco3Caido() {
		boolean barcoCaido = false;

		if (barco3Cayo == true) {
			return barco3Cayo;
		}
		return barcoCaido;
	}

	public boolean ganarJuego() {
		boolean ganaste = false;

		if (barco1Cayo == true && barco2Cayo == true && barco3Cayo == true) {
			ganaste = true;
		}
		return ganaste;
	}

	public boolean atacarBarco(int z) {
		boolean ataco = false;

		for (int i = 0; i < posiciones.length; i++) {
			for (int f = 0; f < posiciones[i].length; f++) {
				if ((posiciones[i][f].getValorInicial() == z) && (posiciones[i][f].getNombrePosicion().equals("O"))) {
					if (posiciones[i][f] == posicionesBarco2[i][f]) {
						contadorBarco1++;
						posiciones[i][f].setValorInicial(100);
						posicionesBarco2[i][f] = posiciones[i][f];

						if (contadorBarco1 == 2) {
							barco1Cayo = true;
						}
					}

					if (posiciones[i][f] == posicionesBarco3[i][f]) {
						contador1++;
						posiciones[i][f].setValorInicial(100);
						posicionesBarco3[i][f] = posiciones[i][f];
						if (contador1 == 3) {
							barco2Cayo = true;
						}
					}
					if (posiciones[i][f] == posicionesBarco4[i][f]) {
						contador2++;
						posiciones[i][f].setValorInicial(100);
						posicionesBarco4[i][f] = posiciones[i][f];
						if (contador2 == 4) {
							barco3Cayo = true;
						}
					}

					ataco = true;

				}
			}
		}
		return ataco;
	}

	public boolean ataqueErrado(int y) {
		boolean erroAtaque = false;
		for (int i = 0; i < posiciones.length; i++) {
			for (int f = 0; f < posiciones[i].length; f++) {
				if ((posiciones[i][f].getValorInicial() == y) && (posiciones[i][f].getNombrePosicion().equals("X"))) {
					if (posiciones[i][f].getValorInicial() == 99) {
						erroAtaque = false;
					} else {
						posiciones[i][f].setValorInicial(99);
						erroAtaque = true;
					}
				}
			}
		}
		return erroAtaque;
	}

	public boolean cargarPosiciones(Posiciones posicionInicial, int j, int k) {
		boolean seCargo = false;
		if ((k >= 0 && k <= 3) && j >= 0 && j <= 6) {
			switch (j) {
			case 0:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}

			case 1:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}
			case 2:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}
			case 3:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}
			case 4:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}
			case 5:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}
			case 6:
				if (k == 0) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 1) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 2) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;

					break;
				} else if (k == 3) {
					posiciones[j][k] = posicionInicial;
					posiciones[j][k].setValorInicial(contador);
					contador++;
					break;
				}
			}
		}
		seCargo = true;

		return seCargo;
	}

	public String toString() {
		boolean primeraX = false;
		for (int i = 0; i < posiciones.length; i++) {
			for (int f = 0; f < posiciones[i].length; f++) {
				if ((posiciones[i][f].getValorInicial() != 100) && (posiciones[i][f].getValorInicial() != 99) && (i == 0
						&& f == 0 )&& primeraX == false) {
					juego = posiciones[0][0].getValorInicial() + "\t";
					primeraX = true;
					f++;
				}
				if ((posiciones[i][f].getValorInicial() != 100) && (posiciones[i][f].getValorInicial() != 99)
						&& ((i == 0 && f == 3) || (i == 1 && f == 3) || (i == 2 && f == 3) || (i == 3 && f == 3)
								|| (i == 4 && f == 3) || (i == 5 && f == 3) || (i == 6 && f == 3))) {
					juego += posiciones[i][f].getValorInicial() + "\t" + "\n";
				} else {
					if ((posiciones[i][f].getValorInicial() != 100) && (posiciones[i][f].getValorInicial() != 99)
							&& primeraX == true) {
						juego += posiciones[i][f].getValorInicial() + "\t";
					}

				}
				if ((posiciones[i][f].getValorInicial() == 100) && (posiciones[i][f].getValorInicial() != 99)
						&& ((i == 0 && f == 3) || (i == 1 && f == 3) || (i == 2 && f == 3) || (i == 3 && f == 3)
								|| (i == 4 && f == 3) || (i == 5 && f == 3) || (i == 6 && f == 3))) {
					juego += posiciones[i][f].getNombrePosicion() + "\t" + "\n";
				} else if ((posiciones[i][f].getValorInicial() == 100) && (posiciones[i][f].getValorInicial() != 99)
						&& (f != 3)&& primeraX==true) {
					juego += posiciones[i][f].getNombrePosicion() + "\t";
					
				}
				if ((posiciones[i][f].getValorInicial() == 100) && (posiciones[i][f].getValorInicial() != 99)
						&& (i == 0 && f == 0)&& primeraX == false) {
					juego = posiciones[i][f].getNombrePosicion() + "\t";
					
					
				}
				else if ((posiciones[i][f].getValorInicial() == 99) && (f != 3)&& primeraX==true) {
					juego += posiciones[i][f].getNombrePosicion() + "\t";
				}
				if ((posiciones[i][f].getValorInicial() != 100) &&(posiciones[i][f].getValorInicial() == 99) && (i == 0 && f == 0)&& primeraX == false) {
					juego = posiciones[i][f].getNombrePosicion() + "\t";
					
				}
				if (((posiciones[i][f].getValorInicial() == 99 )&& (posiciones[i][f].getValorInicial() != 100))
						&& ((i == 0 && f == 3) || (i == 1 && f == 3) || (i == 2 && f == 3) || (i == 3 && f == 3)
								|| (i == 4 && f == 3) || (i == 5 && f == 3) || (i == 6 && f == 3))) {
					juego += posiciones[i][f].getNombrePosicion() + "\t" + "\n";
				} 
					primeraX = true;
				
			}
		}
		return juego;
	}

	public String getNombrePosicion() {
	
		return null;
	}

}
