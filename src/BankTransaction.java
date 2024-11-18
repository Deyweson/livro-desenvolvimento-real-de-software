import java.time.LocalDate;

public class BankTransaction {
    public LocalDate Date;
    public Double amount;
    public String Description;

    public BankTransaction(LocalDate date, Double  amount, String description) {
        this.Date = date;
        this.amount = amount;
        this.Description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return Date;
    }

    public String getDescription() {
        return Description;
    }
}
