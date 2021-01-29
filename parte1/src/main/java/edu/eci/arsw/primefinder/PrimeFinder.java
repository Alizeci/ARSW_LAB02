package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Angélica Alfaro & Laura Izquierdo
 */
public class PrimeFinder{
	private int inicioNumero;
	private int finNumero;
	ArrayList<PrimeFinderThread> hilos= new ArrayList<PrimeFinderThread>(); 
	private static int nHilos = 3;
	private static int maximo = 30000000;
	
	/**
	* Encuentra los números primos desde 0 hasta 30.000.000, utilizando 3 threads
	*/
	public void calculatePrimes () {
		long startTime= System.currentTimeMillis();
		for (int i = 0; i < nHilos; i++) {
			inicioNumero = maximo / nHilos * i;
			if (i == nHilos - 1 ) {
				finNumero = maximo;
			}else {
				finNumero = (maximo / nHilos * (i + 1)) - 1;
			}
			PrimeFinderThread pft=new PrimeFinderThread(inicioNumero, finNumero);
			pft.start();
			hilos.add(pft);
		}
		
		while (true) {
			if (System.currentTimeMillis() - startTime >= 5000) {
				for (PrimeFinderThread hilo : hilos){
					hilo.setEnPausa(true);
				}
				break;
			}
		}
		
		System.out.println("Presione Enter para continuar... ");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		for (PrimeFinderThread hilo : hilos){
			hilo.restart();
		}
		
	}
}