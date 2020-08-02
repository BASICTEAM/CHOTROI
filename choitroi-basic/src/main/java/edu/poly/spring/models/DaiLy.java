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
@Table(name = "DaiLy")
public class DaiLy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String TenDangNhap;

	@Column(length = 100)
	private String MatKhau;

	@Column(length = 11)
	private String SDT;

	@Column(length = 40)
	private String Email;

	@Column(length = 50)
	private String HinhAnh;

	@Column(columnDefinition = "nvarchar(50)")
	private String TenDaiLy;
	
	@Column(length = 50)
	private String MSKD;

	@Column(length = 100, columnDefinition = "nvarchar(500)")
	private String DiaChi;

	@Column(length = 100, columnDefinition = "nvarchar(500)")
	private String ThongTin;

	@Column(length = 20)
	private String TrangThai;
	
	@OneToMany(mappedBy = "daiLy", cascade = CascadeType.ALL)
	private Set<BangTin> banTin;
	
	@OneToMany(mappedBy = "daiLy", cascade = CascadeType.ALL)
	private Set<TinDaLuu> tinDaLuu;
	
	@OneToMany(mappedBy = "daiLy", cascade = CascadeType.ALL)
	private Set<DanhGia> danhGia;
}
