
public class Practica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filtroFicheros = "*Pentatonix*.mp4";
		filtroFicheros = filtroFicheros.replaceAll( "\\.", "\\\\." );  // Pone el s�mbolo de la expresi�n regular \. donde figure un .
		filtroFicheros = filtroFicheros.replaceAll("\\*", "\\.*");
		System.out.println(filtroFicheros);

	}

}
