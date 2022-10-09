package br.com.alura.exercicio;

public class ImprimeNumeros implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Thread threadAtual = Thread.currentThread();
			System.out.println("Id : " + threadAtual.getId() + " ,Numero: " + i);
		}
	}
}
