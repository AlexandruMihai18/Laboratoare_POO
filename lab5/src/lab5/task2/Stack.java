package lab5.task2;

import java.util.ArrayList;

import lab5.task1.Task;

public class Stack implements Container{
    ArrayList<Task> list = new ArrayList<Task>();

    public Task pop() {
        if (list.size() == 0)
            return null;

        Task removed = list.remove(list.size() - 1);
        return removed;
    }

    public void push(Task task) {
        list.add(task);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        if (list.size() == 0)
            return true;
        return false;
    }

    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            this.push(container.pop());
        }
    }

    public ArrayList<Task> getTasks() {
        return list;
    }
}
