package dao;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import domain.Funcionario;

@TestMethodOrder(OrderAnnotation.class)
public class FuncionarioDAOTest {
	private static FuncionarioDAO FuncionarioDAO;
	private static Logger logger;

	@BeforeAll
	public static void iniciar() {
		FuncionarioDAO = new FuncionarioDAO();
		logger = Logger.getLogger(FuncionarioDAOTest.class.getName());
	}

	@Test
	@Order(1)
	public void inserir1() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Ana Carolina Antunes");
		funcionario.setCpf("111.111.111-11");

		FuncionarioDAO.inserir(funcionario);
		logger.info("funcionario inserido com sucesso! " + funcionario);
	}

	@Test
	@Order(2)
	public void inserir2() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Karina Larissa Antunes de souza");
		funcionario.setCpf("222.222.222-22");

		FuncionarioDAO.inserir(funcionario);
		logger.info("funcionario inserido com sucesso! " + funcionario);
	}

	@Test
	@Order(3)
	public void buscarPorCodigo() {
		Funcionario funcionario = FuncionarioDAO.buscarPorCodigo(1);
		logger.info("funcionario encontrado! " + funcionario);
	}

	@Test
	@Order(4)
	public void listar() {
		List<Funcionario> funcionarios = FuncionarioDAO.buscarTudo();

		logger.info("listagem dos funcionarios!");
		for (Funcionario funcionario : funcionarios) {
			logger.info(funcionario.toString());
		}
	}

	@Test
	@Order(5)
	public void excluir() {
		int codigo = 1;
		FuncionarioDAO.excluir(codigo);
		logger.info("Funcionario removido com sucesso: " + codigo);
	}
	
	@Test
	@Order(6)
	public void editar() {
		int codigo = 2;
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Dida");
		funcionario.setCpf("123.456.789-12");
		
		FuncionarioDAO.editar(codigo, funcionario);
		
		logger.info("Funcionario editado com sucesso: " + codigo + " - " + funcionario);
	}
	
	@Test
	@Order(7)
	public void inserirOuEditar1() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Roberto Carlos");
		funcionario.setCpf("333.333.333-33");
		
		FuncionarioDAO.inserirOuEditar(funcionario);
		
		logger.info("Funcionario inserido ou editado com sucesso ");
	}
	
	@Test
	@Order(8)
	public void inserirOuEditar2(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(3);
		funcionario.setNome("Cicinho");
		funcionario.setCpf("123.456.789-33");
		
		FuncionarioDAO.inserirOuEditar(funcionario);
		
		logger.info("Funcionario inserido ou editado com suecesso " + funcionario);
	}
}