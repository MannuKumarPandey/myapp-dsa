package queue;

class CircularQueue {


    int[] arr;
    int front;
    int rear;
    int k;
    int length = 0;
    public CircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        this.k = k;
    }

    public static void main(String[] args) {
        CircularQueue a = new CircularQueue(3);// size hi 3 hai
        System.out.println(a.enQueue(1));
        System.out.println(a.enQueue(2));
        System.out.println(a.enQueue(3));
        System.out.println(a.enQueue(4));
        System.out.println(a.rear);
        System.out.println(a.isFull());
        System.out.println(a.deQueue());
        System.out.println(a.enQueue(4));
        System.out.println(a.rear);

    }

    public boolean enQueue(int value) {
        if (!isFull() && k != 0) {
            arr[(front + 1) % k] = value;
            front++;
            length++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (!isEmpty() && k != 0) {
            arr[(rear + 1) % k] = 0;
            rear++;
            length--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (!isEmpty()) {
            return arr[rear + 1];
        }
        return -1;
    }

    public int Rear() {
        if (!isEmpty()) {
            return arr[front % k];
        }
        return -1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        if (k != 0) {
            return length == k;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

