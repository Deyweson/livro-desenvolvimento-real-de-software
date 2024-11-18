import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String Resources = "../src/resources/";

    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(Resources + args[0]);

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFromCSV(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transaction in January " + bankStatementProcessor.calculateTotalMonth(Month.JANUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.totalCalculateForCategory("Salary"));
    }


}
