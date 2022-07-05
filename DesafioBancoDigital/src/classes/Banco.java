package classes;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	
	private List<Conta> contas;
	
	public Banco() {
		contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public void imprimirContas() {
		System.out.println("");
		System.out.println("=== " + this.nome + " ===");
		System.out.println("");
		for (Conta conta : contas) {
			System.out.println("Cliente: " + conta.getCliente().getNome());
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Conta: " + conta.getNumero());
			System.out.println(String.format("Saldo R$ %.2f", conta.getSaldo()));
			System.out.println("------------------------------");
			
		}
	}

}
