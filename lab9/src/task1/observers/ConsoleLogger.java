package task1.observers;

import task1.observables.MyObservable;
import task1.observables.SensorData;

public class ConsoleLogger implements MyObserver {
    @Override
    public void update(MyObservable o, Object arg) {
        SensorData new_data = (SensorData) arg;
        System.out.println("New sensor data: " + new_data.toString());
    }
}
