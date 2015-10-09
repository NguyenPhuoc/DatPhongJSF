package entities;
// Generated Oct 9, 2015 3:18:50 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Khachhang generated by hbm2java
 */
@Entity
@Table(name = "khachhang", catalog = "datphongjsf")
public class Khachhang implements java.io.Serializable {

	private Integer id;
	private int cmnd;
	private String name;
	private int gender;
	private String phone;
	private String email;
	private String address;
	private Set<Ctdatphong> ctdatphongs = new HashSet<Ctdatphong>(0);

	public Khachhang() {
	}

	public Khachhang(int cmnd, String name, int gender, String phone, String email, String address) {
		this.cmnd = cmnd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Khachhang(int cmnd, String name, int gender, String phone, String email, String address,
			Set<Ctdatphong> ctdatphongs) {
		this.cmnd = cmnd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.ctdatphongs = ctdatphongs;
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

	@Column(name = "CMND", nullable = false)
	public int getCmnd() {
		return this.cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Gender", nullable = false)
	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column(name = "Phone", nullable = false, length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Email", nullable = false, length = 254)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Address", nullable = false, length = 254)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khachhang")
	public Set<Ctdatphong> getCtdatphongs() {
		return this.ctdatphongs;
	}

	public void setCtdatphongs(Set<Ctdatphong> ctdatphongs) {
		this.ctdatphongs = ctdatphongs;
	}

}
