package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;

import org.primefaces.context.RequestContext;

import entities.Khachhang;
import model.KhachHangModel;

@ManagedBean(name = "khachHangController")
@SessionScoped
public class KhachHangController {
	private Khachhang khachhang;
	private String diss = "show";

	public String getDiss() {
		return diss;
	}

	public void setDiss(String diss) {
		this.diss = diss;
	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public List<Khachhang> findAll() {
		return new KhachHangModel().findAll();
	}

	public String redirect(Khachhang khachhang) {
		this.khachhang = khachhang;
		this.diss = "show";
		return "/admin/infokhach?faces-redirect=true";
	}

	public String redirect2(Khachhang khachhang) {
		this.khachhang = khachhang;
		this.diss = "hide";
		return "/admin/infokhach?faces-redirect=true";
	}

	public String saveChange() {
		try {
			new KhachHangModel().update(khachhang);
			khachhang = new Khachhang();
			showMessage("Change info", "Lưu thành công.");
			return "/admin/khachhang?faces-redirect=true";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			showMessage("Change info", "Lưu không thành công.");
			return "/admin/infokhach?faces-redirect=true";
		}
	}

	public void showMessage(String title, String mesage) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, title, mesage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
