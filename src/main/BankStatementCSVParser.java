package main;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final String RESOURCES = "src/main/resources/";
	
	private BankTransaction parseFromCSV(final String line) {
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);			
	}
	/* REFATORAÇÃO FEITA NO PAG 13
	public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
		final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
		
		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
		
		System.out.println("O total de todas transações é " + calculateTotalAmount(bankTransactions));
		System.out.println("Transação de Janeiro " + selectInMonth(BankTransaction, Month.JANUARY));
		}
	*/
	
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		for(final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month){
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(final BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		return bankTransactionsInMonth;	
}
	
	public class BankTransactionParser{
		public BankTransaction parseFromCSV(final String line) {
			//...
			throw new UnsupportedOperationException();
		}
		public BankTransaction parseFromJSON(final String line) {
			//...
			throw new UnsupportedOperationException();
		}
		public BankTransaction parseFromXML(final String line) {
			//...
			throw new UnsupportedOperationException();
		}
	}
}

