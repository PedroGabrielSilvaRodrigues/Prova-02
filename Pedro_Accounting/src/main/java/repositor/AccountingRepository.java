package repositor;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import util.AccountingEntity;

@Repository
public interface AccountingRepository extends JpaRepository<AccountingEntity, Integer> {

    public List<AccountingEntity> findByActive(boolean active);

	public void saveAll(Object entity);

}