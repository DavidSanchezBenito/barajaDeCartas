
public class main {
	// https://www.youtube.com/watch?v=p5g2sQOuM_Q&list=PLaxZkGlLWHGXQ9MSswRu4pI3ROgt2qzcX&index=26
	// empezado 2-9-21, cont 3.9.21 y acabado el

	
	public static void main(String[] args) {

		Baraja b = new Baraja();
		
		//b.mostrarBaraja();
		/*
		//System.out.println(b.cartasDisponibles());
		b.siguienteCarta(); //carta segun el orden que saco del mazo
		b.siguienteCarta();
		b.siguienteCarta();
		System.out.println(b.cartasDisponibles());
		b.cartasMonton();  //cartas que he sacado
*/
		//Carta[] c = b.darCartas(50);
		b.cartasDisponibles();
		b.darCartas(35);
		b.darCartas(4);
		System.out.println(b.cartasDisponibles());
		//b.siguienteCarta();
		b.barajar();
		b.mostrarBaraja();
	}

}
