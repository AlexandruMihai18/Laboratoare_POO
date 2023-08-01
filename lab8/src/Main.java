import java.util.*;

public class Main {
    public static void main(String[] args) {

        final int NO_RANDOM = 4;
        /* Do not modify */
        Student s1 = new Student("Maria", "Popescu", 3, 8.5);
        Student s2 = new Student("Ion", "Grigorescu", 2, 8);
        Student s3 = new Student("Ana", "Enescu", 7, 7);
        Student s4 = new Student("Mihai", "Eminovici", 1, 4.45);
        Student s5 = new Student("Andrei", "Radu", 12, 2);

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4, s5));
        List<Student> copyStudents = new ArrayList<>(students);

        List<Integer> numbers = List.of(10, 20, 5, 243, 5556, 312, 566, 245, 122, 5556, 5, 10, 20, 122);
        ArrayList<String> subjects = new ArrayList<>(List.of("PP", "PA", "PCOM", "IOCLA", "AA",
                "SO", "CPL", "EP", "RL", "LFA"));
        Random random = new Random(12);
        /* End of unmodifiable zone */

        /* ------------------------- Task 2 ------------------------- */
        /* --------- Sort using Comparable<Student> interface ------- */
        Collections.sort(students);
        System.out.println(students);

        /* ------------------------- Task 3 ------------------------- */
        /* -------------- Sort using a lambda expression ------------ */

        copyStudents.sort((o2, o1) -> {
            if (o1.getAverageGrade() == o2.getAverageGrade()) {
                if (o1.getSurname().equals(o2.getSurname())) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getSurname().compareTo(o2.getSurname());
            } else {
                if (o1.getAverageGrade() > o2.getAverageGrade()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        System.out.println(copyStudents);

        /* ------------------------- Task 4 ------------------------- */
        /* ----------- Implement your priority queue here ----------- */
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getId() > o2.getId()) {
                return 1;
            } else {
                return -1;
            }
        });

        priorityQueue.addAll(students);
        System.out.println(priorityQueue);

        /* ------------------------- Task 6 ------------------------- */
        Map<Student, LinkedList<String>> studentMap = new HashMap<>();
        students.forEach(s -> studentMap.putIfAbsent(s, new LinkedList<>()));

        /*--------- Add 4 random elements in each LinkedList ----------*/
        /* Use the previously declared random object and use subjects.size() as your bound */
        for (Map.Entry<Student, LinkedList<String>> entry : studentMap.entrySet()) {
            for (int i = 0; i < NO_RANDOM; i++) {
                entry.getValue().addFirst(subjects.get(random.nextInt(subjects.size())));
            }
        }
        System.out.println(studentMap);

        /* ------------------------- Task 7 ------------------------- */
        /* -------------  No need to add or modify here --------------*/
        LinkedEvenSet linked = new LinkedEvenSet();
        linked.addAll(numbers);

        EvenSet set = new EvenSet();
        set.addAll(numbers);

        TreeEvenSet tree = new TreeEvenSet();
        tree.addAll(numbers);

        System.out.println(linked);
        System.out.println(set);
        System.out.println(tree);
    }
}