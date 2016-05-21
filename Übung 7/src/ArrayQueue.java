public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;

    public ArrayQueue(int length) {
        //noinspection unchecked
        queue = (T[]) new Object[length];
    }

    @Override
    public void enqueue(T element) throws IllegalAccessException {
        boolean found = false;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == null) {
                queue[i] = element;
                found = true;
                break;
            }
        }
        if (!found) throw new IllegalAccessException("Warteschlange ist voll");
    }

    @Override
    public T dequeue() {
        T element = front();
        System.arraycopy(queue, 1, queue, 0, queue.length - 1);
        queue[queue.length - 1] = null;
        return element;
    }

    @Override
    public T front() {
        return queue[0];
    }

    @Override
    public boolean empty() {
        return queue[0] == null;
    }
}
