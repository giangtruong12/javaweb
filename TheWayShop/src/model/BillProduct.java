package model;

import lombok.Data;

@Data
public class BillProduct {		// gio hang
	private int id;
	private int quantity;
	private long unitPrice;
	private Bill bill;
	private Product product;
	
}
