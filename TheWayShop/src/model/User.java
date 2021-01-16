package model;

import lombok.Data;

@Data
public class User {		// nguoi mua va admin
	private int id;
	private String name;
	private String username;
	private String password;
	private int age;
	private String role;
}
