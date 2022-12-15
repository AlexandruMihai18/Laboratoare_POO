package task1.observables;

/**
 * Data stored by the observables.DataRepository
 */

public class SensorData {
    private int stepsCount;
    private long timestamp;

    @Override
    public String toString() {
        return String.format("stepsCount=%d, timestamp=%d", stepsCount, timestamp);
    }

    public SensorData(int stepsCount, long timestamp) {
        this.stepsCount = stepsCount;
        this.timestamp = timestamp;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
