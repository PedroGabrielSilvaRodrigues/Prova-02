package util;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import repositor.AccountingRepository;



@SpringBootApplication
public abstract class AccountingApplication<repo, repo1> implements CommandLineRunner {

    @Autowired
    private AccountingRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(AccountingApplication.class, args);
    }

    public <repo> void run1(String... args) throws Exception {
        AccountingEntity a1 = new AccountingEntity(1, "Type1", "Description1", new Date(), 100.0, 20.0, false);
        repo.save(a1);
        AccountingEntity a2 = new AccountingEntity(2, "Type2", "Description2", new Date(), 150.0, 30.0, true);
        repo.save(a2);

        List<AccountingEntity> accountings = repo.findAll();
        System.out.println(accountings);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
