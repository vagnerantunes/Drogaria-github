package util;

import org.junit.jupiter.api.Test;

public class JPAUtilTest {
	
	@Test
	public void getEntityManager() {
		JPAUtil.getEntityManager();
		System.out.println("Sessão obtida com sucesso!");
	}
	
}
