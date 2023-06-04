package btcanhan.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import btcanhan.entity.NhanVien;
import btcanhan.entity.PhongBan;
import btcanhan.services.NhanVienService;
import btcanhan.services.PhongBanService;
import jakarta.validation.Valid;

@RequestMapping("")
@Controller
public class NhanVienController {

	@Autowired 
	private NhanVienService nhanvienService;
	@Autowired
	private PhongBanService phongbanService;
	@GetMapping("/index")
	public String index(Model model)
	{
		model.addAttribute("listNhanVien",nhanvienService.GetAll());
		return "NhanViens/index";
	}
	@GetMapping("/create")
	public String create(Model model)
	{
		List<PhongBan> listPhongBans = phongbanService.GetAll();
		model.addAttribute("nhanvien",new NhanVien());
		model.addAttribute("listphongban",listPhongBans);
		return "NhanViens/create";
	}
	@PostMapping("/create")
	public String create( @Valid NhanVien newNhanVien,BindingResult result,Model model) {
	        
		if(result.hasErrors())
		{
			model.addAttribute("nhanvien",newNhanVien);
			List<PhongBan> listPhongBans = phongbanService.GetAll();
			model.addAttribute("listphongban",listPhongBans);
			return "NhanViens/create";
		}
		nhanvienService.add(newNhanVien);
	    return "redirect:/index";
	}
	@GetMapping("/edit/{Ma_NV}")
	public String edit(@PathVariable(name = "Ma_NV") String Ma_NV,Model model)
	{
		NhanVien editNV= nhanvienService.getById(Ma_NV);
		if(editNV!=null)
		{
		model.addAttribute("nhanvien", editNV);
		List<PhongBan> listPhongBans = phongbanService.GetAll();
		model.addAttribute("listphongban",listPhongBans);
		return "NhanViens/edit";
		}
		else 
			return "redirect:/index"; 
	}
	@PostMapping("/edit/{Ma_NV}")
	
	@RequestMapping("/delete/{Ma_NV}")
	public String delete(@PathVariable(name = "Ma_NV") String Ma_NV) {
		nhanvienService.delete(Ma_NV);
		return "redirect:/index";   
	}
	
}
