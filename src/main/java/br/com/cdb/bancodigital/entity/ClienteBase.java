package br.com.cdb.bancodigital.entity;
import java.util.Random;

public abstract class ClienteBase{
	Random random = new Random();
	
	protected String nome;
	protected long cpf;
	protected String endereco;
	protected int dataNascimento;
	protected String senha;
	protected int idComum;
	
	public ClienteBase(String nome, long cpf, String endereco, int dataNascimento, String senha, int idComum) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.setSenha(senha);
		this.idComum = random.nextInt(100);
	}
	
	public int idcomum() {
		return idComum;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return null;
	}

	
	

}
