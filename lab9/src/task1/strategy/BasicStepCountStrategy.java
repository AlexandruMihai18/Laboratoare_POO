package task1.strategy;

import task1.observables.DataRepository;

public class BasicStepCountStrategy implements StepCountStrategy {
    private int totalSteps;
    private String strategyDescription;
    private DataRepository repo;

    public BasicStepCountStrategy(DataRepository repo) {
        strategyDescription = "Basic strategy";
        this.repo = repo;
    }

    @Override
    public int getTotalSteps() {
        addSteps();
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        return strategyDescription;
    }

    @Override
    public void addSteps() {
        totalSteps = 0;
        repo.getDataList().forEach(sensorData -> totalSteps += sensorData.getStepsCount());
    }
}
