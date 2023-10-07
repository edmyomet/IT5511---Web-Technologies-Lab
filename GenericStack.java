import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GenericStack<T> {
    private List<T> stack;

    public GenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = stack.size() - 1;
        return stack.remove(lastIndex);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = stack.size() - 1;
        return stack.get(lastIndex);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        Scanner sc = new Scanner(System.in);
        stack.push(sc.nextInt());
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }
}
