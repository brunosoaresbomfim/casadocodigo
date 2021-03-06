package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.Product;

@Controller
@Transactional
public class ProductsControllers {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/produtos")
	public String save(Product product) {
		System.out.println("Cadastrando o produto !!! " + product);
		productDAO.save(product);
		return "products/ok";
	}
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "products/form";
	}
}
