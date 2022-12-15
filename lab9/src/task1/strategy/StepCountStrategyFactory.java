package task1.strategy;

import task1.observables.DataRepository;
import task1.utils.Utils;

public class StepCountStrategyFactory {
    public static StepCountStrategy createStepCountStrategy(String type, DataRepository repo) {
        switch (type) {
            case Utils.BASIC_STRATEGY:
                return new BasicStepCountStrategy(repo);
            case Utils.FILTERED_STRATEGY:
                return new FilteredStepCountStrategy(repo);
        }
        return null;
    }
}
