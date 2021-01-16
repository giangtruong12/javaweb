package model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class Bill implements Serializable { // class nguoi mua
	private int id;
	private User buyer; // nguoi mua
	public Date buyDate; // ngay mua
	private long priceTotal; // tong gia
	
}
