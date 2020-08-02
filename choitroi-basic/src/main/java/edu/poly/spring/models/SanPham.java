package edu.poly.spring.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MaSanPham;

	@Column(length = 100)
	private String TenSanPham;
	
	@ManyToOne
	@JoinColumn(name = "MaLoaiHang")
	private LoaiHang loaiHang;
	
	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
	private Set<BangTin> banTin;
	
}
