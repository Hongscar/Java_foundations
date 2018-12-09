package datastructure.package_list;

import someObj.Heap;

public class MyPriorityQueue<E extends Comparable<E>> {
    private Heap<E> heap = new Heap<>();

    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }

    static class Patient implements Comparable<Patient> {
        private String name;
        private int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Patient o) {
            return this.priority - o.priority;
        }

        @Override
        public String toString() {
            return name + "(priority: " + priority + ")";
        }
    }

    public static void main(String[] a) {
        Patient p1 = new Patient("John", 2);
        Patient p2 = new Patient("Jim", 1);
        Patient p3 = new Patient("Tim" , 5);
        Patient p4 = new Patient("Cindy" , 7);

        MyPriorityQueue<Patient> patientMyPriorityQueue = new MyPriorityQueue<>();
        patientMyPriorityQueue.enqueue(p1);
        patientMyPriorityQueue.enqueue(p2);
        patientMyPriorityQueue.enqueue(p3);
        patientMyPriorityQueue.enqueue(p4);

        while (patientMyPriorityQueue.getSize() > 0)
            System.out.println(patientMyPriorityQueue.dequeue());
    }
}
