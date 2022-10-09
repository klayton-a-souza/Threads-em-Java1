package br.com.alura.banheiro;

public class Principal {
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro),"Samir");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro),"Nemesis");
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro),"Limpeza");
		limpeza.setDaemon(true);
		
		
		convidado1.start();
		convidado2.start();
		limpeza.start();
		
	}

}
