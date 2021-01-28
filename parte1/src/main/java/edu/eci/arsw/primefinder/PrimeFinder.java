package edu.eci.arsw.primefinder;

/**
 * @author Angélica Alfaro & Laura Izquierdo
 */
public class PrimeFinder{
	private int inicioNumero;
	private int finNumero;
	private static int nHilos = 3;
	private static int maximo = 30000000;
	
	/**
	* Encuentra los números primos desde 0 hasta 30.000.000, utilizando 3 threads
	*/
	public void calculatePrimes () {
		for (int i = 0; i < nHilos; i++) {
			inicioNumero = maximo / nHilos * i;
			if (i == nHilos - 1 ) {
				finNumero = maximo;
			}else {
				finNumero = (maximo / nHilos * (i + 1)) - 1;
			}
			PrimeFinderThread pft=new PrimeFinderThread(inicioNumero, finNumero);
			pft.start();
			}
		}
}