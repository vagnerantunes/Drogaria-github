package dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import domain.Categoria;
import domain.Produto;

@TestMethodOrder(OrderAnnotation.class)
public class ProdutoDAOTest {
	private static CategoriaDAO CategoriaDAO;
	private static Logger logger;
	private static ProdutoDAO produtoDAO;

	@BeforeAll
	public static void iniciar() {
		logger = Logger.getLogger(ProdutoDAOTest.class.getName());
		CategoriaDAO = new CategoriaDAO();
		produtoDAO = new ProdutoDAO();
	}

	@Test
	@Order(1)
	public void inserir() {
		Categoria categoria = CategoriaDAO.buscarPorCodigo(2);

		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setDataDeValidade(LocalDate.of(2022, 4, 15));
		produto.setNome("Sucrilhos");
		produto.setPreco(BigDecimal.valueOf(10.50));
		produto.setQuantidade(13);

		produtoDAO.inserir(produto);
		logger.info("Produto inserido com sucesso: " + produto);
	}

	@Test
	@Order(2)
	public void buscarPorCodigo() {
		Produto produto = produtoDAO.buscarPorCodigo(1);

		logger.info("Categoria encontrada: " + produto);
	}
	
	@Test
	@Order(3)
	public void buscarTudo() {
		List<Produto> produtos = produtoDAO.buscarTudo();
		
		/*
		logger.info("Listagem dos produtos");
		for (Produto produto : produtos) {
			logger.info(produto.toString());
			//agora usamos o logger
			//System.out.println(categoria);
		}
		*/
		
		logger.info("Listagem de produtos 2"); 
		produtos.forEach((produto) -> {
			logger.info(produto.toString());
		});
							
	}

}
