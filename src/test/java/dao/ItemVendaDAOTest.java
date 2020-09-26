package dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import domain.ItemVenda;

@TestMethodOrder(OrderAnnotation.class)
public class ItemVendaDAOTest {
	private static ItemVendaDAO ItemVendaDAO;
	
	@BeforeAll
	public static void iniciar() {
		ItemVendaDAO = new ItemVendaDAO();
	}

	@Test
	@Order(1)
	public void inserir1() {
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setQuantidadeParcial(1);
		//lancar valores tipo estrangeiro e big decimal
		
		ItemVendaDAO.inserir(itemVenda);
		
	}
	
	
}
