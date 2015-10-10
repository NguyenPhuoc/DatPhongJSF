package controller;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.*;

@ManagedBean(name = "indexController")
@SessionScoped
public class IndexController {
	private Date toDay = Calendar.getInstance().getTime();

	public Date getToDay() {
		return toDay;
	}

	public void setToDay(Date toDay) {
		this.toDay = toDay;
	}

	private Date ngayNhan;
	private Date ngayTra;

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String linkIndex() {
		return "index?faces-redirect=true";
	}

	public String linkAdmin() {
		return "admin?faces-redirect=true";
	}
}
