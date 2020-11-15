package ThreadTest;

public class ThreadSynchronization {
    public static void main(String[] args) {
        Account account = new Account(1000, "money");
        Drawing parent = new Drawing(account, 1000, "Kite");
        Drawing friend = new Drawing(account, 2000, "Bile");

        parent.start();
        friend.start();
    }
}

class Account {
    int money;
    String name;
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            System.out.println("not drawing!");
            return;
        }
        try{
            sleep(1000);
        }catch (Exception e) {

        }

        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name+"-->"+account.money);
        System.out.println("have:"+nowMoney);
    }
}