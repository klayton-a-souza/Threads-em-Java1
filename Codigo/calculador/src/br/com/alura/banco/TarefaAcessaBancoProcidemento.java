package br.com.alura.banco;

public class TarefaAcessaBancoProcidemento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcidemento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (tx) {
			System.out.println("começando o tx");
			tx.begin();
			
			synchronized (pool) {
				System.out.println("peguei a conexão");
				pool.getConnection();
			}
		}
	}
	
//	@Override
//	public void run() {			
//		synchronized (pool) {
//			System.out.println("peguei a conexão");
//			pool.getConnection();
//			
//			synchronized (tx) {
//				System.out.println("começando o tx");
//				tx.begin();
//			}
//		}
//		
//		
//	}

}
