package Queues;
import java.util.Queue;
import java.util.LinkedList;

public class StackUsingTwoQueues {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                int size = q1.size();
                for (int i = 0; i < size - 1; i++) {
                    q2.add(q1.remove());
                }
                top = q1.remove();
            } else {
                int size = q2.size();
                for (int i = 0; i < size - 1; i++) {
                    q1.add(q2.remove());
                }
                top = q2.remove();
            }

            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                int size = q1.size();
                for (int i = 0; i < size; i++) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                int size = q2.size();
                for (int i = 0; i < size; i++) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}