package task1.observers;

import task1.observables.MyObservable;

public interface MyObserver {
    void update(MyObservable o, Object arg);
}
