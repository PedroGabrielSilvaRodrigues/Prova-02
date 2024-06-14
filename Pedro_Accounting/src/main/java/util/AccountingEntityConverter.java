package util;



import org.springframework.stereotype.Component;

import DTO.AccountingDTO1;


@Component
public class AccountingEntityConverter {
    
    public static AccountingDTO1 toDTO(AccountingEntity account) {
        return new AccountingDTO1(
                account.getItemCode(), account.getType(), 
                account.getDescription(), account.getTransactionDate(), 
                account.getValue(), account.getProfit(), 
                account.isActive());
    }
    
    public AccountingEntity toEntity(AccountingDTO1 dto) {
        return new AccountingEntity(dto.getItemCode(), dto.getType(),
                dto.getDescription(), dto.getTransactionDate(),
                dto.getValue(), dto.getProfit(), dto.isActive());
    }

	public <AccountingDTO> Object toEntity(AccountingDTO accounting) {
		// TODO Auto-generated method stub
		return null;
	}
}