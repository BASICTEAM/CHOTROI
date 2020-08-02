package edu.poly.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DanhGia")
public class DanhGia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MaDanhGia;
	
	@Column(columnDefinition = "nvarchar(500)")
	private String LyDo;
	
	@Column
	private Integer LoaiDanhGia;
	
	@ManyToOne
	@JoinColumn(name = "KhachHang")
	private TaiKhoan taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "DaiLy")
	private DaiLy daiLy;
	
}
