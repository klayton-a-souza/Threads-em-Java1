package br.com.alura.exercicio;

public class OrdemDeExecucao {

	   public static void main(String[] args) {
		   
		   Thread primeiraThread = new Thread(new ImprimeNumeros());
		   Thread segundaThread = new Thread(new ImprimeNumeros());
		   
		   primeiraThread.start();
		   segundaThread.start();
	        
	    }
	}