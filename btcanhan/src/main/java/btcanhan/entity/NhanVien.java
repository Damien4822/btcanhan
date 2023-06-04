package btcanhan.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="NhanVien")
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
	@Id
	@NotNull
	@Length(min=0,max=3)
	private String Ma_NV;
	@Column
	@NotNull(message = "Tên nhân viên k đc để trống")
	@Length(min=0,max=100)
	private String Ten_NV;
	@Column
	@Length(min=0,max=3)
	private String Phai;
	@Column
	@Length(min=0,max=200)
	private String Noi_Sinh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Ma_Phong")
	private PhongBan phongban;
	@Column
	private int luong;
	public String getMa_NV() {
		return Ma_NV;
	}
	public void setMa_NV(String ma_NV) {
		Ma_NV = ma_NV;
	}
	public String getTen_NV() {
		return Ten_NV;
	}
	public void setTen_NV(String ten_NV) {
		Ten_NV = ten_NV;
	}
	public String getPhai() {
		return Phai;
	}
	public void setPhai(String phai) {
		Phai = phai;
	}
	public String getNoi_Sinh() {
		return Noi_Sinh;
	}
	public void setNoi_Sinh(String noi_Sinh) {
		Noi_Sinh = noi_Sinh;
	}
	public PhongBan getPhongban() {
		return phongban;
	}
	public void setPhongban(PhongBan phongban) {
		this.phongban = phongban;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	
	
}
