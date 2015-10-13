package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.*;

import entities.Ctdatphong;
import entities.Khachhang;
import entities.Phong;
import model.CTDatPhongModel;
import model.KhachHangModel;
import model.PhongModel;

@ManagedBean(name = "indexController")
@SessionScoped
public class IndexController {
	private final String _BLOCK = "block";
	private final String _NONE = "none";
	private Date toDay = Calendar.getInstance().getTime();
	private String displayRoom = _NONE;
	private String displayBookRoom = _NONE;
	private String displayBookSuccess = _NONE;
	private String displayCheck = _BLOCK;
	private String displayCheckStatus = _NONE;

	public String getDisplayCheckStatus() {
		return displayCheckStatus;
	}

	public void setDisplayCheckStatus(String displayCheckStatus) {
		this.displayCheckStatus = displayCheckStatus;
	}

	private String message = "";
	private Phong phong;
	private Khachhang khachhang;
	private List<Phong> phongs;
	private Date ngayNhan;
	private Date ngayTra;

	public String getDisplayBookRoom() {
		return displayBookRoom;
	}

	public void setDisplayBookRoom(String displayBookRoom) {
		this.displayBookRoom = displayBookRoom;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public String getDisplayRoom() {
		return displayRoom;
	}

	public void setDisplayRoom(String displayRoom) {
		this.displayRoom = displayRoom;
	}

	public String getDisplayCheck() {
		return displayCheck;
	}

	public void setDisplayCheck(String displayCheck) {
		this.displayCheck = displayCheck;
	}

	public List<Phong> getPhongs() {
		return phongs;
	}

	public void setPhongs(List<Phong> phongs) {
		this.phongs = phongs;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getToDay() {
		return toDay;
	}

	public void setToDay(Date toDay) {
		this.toDay = toDay;
	}

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

	public void checkRoom() {
		this.message = "";
		List<Phong> lstPhong = new PhongModel().findAll();
		List<Ctdatphong> lstCTDP = new CTDatPhongModel().findAll();
		for (Ctdatphong ct : lstCTDP)
			if (ct.getStatus() < 4)
				if ((this.ngayNhan.after(ct.getNgayNhan()) && this.ngayNhan.before(ct.getNgayTra()))
						|| this.ngayNhan.equals(ct.getNgayNhan()) || this.ngayNhan.equals(ct.getNgayTra()))
					lstPhong.remove(ct.getPhong());
				else if ((this.ngayTra.after(ct.getNgayNhan()) && this.ngayTra.before(ct.getNgayTra()))
						|| this.ngayTra.equals(ct.getNgayNhan()) || this.ngayTra.equals(ct.getNgayTra()))
					lstPhong.remove(ct.getPhong());
				else if ((ct.getNgayNhan().after(this.ngayNhan) && ct.getNgayNhan().before(this.ngayTra))
						|| ct.getNgayNhan().equals(this.ngayNhan) || ct.getNgayNhan().equals(this.ngayTra))
					lstPhong.remove(ct.getPhong());
				else if ((ct.getNgayTra().after(this.ngayNhan) && ct.getNgayTra().before(this.ngayTra))
						|| ct.getNgayTra().equals(this.ngayNhan) || ct.getNgayTra().equals(this.ngayTra))
					lstPhong.remove(ct.getPhong());

		phongs = new ArrayList<Phong>();
		if (lstPhong.size() == 0) {
			this.message = "Không tìm thấy phòng trống nào";
			this.displayRoom = _NONE;
			this.displayCheckStatus = _BLOCK;
		} else {
			phongs = lstPhong;
			this.displayRoom = "table";
			this.displayCheckStatus = _NONE;
		}

		for (Phong phong : phongs)
			if (phong.getStatus() == 0)
				phongs.remove(phong);

	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public void bookRoom(Phong phong) {
		this.displayCheck = _NONE;
		this.displayBookRoom = _BLOCK;
		khachhang = new Khachhang();
		this.phong = phong;
	}

	public void submitBookRoom() {
		try {
			new KhachHangModel().create(khachhang);

			Ctdatphong ctdatphong = new Ctdatphong();

			ctdatphong.setPhong(phong);
			ctdatphong.setKhachhang(khachhang);
			ctdatphong.setNgayNhan(ngayNhan);
			ctdatphong.setNgayTra(ngayTra);
			ctdatphong.setNgayDat(toDay);

			new CTDatPhongModel().create(ctdatphong);
			this.displayBookRoom = _NONE;
			this.displayBookSuccess = _BLOCK;
		} catch (Exception e) {
			this.message = "Đặt vé không thành công.";
			System.out.println(e.getMessage());
		}
	}

	public String getDisplayBookSuccess() {
		return displayBookSuccess;
	}

	public void setDisplayBookSuccess(String displayBookSuccess) {
		this.displayBookSuccess = displayBookSuccess;
	}

	public void reset() {
		this.displayCheck = _BLOCK;
		this.displayRoom = _NONE;
		this.displayBookRoom = _NONE;
		this.displayBookSuccess = _NONE;
	}

	public void back() {
		this.displayCheck = _BLOCK;
		this.displayRoom = _BLOCK;
		this.displayBookRoom = _NONE;
		this.displayBookSuccess = _NONE;
	}

	public String linkIndex() {
		return "/index?faces-redirect=true";
	}

	public String linkAdmin() {
		return "/admin/index?faces-redirect=true";
	}
}
