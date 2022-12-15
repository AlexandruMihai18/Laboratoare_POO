package task1.observers;

import task1.observables.MyObservable;
import task1.observables.SensorData;
import task1.strategy.StepCountStrategy;

public class DataAggregator implements MyObserver {
    StepCountStrategy strategy;

    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(MyObservable o, Object arg) {
        SensorData new_data = (SensorData) arg;
        System.out.println(strategy.getStrategyDescription() + ", total step count: : " + strategy.getTotalSteps());
    }
}
