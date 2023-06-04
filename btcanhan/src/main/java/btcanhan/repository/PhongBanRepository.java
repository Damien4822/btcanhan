package btcanhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import btcanhan.entity.PhongBan;
@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {

}
