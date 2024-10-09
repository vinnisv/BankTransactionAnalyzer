package main;

import java.util.List;

public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
	
}

/*
public class BankStatementCSVParser implements BankStatementParser{
}
	@Override
	public BankTransaction parseFrom(String line) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		// TODO Auto-generated method stub
		return null;
		*/
