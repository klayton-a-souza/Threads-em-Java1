package br.com.alura.banheiro;

public class Banheiro {

	private boolean ehSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			while (ehSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo coisa rapida");

			tiraUmCochilo(5000);
			
			this.ehSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mão");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			while(ehSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo coisa demorada");

			tiraUmCochilo(10000);
			
			this.ehSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mão");
			System.out.println(nome + " saindo do banheiro");
		}

	}

	private void tiraUmCochilo(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void limpa() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			if(!ehSujo) {
				System.out.println(nome + ", não esta sujo, vou sair");
				return;
			}
			
			System.out.println(nome + " limpnando banheiro");
			this.ehSujo = false;
			
			try {
				Thread.sleep(13000);
			}catch(InterruptedException e ) {
				e.printStackTrace();
			}
			
			this.notifyAll();
			
			System.out.println(nome + "saindo do banheiro");
		}
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro tá sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
