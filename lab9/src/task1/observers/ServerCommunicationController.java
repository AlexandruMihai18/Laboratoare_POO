package task1.observers;

import task1.observables.MyObservable;
import task1.observables.SensorData;
import task1.utils.Utils;

public class ServerCommunicationController implements MyObserver {
    @Override
    public void update(MyObservable o, Object arg) {
        SensorData new_data = (SensorData) arg;
        ServerMessage new_server_message = new ServerMessage(new_data.getStepsCount(), Utils.getClientId(), new_data.getTimestamp());
        System.out.println("Generated server message: " + new_server_message.toString());
    }
}
