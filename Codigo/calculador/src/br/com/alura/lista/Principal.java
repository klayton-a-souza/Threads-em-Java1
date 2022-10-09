package br.com.alura.lista;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		Lista lista = new Lista();

		for (int i = 0; i < 10; i++) {
			new Thread(new TaredaAdicionarElemento(lista, i)).start();
		}

		Thread.sleep(1000);

		new Thread(new TarefaImprimir(lista)).start();

	}

}
