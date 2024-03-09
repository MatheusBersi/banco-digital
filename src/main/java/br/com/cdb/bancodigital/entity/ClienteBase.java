package br.com.cdb.bancodigital.entity;

import java.time.LocalDate;
import java.util.Random;

import br.com.cdb.bancodigital.conta.ContaCorrente;
import br.com.cdb.bancodigital.conta.ContaPoupanca;

public abstract class ClienteBase{
	
	private String nome;
	private String cpf;
	private String endereco;
	private LocalDate dataNascimento;
	private String tipoConta;
	private String senha;
	private int id;
	private ContaCorrente contaCorrente;
	private ContaPoupanca contaPoupanca;

	
	
	public ClienteBase(String nome, String cpf, String endereco, LocalDate dataNascimento, String tipoConta, 
			String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.tipoConta = tipoConta;
		this.senha = senha;
	}
	
	public int init() {
		Random random = new Random();
		this.id = random.nextInt(100);
		return id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	
	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	public void imprimirInformacoes() {
		System.out.println("+----------------------------------------+");
        System.out.printf("| Cliente ID: %-27d |\n", id);
        System.out.printf("| Tipo: %-32s |\n", tipoConta);
        System.out.printf("| Nome: %-31s |\n", nome);
        System.out.printf("| CPF: %-32s |\n", cpf);
        System.out.printf("| Endereço: %-27s |\n", endereco);
        System.out.printf("| Data de Nascimento: %-18s |\n", dataNascimento);
        contaCorrente.imprimirInformacoes(contaCorrente);
        contaPoupanca.imprimirInformacoes(contaPoupanca);
        System.out.println("+----------------------------------------+");
	}


	
	
	

}
