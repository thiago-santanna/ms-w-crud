package com.workerms.crud.data.vo;

import java.io.Serializable;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.workerms.crud.entity.Produto;

@JsonPropertyOrder({ "id", "nome", "preco", "estoque" })
public class ProdutoVo extends RepresentationModel<ProdutoVo> implements Serializable {
	private static final long serialVersionUID = 2838721650144416390L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("estoque")
	private Integer estoque;

	@JsonProperty("preco")
	private Double preco;

	public static ProdutoVo fromProduto(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVo.class);
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProdutoVo() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoVo(Long id, String nome, Integer estoque, Double preco) {
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ProdutoVo [id=" + id + ", nome=" + nome + ", estoque=" + estoque + ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVo other = (ProdutoVo) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
