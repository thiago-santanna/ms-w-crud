package com.workerms.crud.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.workerms.crud.data.vo.ProdutoVo;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 8609308303367125127L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(length = 10, nullable = false)
	private Integer estoque;

	@Column(length = 10, nullable = false)
	private Double preco;

	public static Produto fromProdutoVo(ProdutoVo produtoVo) {
		return new ModelMapper().map(produtoVo, Produto.class);
	}

	public Produto(Long id, String nome, Integer estoque, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
	}

	public Produto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", estoque=" + estoque + ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(preco, other.preco);
	}

}
