package Entily;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter @Setter
@ToString
public class AccountingEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemCode;
    private String type;
    private String description;
    private Date transactionDate;
    private double value;
    private double profit;
    private boolean active;
	public AccountingEntity(int i, String string, String string2, Date date, double d, double e, boolean b) {
		// TODO Auto-generated constructor stub
	}
	public AccountingEntity(Object itemCode2, Object type2, Object description2, Object transactionDate2, double value2,
			Object profit2, Object active2) {
		// TODO Auto-generated constructor stub
	}
	public Object getItemCode() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
}