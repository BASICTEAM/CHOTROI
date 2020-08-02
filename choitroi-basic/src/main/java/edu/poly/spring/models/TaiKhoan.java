package edu.poly.spring.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "nvarchar(50)")
	private String TenDangNhap;

	@Column(length = 50)
	private String MatKhau;

	@Column(length = 11)
	private String SDT;

	@Column(length = 50)
	private String Email;

	@Column(length = 50)
	private String HinhAnh;

	@Column(columnDefinition = "nvarchar(100)")
	private String HoTen;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date NgaySinh;

	@Column(columnDefinition = "nvarchar(500)")
	private String DiaChi;

	@Column(length = 20)
	private String TrangThai;
	
	@Column
	private boolean VaiTro;
	
	@Column
	private boolean GioiTinh;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
	private Set<BangTin> banTin;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
	private Set<TinDaLuu> tinDaLuu;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
	private Set<DanhGia> danhGia;
	
}
