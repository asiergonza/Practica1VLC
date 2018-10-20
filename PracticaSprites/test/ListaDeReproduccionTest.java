import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaDeReproduccionTest {
	
	private ListaDeReproduccion lr1;
    private ListaDeReproduccion lr2;
    private final File FIC_TEST1 = new File( "test/res/No del grupo.mp4" );
    private final File FIC_TEST2 = new File( "test/res/Fichero erroneo Pentatonix.mp4" );
    private final File FIC_TEST3 = new File( "test/res/[Official Video] Daft Punk - Pentatonix.mp4" );
	

    @Before
    public void setUp() throws Exception {
          lr1 = new ListaDeReproduccion();
          lr2 = new ListaDeReproduccion();
          lr2.add( FIC_TEST1 );
          lr2.add(FIC_TEST2);
          //lr2.add(FIC_TEST3);
}

    @After
    public void tearDown() {
          lr2.clear();
    }

    // Chequeo de error por getFic(índice) por encima de final
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_Exc1() {
    	lr1.getFic(0); 
    }// Debe dar error porque aún no existe la posición 0 }
    // Chequeo de error por get(índice) por debajo de 0
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_Exc2() {
    	lr2.getFic(-1);
    }// Debe dar error porque aún no existe la posición -1 }
    // Chequeo de funcionamiento correcto de get(índice)
    @Test public void testGet() {
    	assertEquals( FIC_TEST1, lr2.getFic(0) ); 
    }// El único dato es el fic-test1 }
    
    //utilizamos para ver el intercambio de ficherps. 
    @Test public void testIntercambio() {
   /* 	File f = lr2.getFic(2);
    	int size2 = lr2.size();        practicando el JUnit con otras cosas
    	lr2.removeFich(2);
    	lr1.add(f);
    	assertEquals( lr2.size(),size2 -1 );
    	assertEquals( f, lr1.getFic(0)); */
    	File f = lr2.getFic(0);
    	File f2 = lr2.getFic(1);
    	lr2.intercambia(0, 1);
    	assertEquals( f, lr2.getFic(1));
    	assertEquals( f2, lr2.getFic(0));
    	
    }
    @Test public void testAnyado() {
    	int size1 = lr2.size();
    	lr2.add(FIC_TEST3);
    	assertEquals(lr2.size(), size1 + 1);
    	assertEquals(FIC_TEST3, lr2.getFic(2)); //comprobamos que esta en la pos 2. 
    	lr2.removeFich(2);
    	assertEquals(lr2.size(), size1);
    //	FIC_TEST1.get
    	}
    @Test public void testTamanyo() {
    	
    	assertEquals(lr2.size(), 2); //comprobamos unica y exclusivamente el tamaño de nuestra lista de rep. 
    	//tenemos que saber que no cuenta el añadido en el metodo anterior. 
    }
    

}
