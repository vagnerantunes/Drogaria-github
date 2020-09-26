package domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(nullable = false)
	private Integer quantidadeParcial;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal valorParcial;
	
	@Column(nullable = false)
	private Venda venda;
	
	@Column(nullable = false)
	private Lote lote;	
}
