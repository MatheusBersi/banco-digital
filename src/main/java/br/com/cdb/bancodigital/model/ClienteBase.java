package br.com.cdb.bancodigital.model;

import java.time.LocalDate;
import java.util.Random;

public abstract class ClienteBase{
	
	private String nome;
	private String cpf;
	private String endRua;
	private int endNum;
	private String endComple;
	private String cidade;
	private String estado;
	private long cep;
	private LocalDate dataNascimento;
	private String tipoCliente;
	private String senha;
	private int id;
	private ContaCorrente contaCorrente;
	private ContaPoupanca contaPoupanca;

	
	
	public ClienteBase(String nome, String cpf, String endRua, LocalDate dataNascimento, String tipoCliente, 
			String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.endRua = endRua;
		this.dataNascimento = dataNascimento;
		this.tipoCliente = tipoCliente;
		this.senha = senha;
	}
	
	public int init() {
		Random random = new Random();
		this.id = random.nextInt(100);
		return id;
	}
	
	public void exibirDados() {
		toString();
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


//	public String getEndereco() {
//		return endereco;
//	}


//	public void setEndereco(String endereco) {
//		this.endereco = endereco;
//	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getTipoConta() {
		return tipoCliente;
	}


	public void setTipoConta(String tipoCliente) {
		this.tipoCliente = tipoCliente;
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

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("+----------------------------------------+\n");
	    sb.append(String.format("| Cliente ID: %-27d |\n", id));
	    sb.append(String.format("| Tipo: %-32s |\n", tipoCliente));
	    sb.append(String.format("| Nome: %-31s |\n", nome));
	    sb.append(String.format("| CPF: %-32s |\n", cpf));
//	    sb.append(String.format("| Endereço: %-27s |\n", endereco));
	    sb.append(String.format("| Data de Nascimento: %-18s |\n", dataNascimento));
	    sb.append(contaCorrente.toString()); 
	    sb.append(contaPoupanca.toString()); 
	    sb.append("+----------------------------------------+\n");

	    return sb.toString();
	}


	
	
	

}
