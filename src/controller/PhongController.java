package controller;

import java.util.List;

import javax.faces.bean.*;

import entities.Phong;
import model.PhongModel;

@ManagedBean(name = "phongController")
@SessionScoped
public class PhongController {
	public List<Phong> findAll() {
		return new PhongModel().findAll();
	}
}
