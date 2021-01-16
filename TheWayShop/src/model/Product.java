package model;

import lombok.Data;

@Data
public class Product {	// san pham
	private int id;
	private String name;
	private String image;
	private int price;
	private String describe;	// mo ta
	private Category category;
}
