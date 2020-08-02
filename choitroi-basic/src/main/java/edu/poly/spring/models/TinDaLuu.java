package edu.poly.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TinDaLuu")
public class TinDaLuu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MaLuu;
	
	@ManyToOne
	@JoinColumn(name = "KhachHang")
	private TaiKhoan taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "DaiLy")
	private DaiLy daiLy;
	
	@ManyToOne
	@JoinColumn(name = "MaTinChiTiet")
	private BangTinChiTiet banTinChiTiet;
	
}
