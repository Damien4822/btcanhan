package btcanhan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btcanhan.entity.NhanVien;
import btcanhan.entity.PhongBan;
import btcanhan.repository.NhanVienRepository;
import btcanhan.repository.PhongBanRepository;
@Service
public class PhongBanService {
	@Autowired
	private PhongBanRepository phongbanrepo;
	public List<PhongBan> GetAll()
	{
		return(List<PhongBan>) phongbanrepo.findAll();
	}
}
