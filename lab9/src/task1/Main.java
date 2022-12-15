package task1;

import task1.observables.DataRepository;
import task1.observables.SensorData;
import task1.observers.ConsoleLogger;
import task1.observers.DataAggregator;
import task1.observers.ServerCommunicationController;
import task1.strategy.StepCountStrategy;
import task1.strategy.StepCountStrategyFactory;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DataRepository dataRepository = new DataRepository();

        long baseTimestamp = 10000;

        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch (taskNum) {
            case 1:
                dataRepository.addObserver(new ConsoleLogger());
                dataRepository.addObserver(new ServerCommunicationController());
                break;
            case 2:
                String first_strategy_type = scanner.next();
                String second_strategy_type = scanner.next();

                StepCountStrategy firstStrategy = StepCountStrategyFactory.createStepCountStrategy(first_strategy_type, dataRepository);
                StepCountStrategy secondStrategy = StepCountStrategyFactory.createStepCountStrategy(second_strategy_type, dataRepository);

                dataRepository.addObserver(new DataAggregator(firstStrategy));
                dataRepository.addObserver(new DataAggregator(secondStrategy));
                break;
            default:
                System.out.println(0);
                return;
        }

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        System.out.println();

        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        System.out.println();

        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        System.out.println();

        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        System.out.println();

        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        System.out.println();

        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        System.out.println();

        dataRepository.addData(new SensorData(500, baseTimestamp + 600));
        System.out.println();
    }
}
