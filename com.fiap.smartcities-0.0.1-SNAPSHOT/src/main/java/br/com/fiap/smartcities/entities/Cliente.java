package br.com.fiap.smartcities.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_smc_cliente")
public class Cliente {

	@Id
	@SequenceGenerator(name="cliente", sequenceName="sq_t_smc_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name="cd_cliente")
	private int id;
	
	@Column(name="nm_cliente")
	private String nome;
	
	// Relacionamento 1 pra 1 (1:1)
	@OneToOne
	// Para alterar no banco com o mesmo nome que está na entidade 
	// dominante como chave primária
	@JoinColumn(name="id_produto")
	private Produto produto;

	public Cliente() {
		super();
	}
	
	
	public Cliente(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}