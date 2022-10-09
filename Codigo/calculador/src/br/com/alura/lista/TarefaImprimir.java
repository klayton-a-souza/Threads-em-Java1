package br.com.alura.lista;

public class TarefaImprimir implements Runnable {

	private Lista lista;

	public TarefaImprimir(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		synchronized (lista) {
			if (!lista.estaCheia()) {
				try {
					System.out.println("Esperando...");
					lista.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int x = 0; x < lista.tamanho(); x++) {
				System.out.println(x + " - " + lista.pegaElemento(x));
			}
		}

	}

}
