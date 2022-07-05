package classes;

public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		banco.setNome("Banco Teste");
				
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Jhonatan");
		cliente1.setCpf("123.123.123-11");
		cliente1.setEndereco("Rua teste, 123");
		cliente1.setEmail("jhonatandmsouza@gmail.com");
		cliente1.setTelefone("(048)9999-1111");
		
		Conta ccCliente1 = new ContaCorrente(cliente1);
		Conta cpCliente1 = new ContaPoupanca(cliente1);
		
		System.out.println(ccCliente1.depositar(100));
		ccCliente1.imprimirExtrato();
		System.out.println(ccCliente1.transferir(100, cpCliente1));
		cpCliente1.imprimirExtrato();
		System.out.println("-----------------------------");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Pedro");
		cliente2.setCpf("111.222.333-44");
		cliente2.setEndereco("Rua Outro Teste, 999");
		cliente2.setEmail("pedro@pedro.com");
		cliente2.setTelefone("(048)9999-9999");
		
		Conta ccCliente2 = new ContaCorrente(cliente2);
		Conta cpCliente2 = new ContaPoupanca(cliente2);
		
		System.out.println("");
		System.out.println(ccCliente2.depositar(80));
		ccCliente2.imprimirExtrato();
		System.out.println("Efetuando transferência para conta poupança...");
		System.out.println(ccCliente2.transferir(100, cpCliente2));
		cpCliente2.imprimirExtrato();
		System.out.println("Efetuando saque da conta poupança...");
		System.out.println(cpCliente2.sacar(50));
		System.out.println("-----------------------------");
		
		banco.adicionarConta(ccCliente1);
		banco.adicionarConta(cpCliente1);
		banco.adicionarConta(ccCliente2);
		banco.adicionarConta(cpCliente2);
		banco.imprimirContas();
		
	}

}