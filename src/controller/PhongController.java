package controller;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import javax.faces.bean.*;

import entities.Phong;
import model.PhongModel;

@ManagedBean(name = "phongController")
@SessionScoped
public class PhongController {
	private Phong phong = new Phong();
	private Phong phong2 = new Phong();
	private String id = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Phong getPhong2() {
		return phong2;
	}

	public void setPhong2(Phong phong2) {
		this.phong2 = phong2;
	}

	String _hide = "hide";
	String _show = "show";

	public String getDisplayAdd() {
		return displayAdd;
	}

	public void setDisplayAdd(String displayAdd) {
		this.displayAdd = displayAdd;
	}

	public String getDisplayChange() {
		return displayChange;
	}

	public void setDisplayChange(String displayChange) {
		this.displayChange = displayChange;
	}

	private String displayAdd = _show;
	private String displayChange = _show;

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong2 = phong;
	}

	public List<Phong> findAll() {
		return new PhongModel().findAll();
	}

	public void addRoom() {
		try {
			new PhongModel().create(this.phong);
			phong = new Phong();
			showMessage("ADD NEW ROOM", "Thêm phòng thành công.");
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
			showMessage("ADD NEW ROOM", "Thêm phòng không thành công.");
		}
	}

	public void updateStatus(Phong phong) {
		try {

			if (phong.getStatus() == 1)
				phong.setStatus(0);
			else
				phong.setStatus(1);
			new PhongModel().update(phong);
			showMessage("Update status", "Update status success.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			showMessage("Update status", "Update status failed.");
		}
	}

	public void changePhong(Phong phong) {
		this.phong2 = phong;
	}

	public void changePhong2() {
		try {
			new PhongModel().update(phong2);
			phong2 = new Phong();
			showMessage("Change info", "Change info room success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			showMessage("Change info", "Change info room failed");
		}

	}

	public void showMessage(String title, String mesage) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, title, mesage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void redirect() {
		Map x = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		this.id = (String) x.get("khach");
		System.out.println("aaa: " + id);
	}
}
