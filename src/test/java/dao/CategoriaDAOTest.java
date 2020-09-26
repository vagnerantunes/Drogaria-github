package dao;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import domain.Categoria;

@TestMethodOrder(OrderAnnotation.class)
public class CategoriaDAOTest {	
	private static CategoriaDAO CategoriaDAO;
	private static Logger logger;

	@BeforeAll
	public static void iniciar() {
		logger = Logger.getLogger(CategoriaDAOTest.class.getName());
		CategoriaDAO = new CategoriaDAO();
	}

	@Test
	@Order(1)
	public void inserir1() {
		Categoria categoria = new Categoria();
		categoria.setNome("Bebidas");

		CategoriaDAO.inserir(categoria);
		//System.out.println("Categoria inserida com sucesso!"); 
		//Obs.: agora vamos passar a usar logger, pois é o ideal... quando usa println, 
		//não é gravado no log texto que vai ser gerado... 
		logger.info("Categoria inserida com sucesso!" + categoria);		
	}

	@Test
	@Order(2)
	public void inserir2() {
		Categoria categoria = new Categoria();
		categoria.setNome("Doces");

		CategoriaDAO.inserir(categoria);
		
		logger.info("Categoria inserida com secesso!" + categoria);
	}

	@Test
	@Order(3)
	public void buscarPorCodigo() {
		Categoria categoria = CategoriaDAO.buscarPorCodigo(1);
		logger.info("Categoria encontrada: " + categoria);
	}

	@Test
	@Order(4)
	public void listar() {
		List<Categoria> categorias = CategoriaDAO.buscarTudo();
		System.out.println("Listagem das categorias");
		logger.info("Listagem das categorias");
		for (Categoria categoria : categorias) {
			logger.info(categoria.toString());
			//agora usamos o logger
			//System.out.println(categoria);
		}
	}

	@Test
	@Order(5)
	public void excluir() {
		int codigo = 1;
		CategoriaDAO.excluir(codigo);
		logger.info("Categoria removida com sucesso:" + codigo);
	}

	@Test
	@Order(6)
	public void editar() {
		int codigo = 2;
		Categoria categoria = new Categoria();
		categoria.setNome("Gibi");

		CategoriaDAO.editar(codigo, categoria);

		logger.info("Categoria editado com sucesso: " + codigo + " - " + categoria);
	}

	@Test
	@Order(7)
	public void inserirOuEditar1() {
		Categoria categoria = new Categoria();
		categoria.setNome("Carnes");
		
		CategoriaDAO.inserirOuEditar(categoria);
		
		logger.info("Categoria inserida ou editada com sucesso ");
	}

	@Test
	@Order(8)
	public void inserirOuEditar2() {
		Categoria categoria = new Categoria();
		categoria.setCodigo(3);
		categoria.setNome("Frutas");
		
		CategoriaDAO.inserirOuEditar(categoria);
		
		logger.info("Categoria inserida ou editada com sucesso " + categoria);
	}
}