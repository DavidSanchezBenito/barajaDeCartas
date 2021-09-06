//este metodo esta fuera del resto por realmente no pertenece a la clase, es una accion


	public class Metodos {

	    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
	    	//este metodo, creo que no repite numeros, pero no se como lo almacena
	        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
	        return num;
	    }
}

