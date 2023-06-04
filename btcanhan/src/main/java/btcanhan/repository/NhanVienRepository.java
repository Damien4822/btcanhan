package btcanhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import btcanhan.entity.NhanVien;
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

}
