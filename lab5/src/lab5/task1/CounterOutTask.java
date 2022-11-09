package lab5.task1;

public class CounterOutTask implements Task {
    static int global = 0;

    public void execute() {
        global++;
        System.out.println(global);
    }
}
