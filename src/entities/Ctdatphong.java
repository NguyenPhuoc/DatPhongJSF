package entities;
// Generated Oct 12, 2015 11:23:25 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ctdatphong generated by hbm2java
 */
@Entity
@Table(name = "ctdatphong", catalog = "datphongjsf")
public class Ctdatphong implements java.io.Serializable {

	private Integer id;
	private Khachhang khachhang;
	private Phong phong;
	private Date ngayDat;
	private Date ngayNhan;
	private Date ngayTra;
	private Date checkin;
	private Date checkout;
	private int status;

	public Ctdatphong() {
		this.status = 1;
	}

	public Ctdatphong(Khachhang khachhang, Phong phong, Date ngayDat, Date ngayNhan, Date ngayTra, int status) {
		this.khachhang = khachhang;
		this.phong = phong;
		this.ngayDat = ngayDat;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.status = status;
	}

	public Ctdatphong(Khachhang khachhang, Phong phong, Date ngayDat, Date ngayNhan, Date ngayTra, Date checkin,
			Date checkout, int status) {
		this.khachhang = khachhang;
		this.phong = phong;
		this.ngayDat = ngayDat;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.checkin = checkin;
		this.checkout = checkout;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDKhach", nullable = false)
	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPhong", nullable = false)
	public Phong getPhong() {
		return this.phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayDat", nullable = false, length = 0)
	public Date getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayNhan", nullable = false, length = 0)
	public Date getNgayNhan() {
		return this.ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayTra", nullable = false, length = 0)
	public Date getNgayTra() {
		return this.ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Checkin", length = 0)
	public Date getCheckin() {
		return this.checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Checkout", length = 0)
	public Date getCheckout() {
		return this.checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	@Column(name = "Status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
