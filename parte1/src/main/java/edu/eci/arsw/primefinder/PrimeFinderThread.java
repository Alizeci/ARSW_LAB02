package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{
	int a,b;
	boolean enPausa;
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public void run(){
		for (int i=a;i<=b;i++){	
			synchronized(this){
				while (isEnPausa()){
					try {
						wait();                                
					} catch (InterruptedException ex) {
						ex.printStackTrace();
                    }
                }
           }					
			if (isPrime(i)){
				primes.add(i);
				System.out.println(i);
			}
		}
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public synchronized void restart() {
		this.setEnPausa(false);
		notify();
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
	public boolean isEnPausa() {
		return enPausa;
	}

	public void setEnPausa(boolean enPausa) {
		this.enPausa = enPausa;
	}
}
