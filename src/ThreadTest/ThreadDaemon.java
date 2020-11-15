package ThreadTest;

public class ThreadDaemon {

    public static void main(String[] args) {
        God god = new God();
        Die die = new Die();
        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认为false，表示用户线程
        thread.start();
        new Thread(die).start();
    }
}

class God implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello world!");
        }
        System.out.println("you were killed by god!");
    }
}

class Die implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("you're die!");
        }
    }
}
