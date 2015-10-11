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
		ctdatphong.setCheckout(Calendar.getInstance().getTime());
		ctdatphong.setStatus(4);
		new CTDatPhongModel().update(ctdatphong);
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
		//FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thông tin khách hàng", "Xin chào!"+khachhang.getName());
        
       // RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
