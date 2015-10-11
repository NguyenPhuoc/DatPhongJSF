package controller;

import java.util.List;

import javax.faces.bean.*;

import entities.Khachhang;
import model.KhachHangModel;

@ManagedBean(name = "khachHangController")
@SessionScoped
public class KhachHangController {
	public List<Khachhang> findAll() {
		return new KhachHangModel().findAll();
	}
}
