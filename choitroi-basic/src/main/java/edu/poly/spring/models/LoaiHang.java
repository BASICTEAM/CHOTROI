package edu.poly.spring.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiHang")
public class LoaiHang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MaLoaiHang;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String TenLoaiHang;
	
	@OneToMany(mappedBy = "loaiHang", cascade = CascadeType.ALL)
	private Set<SanPham> sanPham;
	
}
