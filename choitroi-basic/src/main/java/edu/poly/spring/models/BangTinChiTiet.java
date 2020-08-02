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
@Table(name = "BangTinChiTiet")
public class BangTinChiTiet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MaTinChiTiet;
	
	@Column(columnDefinition = "nvarchar(150)")
	private String TieuDe;
	
	@Column(columnDefinition = "nvarchar(500)")
	private String NoiDung;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String HinhAnh;
	
	@Column
	private double Gia;
	
	@ManyToOne
	@JoinColumn(name = "MaTin")
	private BangTin banTin;
	
	@OneToMany(mappedBy = "banTinChiTiet", cascade = CascadeType.ALL)
	private Set<TinDaLuu> tinDaLuu;	
	
}
