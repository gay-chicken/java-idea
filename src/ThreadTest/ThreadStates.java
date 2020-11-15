package ThreadTest;

public class ThreadStates {
    public static void main(String[] args) throws Exception{
        State state = new State();
        Thread thread = new Thread(state, "dog");
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"==>"+Thread.currentThread().getState());
            if (i == 100) {
                thread.join();
            }
        }
    }
}

class State implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            print();
        }
    }

    public void print() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getState());
    }
}
