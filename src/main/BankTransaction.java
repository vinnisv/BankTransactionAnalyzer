package main;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankTransaction {
	private final LocalDate date;
	private final double amount;
	private final String description; 
	
	public BankTransaction(final LocalDate date, final double amount, final String description) {
		this.date = date;
		this.amount = amount;
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
		}
	public double getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
			return "BankTransaction{" +
					"date=" + date +
					", amount=" + amount +
					", description='" + description + '\'' +
					'}';
		}
	@Override 
	public boolean equals(Object o) {
		if (this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		BankTransaction that = (BankTransaction) o;
		return Double.compare(that.amount, amount) == 0 &&
				date.equals(that.date) &&
				description.equals(that.description);
	}
	//@Override
	public int hasCode() {
		return Objects.hash(date, amount, description);
	}
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		for(final BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month){
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction: bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		return bankTransactionsInMonth;	
}
	
}
