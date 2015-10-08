package controller;

import javax.faces.bean.*;

@ManagedBean(name="indexController")
@SessionScoped
public class IndexController {
	
	public String linkIndex() {
		return "index?faces-redirect=true";
	}

}
