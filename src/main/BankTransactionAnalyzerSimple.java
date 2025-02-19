package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

 public class BankTransactionAnalyzerSimple {
	private static final String RESOURCES = "src/main/resources/";
	
	public static void main(final String... args) throws IOException {
		
		final Path path = Paths.get(RESOURCES + args[0]);
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;
		final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for(final String line: lines) {
			final String[] columns = line.split(",");
			final LocalDate date = LocalDate.parse(columns[0], DATA_PATTERN);
			if(date.getMonth() == Month.JANUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total += amount;			
			}
		}
		System.out.println("o total de todas as transações em janeiro é " + total);
	}

} 

