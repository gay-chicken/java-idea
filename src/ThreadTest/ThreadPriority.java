package ThreadTest;

// 线程优先级
public class ThreadPriority {
    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        Thread t = new Thread(thread);
        t.start();
        System.out.println(t.getState());
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        t.interrupt();
        System.out.println(t.getState());
    }
}

class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}