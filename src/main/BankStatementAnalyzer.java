package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
	private static final String RESOURCES = "src/main/resources/";
	
	  private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
	
	public static void main(final String... args) throws IOException {
		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
	}	
	
	public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		collectSummary(bankStatementProcessor);
	}
	
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		System.out.println("O total de total as transações é " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("O total de transações em Janeiro é de " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("O total de transações em Fevereiro é de " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("O salário recebido é de " + bankStatementProcessor.calculateTotalForCategory("Salary"));
	}
}
