package task1.observables;

import task1.observers.MyObserver;
import java.util.ArrayList;

public class MyObservable {
    ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void addObserver(MyObserver o) {
        observers.add(0, o);
    }

    public void notifyObservers(Object arg) {
        observers.forEach(observers -> observers.update(this, arg));
    }

}
