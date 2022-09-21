package com.workerms.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.workerms.crud.data.vo.ProdutoVo;
import com.workerms.crud.entity.Produto;
import com.workerms.crud.exception.ResourceNotFoundException;
import com.workerms.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public ProdutoVo create(ProdutoVo produtoVo) {
		ProdutoVo produtoVoSalvo = ProdutoVo.fromProduto(produtoRepository.save(Produto.fromProdutoVo(produtoVo)));
		return produtoVoSalvo;
	}

	public Page<ProdutoVo> findAll(Pageable pageable) {
		var page = produtoRepository.findAll(pageable);
		return page.map(this::convertProdutoToProdutoVo);
	}

	public ProdutoVo findById(Long id) {
		var produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto n'ao encontrado"));
		return ProdutoVo.fromProduto(produto);
	}

	public ProdutoVo update(ProdutoVo produtoVo) {
		var findById = produtoRepository.findById(produtoVo.getId());
		if (!findById.isPresent()) {
			new ResourceNotFoundException("Produto n'ao encontrado");
		}

		return ProdutoVo.fromProduto(produtoRepository.save(Produto.fromProdutoVo(produtoVo)));
	}

	public void delete(Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto n'ao encontrado"));
		produtoRepository.delete(produto);
	}

	private ProdutoVo convertProdutoToProdutoVo(Produto produto) {
		return ProdutoVo.fromProduto(produto);
	}
}
