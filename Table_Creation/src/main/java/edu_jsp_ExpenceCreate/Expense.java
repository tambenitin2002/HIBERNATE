package edu_jsp_ExpenceCreate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Expense {

    @Id
    private int expenseId;
    private String category;
    private String description;
    private double amount;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", category=" + category + ", description=" + description
				+ ", amount=" + amount + "]";
	}

    
}
