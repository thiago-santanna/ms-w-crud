package com.workerms.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.workerms.crud.data.vo.ProdutoVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
}
