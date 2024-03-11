public class queue {

    static class que {

        int que[] = new int[10];

        public static void add(int val) {

            if (rear == que.length - 1) {
                System.out.println("queue is empty");
            } else {
                rear = (rear + 1) % 10;
                que[rear] = val;
            }

        }

        public static void remove() {

            if (rear == que.length - 1) {
                System.out.println("queue is empty");
            } else {

                System.out.println(que[front]);
                front++;
            }
        }

        public static boolean is_emp() {
            return rear == -1 ;
        }

    }

    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {

        que Q = new que();
        Q.add(4);

    }
}
