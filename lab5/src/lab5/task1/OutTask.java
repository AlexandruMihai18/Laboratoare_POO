package lab5.task1;

public class OutTask implements Task {
    public String message;

    public OutTask(String message) {
        this.message = new String(message);
    }

    public void execute() {
        System.out.println(message);
    }
}
