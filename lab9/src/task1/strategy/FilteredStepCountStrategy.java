package task1.strategy;

import task1.observables.DataRepository;
import task1.utils.Utils;

public class FilteredStepCountStrategy implements StepCountStrategy {
    int totalSteps;
    private String strategyDescription;
    private DataRepository repo;

    public FilteredStepCountStrategy(DataRepository repo) {
        strategyDescription = "Filtered strategy";
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
        repo.getDataList().forEach(sensorData -> {
            if (sensorData.getStepsCount() > 0 && sensorData.getStepsCount() < Utils.MAX_STEP_DIFFERENCE) {
                totalSteps += sensorData.getStepsCount();
            }
        });
    }
}
