package controller;

import javax.faces.bean.*;

@ManagedBean(name = "adminController")
@SessionScoped
public class AdminController {

	public String linkDatPhong() {
		return "/admin/datphong?faces-redirect=true";
	}
	public String linkKhachHang() {
		return "/admin/khachhang?faces-redirect=true";
	}
	public String linkPhong() {
		return "/admin/phong?faces-redirect=true";
	}
}
