package classes;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public String sacar(double valor) {
		if(valor <= this.saldo) {
			this.saldo -= valor;
			return "Saque efetuado com sucesso.";
		}
		return "Saldo insuficiente.";
	}

	@Override
	public String depositar(double valor) {
		saldo += valor;
		return "Depósito efetuado com sucesso.";
	}

	@Override
	public String transferir(double valor, IConta contaDestino) {
		if (this.sacar(valor).equals("Saldo insuficiente.")) {
			return "Saldo insuficiente. Impossível efetuar a transferência.";
		}
		contaDestino.depositar(valor);
		return "Transferência efetuada com sucesso.";
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
}
