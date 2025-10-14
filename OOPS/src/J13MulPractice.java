class Counter {
    int count = 0;
    public void increment() {
        synchronized (this) { // synchronized block
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }
}

class MyThreadt extends Thread {
    Counter counter;
    MyThreadt(Counter counter) { this.counter = counter; }
    public void run() { counter.increment(); }
}

public class J13MulPractice {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        MyThreadt t1 = new MyThreadt(counter);
        MyThreadt t2 = new MyThreadt(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.count);
    }
}
