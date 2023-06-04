package btcanhan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import btcanhan.entity.NhanVien;
import btcanhan.repository.NhanVienRepository;
import btcanhan.repository.PhongBanRepository;


@Service
public class NhanVienService {

	@Autowired
	private NhanVienRepository nhanvienrepo;
	@Autowired
	private PhongBanRepository phongbanrepo;
	public List<NhanVien> GetAll()
	{
		return(List<NhanVien>) nhanvienrepo.findAll();
	}
	public void add(NhanVien newNhanVien)
	{
		nhanvienrepo.save(newNhanVien);
	}
	public void delete(String id)
	{
		nhanvienrepo.deleteById(id);
	}
	public NhanVien getById(String id)
	{	
		Optional<NhanVien> optional = nhanvienrepo.findById(id);
		NhanVien employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}
	public void edit(NhanVien editNV) {
		NhanVien NV=nhanvienrepo.findById(editNV.getMa_NV()).get();
		if(NV!=null) {
			NV.setPhai(editNV.getPhai());
			NV.setLuong(editNV.getLuong());
			NV.setNoi_Sinh(editNV.getNoi_Sinh());
			NV.setPhongban(editNV.getPhongban());
			NV.setTen_NV(editNV.getTen_NV());
		}
		nhanvienrepo.save(NV);
	}
}
