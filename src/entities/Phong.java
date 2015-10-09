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
 * Phong generated by hbm2java
 */
@Entity
@Table(name = "phong", catalog = "datphongjsf")
public class Phong implements java.io.Serializable {

	private Integer id;
	private String name;
	private long price;
	private int status;
	private Set<Ctdatphong> ctdatphongs = new HashSet<Ctdatphong>(0);

	public Phong() {
	}

	public Phong(String name, long price, int status) {
		this.name = name;
		this.price = price;
		this.status = status;
	}

	public Phong(String name, long price, int status, Set<Ctdatphong> ctdatphongs) {
		this.name = name;
		this.price = price;
		this.status = status;
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

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Price", nullable = false, precision = 10, scale = 0)
	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Column(name = "Status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phong")
	public Set<Ctdatphong> getCtdatphongs() {
		return this.ctdatphongs;
	}

	public void setCtdatphongs(Set<Ctdatphong> ctdatphongs) {
		this.ctdatphongs = ctdatphongs;
	}

}
