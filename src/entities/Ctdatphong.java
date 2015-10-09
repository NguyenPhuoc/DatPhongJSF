package entities;
// Generated Oct 9, 2015 3:18:50 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private CtdatphongId id;
	private Khachhang khachhang;
	private Phong phong;
	private Date ngayNhan;
	private Date ngayTra;
	private Date checkin;
	private Date checkout;
	private Date ngayDat;
	private int status;

	public Ctdatphong() {
	}

	public Ctdatphong(CtdatphongId id, Khachhang khachhang, Phong phong, Date ngayNhan, Date ngayTra, Date ngayDat,
			int status) {
		this.id = id;
		this.khachhang = khachhang;
		this.phong = phong;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.ngayDat = ngayDat;
		this.status = status;
	}

	public Ctdatphong(CtdatphongId id, Khachhang khachhang, Phong phong, Date ngayNhan, Date ngayTra, Date checkin,
			Date checkout, Date ngayDat, int status) {
		this.id = id;
		this.khachhang = khachhang;
		this.phong = phong;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.checkin = checkin;
		this.checkout = checkout;
		this.ngayDat = ngayDat;
		this.status = status;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idkhach", column = @Column(name = "IDKhach", nullable = false) ),
			@AttributeOverride(name = "idphong", column = @Column(name = "IDPhong", nullable = false) ) })
	public CtdatphongId getId() {
		return this.id;
	}

	public void setId(CtdatphongId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDKhach", nullable = false, insertable = false, updatable = false)
	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPhong", nullable = false, insertable = false, updatable = false)
	public Phong getPhong() {
		return this.phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayDat", nullable = false, length = 0)
	public Date getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	@Column(name = "Status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
