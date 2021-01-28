package edu.eci.arsw.primefinder;

public class Main {
	private static int inicioNumero;
	private static int finNumero;
	private static int nHilos = 3;
	private static int maximo = 30000000;
	
	public static void main(String[] args) {

		
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