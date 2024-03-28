package br.com.cdb.bancodigital.model;

import java.time.LocalDate;
import java.util.Random;

public abstract class ClienteBase {

	private String nome;
	private String cpf;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private LocalDate dataNascimento;
	private String tipoCliente;
	private String senha;
	private int id;
	private ContaCorrente contaCorrente;
	private ContaPoupanca contaPoupanca;

	public ClienteBase(String nome, String cpf, String logradouro, int numero, String complemento, String bairro,
			String cidade, String estado, String cep, LocalDate dataNascimento, String tipoCliente) {
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.dataNascimento = dataNascimento;
		this.tipoCliente = tipoCliente;
	}

	public int init() {
		Random random = new Random();
		this.id = random.nextInt(100);
		return id;
	}

	public void exibirDados() {
		System.out.println("+--------------------------------------+");
		System.out.printf("|Nome: %-40s |\n", nome);
		System.out.printf("|CPF: %-40s |\n", cpf);
		System.out.printf("|Data de Nascimento: %-40s |\n", dataNascimento);
		System.out.printf("|Endereço: %-40s |\n", logradouro);
		System.out.printf("|Logradouro: %-24s |\n", logradouro);
		System.out.printf("|Número: %-29d |\n", numero);
		System.out.printf("|Complemento: %-21s |\n", complemento);
		System.out.printf("|Bairro: %-27s |\n", bairro);
		System.out.printf("|Cidade: %-27s |\n", cidade);
		System.out.printf("|Estado: %-27s |\n", estado);
		System.out.printf("|CEP: %-31s |\n", cep);
		System.out.println("+--------------------------------------+");
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("+----------------------------------------+\n");
		sb.append(String.format("|Cliente ID: %-27d |\n", id));
		sb.append(String.format("|Tipo: %-32s |\n", tipoCliente));
		sb.append(String.format("|Nome: %-31s |\n", nome));
		sb.append(String.format("|CPF: %-32s |\n", cpf));
		sb.append(String.format("|Endereço: %-27s |\n", logradouro));
		sb.append(String.format("|Bairro: %-27s |\n", bairro));
		sb.append(String.format("|Cidade: %-27s |\n", cidade));
		sb.append(String.format("|Estado: %-27s |\n", estado));
		sb.append(String.format("|Data de Nascimento: %-18s |\n", dataNascimento));

		if (contaCorrente != null) {
			sb.append(contaCorrente.toString());
		}
		if (contaPoupanca != null) {
			sb.append(contaPoupanca.toString());
		}
		sb.append("+----------------------------------------+\n");

		return sb.toString();
	}
}
