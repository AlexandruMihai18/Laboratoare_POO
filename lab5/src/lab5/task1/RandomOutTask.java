package lab5.task1;

import java.util.Random;

public class RandomOutTask implements Task {
    private static Random rnd = new Random(12345);
    public int random;

    public RandomOutTask() {
        random = rnd.nextInt();
    }

    public void execute() {
        System.out.println(random);
    }
}
