import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Task task = new Task("App flow tests?", "Pesho", tomorrow);
        Issue issue = new Issue("Review tests", "Someone must review Pesho's tests.", tomorrow);

        Board board = new Board();

        board.addItem(task);
        board.addItem(issue);
        task.advanceStatus();
        issue.advanceStatus();

        board.displayHistory();
    }
}