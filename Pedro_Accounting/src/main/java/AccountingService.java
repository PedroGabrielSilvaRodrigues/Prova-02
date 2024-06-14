

	import java.util.List;
	import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.DataIntegrityViolationException;
	import org.springframework.stereotype.Service;

import DTO.AccountingDTO1;
import repositor.AccountingRepository;
import util.AccountingEntity;
import util.AccountingEntityConverter;

	@Service
	public class AccountingService<AccountingDTO> {

	    private AccountingRepository repo;

	    @Autowired
	    private AccountingEntityConverter converter;

	    @Autowired
	    public AccountingService(AccountingRepository repo) {
	        this.repo = repo;
	    }

	    public List<AccountingDTO1> findAll() {
	        return repo.findAll().stream().map(AccountingEntityConverter::toDTO)
	                .collect(Collectors.toList());
	    }

	    public AccountingEntity findById(Integer itemCode) {
	        Optional<AccountingEntity> obj = repo.findById(itemCode);
	        return obj.orElseThrow();
	    }

	    public List<AccountingDTO1> findByActive(boolean active) {
	        return repo.findByActive(active).stream().map(AccountingEntityConverter::toDTO)
	                .collect(Collectors.toList());
	    }

	    public void createAccounting(AccountingDTO accounting) {
	        repo.saveAll(converter.toEntity(accounting));
	    }

	    public void updateAccounting(AccountingDTO accounting, Integer itemCode) {
	        if (itemCode == null || accounting == null || !itemCode.equals(((AccountingEntity) accounting).getItemCode())) {
	            throw new AccountingException("Invalid item code.");
	        }
	        AccountingEntity existingObj = findById(itemCode);
	        updateData(existingObj, accounting);
	        repo.save(existingObj);
	    }

	    private void updateData(AccountingEntity existingObj, AccountingDTO newObj) {
	        existingObj.setType(newObj.getType());
	        existingObj.setDescription(newObj.getDescription());
	        existingObj.setTransactionDate(newObj.getTransactionDate());
	        existingObj.setValue(newObj.getValue());
	        existingObj.setProfit(newObj.getProfit());
	    }

	    public void deleteAccounting(Integer itemCode) {
	        if (itemCode == null) {
	            throw new AccountingException("Item code can not be null.");
	        }
	        AccountingEntity obj = findById(itemCode);
	        try {
	            repo.delete(obj);
	        } catch (DataIntegrityViolationException e) {
	            throw new AccountingException("Can not delete an Accounting entry with dependencies constraints.");
	        }
	    }
	}
}
