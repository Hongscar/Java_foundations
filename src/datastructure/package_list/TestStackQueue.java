package datastructure.package_list;

public class TestStackQueue {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("Tom");
        stack.push("Susan");
        stack.push("Kim");
        stack.push("Michael");
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println("----");

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Tom");
        queue.enqueue("Susan");
        queue.enqueue("Kim");
        queue.enqueue("Michael");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
