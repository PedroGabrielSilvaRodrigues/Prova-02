package DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AccountingDTO1 {
    private String itemCode;
    private String type;
    private String description;
    private Date transactionDate;
    private double value;
    private double profit;
    private boolean active;
}