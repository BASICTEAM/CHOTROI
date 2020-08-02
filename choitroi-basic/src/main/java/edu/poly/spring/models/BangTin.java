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
@Table(name = "BangTin")
public class BangTin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer MaTin;
	
	@Column(length = 100)
	private boolean LoaiTin;
	
	@ManyToOne
	@JoinColumn(name = "ID", insertable=false, updatable=false)
	private TaiKhoan taiKhoan;
	
	@ManyToOne
	@JoinColumn(name = "ID", insertable=false, updatable=false)
	private DaiLy daiLy;
	
	@ManyToOne
	@JoinColumn(name = "MaSanPham")
	private SanPham sanPham;
	
	@OneToMany(mappedBy = "banTin", cascade = CascadeType.ALL)
	private Set<BangTinChiTiet> banTinChiTiet;

	public Integer getMaTin() {
		return MaTin;
	}

	public void setMaTin(Integer maTin) {
		MaTin = maTin;
	}

	public boolean isLoaiTin() {
		return LoaiTin;
	}

	public void setLoaiTin(boolean loaiTin) {
		LoaiTin = loaiTin;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public DaiLy getDaiLy() {
		return daiLy;
	}

	public void setDaiLy(DaiLy daiLy) {
		this.daiLy = daiLy;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public Set<BangTinChiTiet> getBanTinChiTiet() {
		return banTinChiTiet;
	}

	public void setBanTinChiTiet(Set<BangTinChiTiet> banTinChiTiet) {
		this.banTinChiTiet = banTinChiTiet;
	}
	
}
