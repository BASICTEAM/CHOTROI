package edu.poly.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100)
	private String username;

	@Column(length = 100)
	private String password;

	@Column(length = 100)
	private String email;

	@Column(length = 11)
	private String phone;

	@Column(columnDefinition = "nvarchar(100)")
	private String nameShop;

	@Column(length = 100)
	private String numberShop;

	@Column(length = 100, columnDefinition = "nvarchar(100)")
	private String address;

	@Column(length = 100, columnDefinition = "nvarchar(100)")
	private String information;

	@Column(length = 100)
	private String status;
	
	public Shop() {
		super();
	}

	public Shop(Integer id, String username, String password, String email, String phone, String nameShop,
			String numberShop, String address, String information, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.nameShop = nameShop;
		this.numberShop = numberShop;
		this.address = address;
		this.information = information;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNameShop() {
		return nameShop;
	}

	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

	public String getNumberShop() {
		return numberShop;
	}

	public void setNumberShop(String numberShop) {
		this.numberShop = numberShop;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
