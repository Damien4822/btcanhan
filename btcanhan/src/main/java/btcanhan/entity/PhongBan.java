package btcanhan.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="PhongBan")
public class PhongBan {
	@Id
	@Length(min=0,max=2)
	@NotNull(message = "mã phòng ban k dc để trống")
	private String Ma_Phong;
	@Column
	@Length(min=0,max=30)
	@NotNull(message = "tên phòng ban k dc để trống")
	private String Ten_Phong;
	@OneToMany(cascade = CascadeType.ALL)
	private List<NhanVien> listnhanviens;
	public String getMa_Phong() {
		return Ma_Phong;
	}
	public void setMa_Phong(String ma_Phong) {
		Ma_Phong = ma_Phong;
	}
	public String getTen_Phong() {
		return Ten_Phong;
	}
	public void setTen_Phong(String ten_Phong) {
		Ten_Phong = ten_Phong;
	}
	public List<NhanVien> getListnhanviens() {
		return listnhanviens;
	}
	public void setListnhanviens(List<NhanVien> listnhanviens) {
		this.listnhanviens = listnhanviens;
	}
	
}
