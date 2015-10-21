package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import java.util.*;
import entities.*;
import model.*;

@ManagedBean(name = "datPhongController")
@SessionScoped
public class DatPhongController {
	private Khachhang khachhang;
	private Ctdatphong ctdatphong;
	private double moneyToPay;

	public double getMoneyToPay() {
		return moneyToPay;
	}

	public void setMoneyToPay(double moneyToPay) {
		this.moneyToPay = moneyToPay;
	}

	public Ctdatphong getCtdatphong() {
		return ctdatphong;
	}

	public void setCtdatphong(Ctdatphong ctdatphong) {
		this.ctdatphong = ctdatphong;
	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public List<Ctdatphong> findAll() {
		return new CTDatPhongModel().findAll();
	}

	public void checkIn(Ctdatphong ctdatphong) {
		ctdatphong.setCheckin(Calendar.getInstance().getTime());
		ctdatphong.setStatus(3);
		new CTDatPhongModel().update(ctdatphong);
		// return "/admin/datphong?faces-redirect=true";
	}

	public void checkOut(Ctdatphong ctdatphong) {
		this.ctdatphong = ctdatphong;
		this.ctdatphong.setCheckout(Calendar.getInstance().getTime());
		this.ctdatphong.setStatus(4);
		//int d = this.ctdatphong.getCheckout().compareTo(this.ctdatphong.getCheckin());
		//this.moneyToPay = ++d * this.ctdatphong.getPhong().getPrice();
		new CTDatPhongModel().update(this.ctdatphong);
		//return "infobill?faces-redirect=true";
	}

	public void xacNhan(Ctdatphong ctdatphong) {
		ctdatphong.setStatus(2);
		new CTDatPhongModel().update(ctdatphong);
	}

	public void huyDon(Ctdatphong ctdatphong) {
		ctdatphong.setStatus(5);
		new CTDatPhongModel().update(ctdatphong);
	}

	public void infoKhachHang(Khachhang khachhang) {
		this.khachhang = khachhang;
		RequestContext.getCurrentInstance().openDialog("infoKhachHang");
		// FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
		// "Thông tin khách hàng", "Xin chào!"+khachhang.getName());

		// RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public String infoBill(Ctdatphong ctdatphong) {
		this.ctdatphong = ctdatphong;
		long d1=ctdatphong.getCheckin().getTime();
		long d2=ctdatphong.getCheckout().getTime();
		long d = Math.abs((d1-d2)/(1000*60*60*24));
		System.out.println(Math.abs((d1-d2)/(1000*60*60*24)));
		this.moneyToPay = ++d * ctdatphong.getPhong().getPrice();
		return "infobill?faces-redirect=true";
	}

	public String okBill() {
		return "datphong?faces-redirect=true";
	}

}
