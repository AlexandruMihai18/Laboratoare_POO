package task1.observables;

import java.util.ArrayList;

public class DataRepository extends MyObservable {
    private ArrayList<SensorData> dataList = new ArrayList<>();

    public void addData(SensorData dataRecord) {
        dataList.add(dataRecord);
        notifyObservers(dataRecord);
    }

    public ArrayList<SensorData> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<SensorData> dataList) {
        this.dataList = dataList;
    }
}
