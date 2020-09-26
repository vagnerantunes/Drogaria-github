package dao;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import domain.Cliente;

@TestMethodOrder(OrderAnnotation.class)
public class ClienteDAOTest {
	private static ClienteDAO ClienteDAO;
	private static Logger logger;

	@BeforeAll
	public static void Iniciar() {
		logger = Logger.getLogger(ClienteDAOTest.class.getName());
		ClienteDAO = new ClienteDAO();
	}

	@Test
	@Order(1)
	public void inserir1() {
		Cliente cliente = new Cliente();
		cliente.setNome("Vagner");
		cliente.setCpf("097.551.319-22");

		ClienteDAO.inserir(cliente);
		logger.info("Cliente inserido com sucesso!" + cliente);
	}

	@Test
	@Order(2)
	public void inserir2() {
		Cliente cliente = new Cliente();
		cliente.setNome("Rosa");
		cliente.setCpf("000.000.000-00");

		ClienteDAO.inserir(cliente);
		logger.info("Cliente inserido com sucesso!" + cliente);
	}

	@Test
	@Order(3)
	public void buscarPorCodigo() {
		Cliente cliente = ClienteDAO.buscarPorCodigo(1);
		logger.info("busca concluida com sucesso!" + cliente);
	}

	@Test
	@Order(4)
	public void listar() {
		List<Cliente> clientes = ClienteDAO.buscarTudo();

		logger.info("Listagem das categorias!");
		for (Cliente cliente : clientes) {
			logger.info(cliente.toString());
		}
	}

	@Test
	@Order(5)
	public void excluir() {
		int codigo = 1;
		ClienteDAO.excluir(codigo);
		logger.info("Cliente removido com sucesso: " + codigo);
	}

	@Test
	@Order(6)
	public void editar() {
		int codigo = 2;
		Cliente cliente = new Cliente();
		cliente.setNome("Antonio Antunes");
		cliente.setCpf("111.111.111-22");

		ClienteDAO.editar(codigo, cliente);

		logger.info("Cliente editado com sucesso: " + codigo + " - " + cliente);
	}

	@Test
	@Order(7)
	public void inserirOuEditar1() {
		Cliente cliente = new Cliente();
		cliente.setNome("Karina Larissa");
		cliente.setCpf("333.333.333-55");

		ClienteDAO.inserirOuEditar(cliente);

		logger.info("Cliente inserido ou editado com sucesso " + cliente);

	}

	@Test
	@Order(8)
	public void inserirOuEditar() {
		Cliente cliente = new Cliente();
		cliente.setCodigo(3);
		cliente.setNome("Ana Karolina");
		cliente.setCpf("123.456.789-00");
		
		ClienteDAO.inserirOuEditar(cliente);
		
		logger.info("Cliente editado com sucesso " + cliente);
	}
}