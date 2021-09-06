import java.util.Scanner;

public class Baraja {

	private Carta[] cartas;
	private int posSiguienteCarta; // no vamos a eliminar cartas sino q el puntero dice donde estamos
	// será el puntero de donde se encuentra la carta superior

	public static final int NUM_CARTAS = 40; // cte

	public Baraja() {

		this.cartas = new Carta[NUM_CARTAS];
		this.posSiguienteCarta = 0; // inicializo el puntero en la posicion 0
		crearBaraja();
		barajar();
		System.out.println("baraja creada");
	}

	private void crearBaraja() {
		String[] palos = Carta.PALOS;

		for (int i = 0; i < palos.length; i++) {
			for (int j = 0; j < Carta.LIMITE_CARTA_PALO; j++) {

				if (!(j == 7 || j == 8)) { // los numeros 7 y 8 no existen en la baraja como tal

					if (j >= 9) {
						// pongo 22 para ocupar las posiciones q estoy restando y q se hagan las 10
						// cartas por palo
						cartas[(i * (Carta.LIMITE_CARTA_PALO - 2) + (j - 2))] = new Carta((j + 1), palos[i]);

					} else {
						cartas[(i * (Carta.LIMITE_CARTA_PALO - 2) + j)] = new Carta((j + 1), palos[i]);
					}
				}

			}
		}

	}

	public void barajar() {

		int posAleatoria = 0;
		Carta c;

		if (posSiguienteCarta == NUM_CARTAS) {
			System.out.println("ya no hay mas cartas, barajea de nuevo");
		} else if (posSiguienteCarta == NUM_CARTAS - 1) {
			System.out.println("solo queda una carta que no se puede barajar");
		} else {
			System.out.println("has vuelto a barajar las cartas");
			for (int i = 0; i < cartas.length; i++) {
				posAleatoria = Metodos.generaNumeroEnteroAleatorio(0, NUM_CARTAS - 1); // es del 0 al 39
				c = cartas[i];
			
			cartas[i] = cartas[posAleatoria];
			
			this.posSiguienteCarta = 0; //si vuelvo a barajar, el puntero vuelve al
			// principio

			}
		}
		// es realmente reiniciar la baraja
		 
	}

	public Carta siguienteCarta() {

		Carta c = null;

		if (posSiguienteCarta == NUM_CARTAS) {
			System.out.println("ya no hay mas cartas, barajea de nuevo");
		} else {
			for (int i = 0; i < 5; i++) {
				System.out.println("");
			}
			System.out.println("la siguiente carta que se va mostrar es:");
			c = cartas[posSiguienteCarta++];

		}
		return c;
	}

	public Carta[] darCartas(int numCartasSolic) {

		Carta c = null;

		// Scanner sc = new Scanner(System.in);

		// int numeroCartasSolicitadas = 0;
		// numeroCartasSolicitadas = sc.nextInt();

		if (numCartasSolic > (NUM_CARTAS)) {
			System.out.println("no puedes pedir mas cartas que el tamaño de la baraja: Has pedido " + numCartasSolic
					+ " pero solo hay: " + cartasDisponibles());

		} else {
			if (numCartasSolic > cartasDisponibles()) {
				System.out.println("no hay suficientes cartas para repartir, has pedido " + numCartasSolic
						+ " pero solo hay: " + cartasDisponibles());

			} else {
				Carta[] cartasDar = new Carta[numCartasSolic]; // creo array donde guardo las cartas a mostrar
				System.out.println("Han salido las siguientes " + numCartasSolic + " cartas:");
				for (int i = 0; i < cartasDar.length; i++) {
					System.out.println("carta que ha salido numero " + (i + 1) + ": " + cartas[i]);
				}
				posSiguienteCarta = posSiguienteCarta + numCartasSolic;
				return cartasDar;
			}

		}
		return null;

	}

	public int cartasDisponibles() {

		// devuelve un numero

		return NUM_CARTAS - posSiguienteCarta;

	}

	public void cartasMonton() {

		if (cartasDisponibles() == NUM_CARTAS) {
			System.out.println("no se ha sacado ninguna carta todavia");
		} else {

			for (int i = 0; i < posSiguienteCarta; i++) {
				System.out.println(cartas[i]);

			}

		}

	}

	public void mostrarBaraja() {

		if (cartasDisponibles() == 0) {
			System.out.println("no hay cartas q mostrar (se han sacado todas ya)");
		} else {
			System.out.println("este es el orden de las cartas barajeadas");
			for (int i = posSiguienteCarta; i < NUM_CARTAS; i++) {

				System.out.println(cartas[i]);

			}

		}
	}

}
