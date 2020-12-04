package ar.edu.unlam.pb1.JuegosJava;

import java.util.Scanner;

public class PruebaBatallaNaval {

	static int turno;
	static Jugador jugador1;
	static Jugador jugador2;
	static BatallaNaval juego;
	static BatallaNaval juego1;
	static int pasos = 0;
	static boolean jugador1Gano = false;
	static boolean jugador2Gano = false;

	public static void main(String[] args) {
		int valorTurno = 0;
		String nombre = "";
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el nombre del jugador 1: ");
		nombre = teclado.next();
		jugador1 = new Jugador(nombre);
		System.out.println("Ingrese el nombre del jugador 2: ");
		nombre = teclado.next();
		jugador2 = new Jugador(nombre);
		juego = new BatallaNaval();
		juego1 = new BatallaNaval();
		turno = 0;
		if (turno == 0) {
			cargarPosiciones(juego);
			System.out.println(juego.toString());
			while (pasos < 2) {
				cargarBarco(juego, valorTurno);
			}
			valorTurno++;
			turno++;
			pasos = 0;
		}

		if (turno == 1) {
			cargarPosiciones(juego1);
			System.out.println(juego1.toString());
			while (pasos < 2) {
				cargarBarco(juego1, valorTurno);
			}
			turno = 0;
			pasos = 0;
		}

		while ((jugador1Gano == false) && (jugador2Gano == false)) {
			if ((turno == 0) && (jugador2Gano == false) && (jugador1Gano == false)) {

				System.out.println("Turno de: " + jugador1.getNombre());
				System.out.println("Tablero de " + jugador2.getNombre() + "\n" + juego1.toString() + "\n");
				atacarBarco(juego1);
				System.out.println("Tablero de " + jugador2.getNombre() + "\n" + juego1.toString() + "\n");
				// System.out.println("Tablero de
				// "+jugador2.getNombre()+"\n"+juego1.toString()+"\n");
				if (juego1.barco1Caido()) {
					System.out.println(jugador1.getNombre() + " 　has tirado el barco 1 de dos posiciones　" + "\n");
				}
				if (juego1.barco2Caido()) {
					System.out.println(jugador1.getNombre() + " 　has tirado el barco 2 de tres posiciones!!" + "\n");
				}
				if (juego1.barco3Caido()) {
					System.out.println(jugador1.getNombre() + " 　has tirado el barco 3 de cuatro posiciones!!" + "\n");
				}

			}
			if ((turno == 1) && (jugador1Gano == false) && (jugador2Gano == false)) {
				System.out.println("Turno de: " + jugador2.getNombre());
				System.out.println("Tablero de " + jugador1.getNombre() + "\n" + juego.toString() + "\n");
				atacarBarco(juego);
				System.out.println("Tablero de " + jugador1.getNombre() + "\n" + juego.toString() + "\n");
				if (juego.barco1Caido()) {
					System.out.println(jugador2.getNombre() + " 　has tirado el barco 1 de dos posiciones!!" + "\n");
				}
				if (juego.barco2Caido()) {
					System.out.println(jugador2.getNombre() + " 　has tirado el barco 2 de tres posiciones!!" + "\n");
				}
				if (juego.barco3Caido()) {
					System.out.println(jugador2.getNombre() + " 　has tirado el barco 3 de cuatro posiciones!!" + "\n");
				}

			}
		}
		if (jugador1Gano == true) {
			System.out.println(jugador1.getNombre() + " felicitaciones has ganado y el rival es un perdedor");
		}
		if (jugador2Gano == true) {
			System.out.println(jugador2.getNombre() + " felicitaciones has ganado y el rival es un perdedor");
		}
	}

	static private void cargarPosiciones(BatallaNaval posiciones) {
		for (int i = 0; i < 7; i++) {
			for (int k = 0; k < 4; k++) {

				Posiciones posicionInicial;
				posicionInicial = new Posiciones("X", 1);

				if (posiciones.cargarPosiciones(posicionInicial, i, k)) {

					System.out.println("Se cargo con exito");
				} else {
					System.out.println("No se pudo");
				}
			}
		}

	}

	static private void cargarBarco(BatallaNaval posiciones, int valorTurno) {
		int numero = 0, numero1 = 0, numero2 = 0, numero3 = 0;
		int numeroAnterior0 = 0, numeroAnterior1 = 0, numeroAnterior2 = 0, numeroAnterior3 = 0, numeroAnterior4 = 0;
		Scanner teclado = new Scanner(System.in);
		if (pasos == 0) {
			if (valorTurno == 0) {
				System.out.println(jugador1.getNombre()
						+ ": Ingrese donde ubicar su barco de 2 posiciones (puede elegir de la posicion 0 a la 27)");
			} else {
				System.out.println(jugador2.getNombre()
						+ ": Ingrese donde ubicar su barco de 2 posiciones (puede elegir de la posicion 0 a la 27)");
			}

			System.out.println("NO OLVIDES ACOMODAR LOS BARCOS EN FORMA RECTA");
			System.out.println("Ingrese primera posicion: ");
			numero = teclado.nextInt();
			System.out.println("Ingrese la segunda posicion: ");
			numero1 = teclado.nextInt();
			if (posiciones.cargarBarco(numero, numero1)) {
				numeroAnterior0 = numero;
				numeroAnterior1 = numero1;
				System.out.println("Barco 1 Ingresado");
				pasos++;
			} else {
				System.out.println("No se pudo cargar el barco,vuelva a ingresarlo" + "\n");
			}
		}

		if (pasos == 1) {
			while (pasos == 1) {
				if (valorTurno == 0) {
					System.out.println(jugador1.getNombre()
							+ ": Ingrese donde ubicar su barco de 3 posiciones (puede elegir de la posicion 0 a la 27)");
				} else {
					System.out.println(jugador2.getNombre()
							+ ": Ingrese donde ubicar su barco de 3 posiciones (puede elegir de la posicion 0 a la 27)");
				}
				System.out.println("NO OLVIDES ACOMODAR LOS BARCOS EN FORMA RECTA");
				System.out.println("Ingrese primera posicion: ");
				numero = teclado.nextInt();
				System.out.println("Ingrese la segunda posicion: ");
				numero1 = teclado.nextInt();
				System.out.println("Ingrese la tercera posicion: ");
				numero2 = teclado.nextInt();

				if ((numero != numeroAnterior0 && numero != numeroAnterior1)
						&& (numero1 != numeroAnterior0 && numero1 != numeroAnterior1)
						&& (numero2 != numeroAnterior0 && numero2 != numeroAnterior1)) {
					if (posiciones.cargarBarco(numero, numero1, numero2)) {
						System.out.println("Barco 2 Ingresado");
						numeroAnterior2 = numero;
						numeroAnterior3 = numero1;
						numeroAnterior4 = numero2;
						pasos++;
					} else {
						System.out.println("No se pudo cargar el barco,vuelva a ingresarlo" + "\n");
					}
				} else {
					System.out.println(
							"Vuelva a ingresar el barco, acuerdese que no puede utilizar posiciones ocupadas!!!\n");
				}
			}
		}

		if (pasos == 2) {
			while (pasos == 2) {
				if (valorTurno == 0) {
					System.out.println(jugador1.getNombre()
							+ ": Ingrese donde ubicar su barco de 4 posiciones (puede elegir de la posicion 0 a la 27)");
				} else {
					System.out.println(jugador2.getNombre()
							+ ": Ingrese donde ubicar su barco de 4 posiciones (puede elegir de la posicion 0 a la 27)");
				}
				System.out.println("NO OLVIDES ACOMODAR LOS BARCOS EN FORMA RECTA");
				System.out.println("Ingrese primera posicion: ");
				numero = teclado.nextInt();
				System.out.println("Ingrese la segunda posicion: ");
				numero1 = teclado.nextInt();
				System.out.println("Ingrese la tercera posicion: ");
				numero2 = teclado.nextInt();
				System.out.println("Ingrese la cuarta posicion: ");
				numero3 = teclado.nextInt();
				if ((numero != numeroAnterior0 && numero != numeroAnterior1 && numero != numeroAnterior2
						&& numero != numeroAnterior3 && numero != numeroAnterior4)
						&& (numero1 != numeroAnterior0 && numero1 != numeroAnterior1 && numero1 != numeroAnterior2
								&& numero1 != numeroAnterior3 && numero1 != numeroAnterior4)
						&& (numero2 != numeroAnterior0 && numero2 != numeroAnterior1 && numero2 != numeroAnterior2
								&& numero2 != numeroAnterior3 && numero2 != numeroAnterior4)
						&& (numero3 != numeroAnterior0 && numero3 != numeroAnterior1 && numero3 != numeroAnterior2
								&& numero3 != numeroAnterior3 && numero3 != numeroAnterior4)) {
					if (posiciones.cargarBarco(numero, numero1, numero2, numero3)) {
						System.out.println("Barco 3 Ingresado");
						pasos++;
					} else {
						System.out.println("No se pudo cargar el barco,vuelva a ingresarlo" + "\n");
					}

				} else {
					System.out.println(
							"Vuelva a ingresar el barco, acuerdese que no puede utilizar posiciones ocupadas!!!\n");
				}
			}
		}
		if (pasos == 3) {

			for (int i = 0; i < 40; i++) {
				System.out.println();
			}
		}
	}

	static private void atacarBarco(BatallaNaval atacar) {
		int posicion_a_Atacar = 0;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
		posicion_a_Atacar = teclado.nextInt();
		if (atacar.atacarBarco(posicion_a_Atacar)) {
			if ((juego1.barco1Caido() == true) && (juego1.barco2Caido() == true) && (juego1.barco3Caido() == true)) {
				System.out.println(jugador1.getNombre() + "	ganaste el juego!!");
				jugador1Gano = true;
				turno = 2;
			}
			if ((juego.barco1Caido() == true) && (juego.barco2Caido() == true) && (juego.barco3Caido() == true)) {
				System.out.println(jugador2.getNombre() + "	ganaste el juego!!");
				jugador2Gano = true;
				turno = 2;
			}

		} else {
			if (atacar.ataqueErrado(posicion_a_Atacar)) {
				if (turno == 0) {
					turno = 1;
				} else if (turno == 1) {
					turno = 0;
				}
			}
		}

	}

}
		
		
		
		
		
		/*BatallaNaval juego[][];
	Posiciones juegoMuestra;
	juego = new BatallaNaval[7][4];
	juegoMuestra =new  Posiciones ();
	for (int j =0;j<juego.length;j++) {
		for(int k=0;k<juego[j].length;k++ ) {
			
			}
		}
	
	for (int z =0;z<juego.length;z++) {
		
	for(int h=0;h<juego[z].length;h++ ) {
	
	 	
	
		if((z == 0 && h == 3)||( z == 1 && h == 3 )||( z == 2 && h == 3 )||( z == 3 && h == 3 )||( z == 4 && h == 3 )||( z == 5 && h == 3 )||( z == 6 && h == 3 )) {
			System.out.println(juego[z][h].toString() + "\t");
			
						
			}else {
			System.out.print(juego[z][h].toString() + "\t");
				}						
			}				
		}		
	}
  }*/
	/*
	 
	  	if(atacar.atacarBarco(posicion_a_Atacar)) {
				System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
				posicion_a_Atacar = teclado.nextInt();
				if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
					System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
					jugador1Gano= true;
					turno =2;
						}
				if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
					System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
					jugador2Gano = true;
					turno =2;
							}	
				if(atacar.atacarBarco(posicion_a_Atacar)) {
					System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
					posicion_a_Atacar = teclado.nextInt();
					if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
						System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
						jugador1Gano= true;
						turno =2;
							}
					if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
						System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
						jugador2Gano = true;
						turno =2;
								}	
					if(atacar.atacarBarco(posicion_a_Atacar)) {
						System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
						posicion_a_Atacar = teclado.nextInt();
						if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
							System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
							jugador1Gano= true;
							turno =2;
								}
						if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
							System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
							jugador2Gano = true;
							turno =2;
									}	
						if(atacar.atacarBarco(posicion_a_Atacar)) {
							System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
							posicion_a_Atacar = teclado.nextInt();
							if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
								System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
								jugador1Gano= true;
								turno =2;
									}
							if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
								System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
								jugador2Gano = true;
								turno =2;
										}	
							if(atacar.atacarBarco(posicion_a_Atacar)) {
								System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
								posicion_a_Atacar = teclado.nextInt();
								if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
									System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
									jugador1Gano= true;
									turno =2;
										}
								if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
									System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
									jugador2Gano = true;
									turno =2;
											}	
								if(atacar.atacarBarco(posicion_a_Atacar)) {
									System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
									posicion_a_Atacar = teclado.nextInt();
									if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
										System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
										jugador1Gano= true;
										turno =2;
											}
									if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
										System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
										jugador2Gano = true;
										turno =2;
												}	
									if(atacar.atacarBarco(posicion_a_Atacar)) {
										System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
										posicion_a_Atacar = teclado.nextInt();
										if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
											System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
											jugador1Gano= true;
											turno =2;
												}
										if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
											System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
											jugador2Gano = true;
											turno =2;
													}	
										if(atacar.atacarBarco(posicion_a_Atacar)) {
											System.out.println("Elegi la posicion a la que queres dirigir tu ataque: ");
											posicion_a_Atacar = teclado.nextInt();
											if((juego1.barco1Caido()== true )&&(juego1.barco2Caido()==true)&&(juego1.barco3Caido()== true)) {
												System.out.println(jugador1.getNombre()+"	ganaste el juego!!");
												jugador1Gano= true;
												turno =2;
													}
											if((juego.barco1Caido()== true )&&(juego.barco2Caido()==true)&&(juego.barco3Caido()== true)) {
												System.out.println(jugador2.getNombre()+"	ganaste el juego!!");
												jugador2Gano = true;
												turno =2;
														}	
										}else {
											atacar.ataqueErrado(posicion_a_Atacar);
											if(turno==0) {
												turno =1;
											}else if(turno==1) {
												turno = 0;
											}
										}
									}else {
										atacar.ataqueErrado(posicion_a_Atacar);
										if(turno==0) {
											turno =1;
										}else if(turno==1) {
											turno = 0;
										}
									}
								}else {
									atacar.ataqueErrado(posicion_a_Atacar);
									if(turno==0) {
										turno =1;
									}else if(turno==1) {
										turno = 0;
									}
								}
							}else {
								atacar.ataqueErrado(posicion_a_Atacar);
								if(turno==0) {
									turno =1;
								}else if(turno==1) {
									turno = 0;
								}
							}
						}else {
							atacar.ataqueErrado(posicion_a_Atacar);
							if(turno==0) {
								turno =1;
							}else if(turno==1) {
								turno = 0;
							}
						}
					}else {
						atacar.ataqueErrado(posicion_a_Atacar);
						if(turno==0) {
							turno =1;
						}else if(turno==1) {
							turno = 0;
						}
					}
				}else {
					atacar.ataqueErrado(posicion_a_Atacar);
					if(turno==0) {
						turno =1;
					}else if(turno==1) {
						turno = 0;
					}
				}
			}else {
				atacar.ataqueErrado(posicion_a_Atacar);
				if(turno==0) {
					turno =1;
				}else if(turno==1) {
					turno = 0;
				}
			}
	  
	  
	 */

