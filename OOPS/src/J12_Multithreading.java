

// ========================
// JAVA MULTITHREADING COMPLETE EXAMPLE
// ========================

/*
Multithreading in Java allows executing multiple tasks (threads) simultaneously within the same program.
Thread vs Process:
- Process-based multitasking: Independent tasks (OS-level), e.g., typing code + playing music.
- Thread-based multitasking: Tasks within same program (program-level). Each task = Thread.

Ways to create threads:
1. Extending Thread class
2. Implementing Runnable interface
*/

// -----------------------
// 1. Yield Example
// Thread.yield() suggests scheduler to give chance to other threads of same priority
// -----------------------
class YieldThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " --- " + i);
            Thread.yield(); // hint to scheduler
        }
    }
}

// -----------------------
// 2. Thread Class Basics: start(), run(), getName(), setName(), setPriority()
// -----------------------
class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

// -----------------------
// 3. Sleep Example
// Thread.sleep(ms) pauses current thread
// -----------------------
class SleepThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(getName() + " --- " + i);
            try {
                Thread.sleep(1000); // sleep for 1 sec
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

// -----------------------
// 4. Run Override Example
// start() -> new thread, run() -> normal method
// -----------------------
class MyRunThread extends Thread {}

// -----------------------
// 5. Synchronization Example
// synchronized keyword prevents data inconsistency when multiple threads access shared data
// -----------------------
class Addition {
    int sum = 0;

    public void add() {
        synchronized (this) { // synchronized block ensures one thread at a time
            sum = sum + 1;
        }
    }
}

class MyThread3 extends Thread {
    Addition add;

    MyThread3(Addition add) { this.add = add; }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) add.add();
    }
}

class MyThread4 extends Thread {
    Addition add;

    MyThread4(Addition add) { this.add = add; }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) add.add();
    }
}

// -----------------------
// 6. Thread Priority Example
// Thread priorities: MIN=1, NORM=5, MAX=10
// Scheduler may use priority to allocate CPU
// -----------------------
class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority());
    }
}

// -----------------------
// 7. Join Example
// join() -> waits for a thread to complete before continuing main thread
// -----------------------
class JoinThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
            System.out.println("Child thread");
        }
    }
}

// -----------------------
// 8. Runnable Interface Example
// Preferred when we need to extend another class as well
// -----------------------
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable thread is running...");
    }
}

// -----------------------
// 9. Even and Odd Thread Example
// -----------------------
class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) System.out.println("Even: " + i);
    }
}
class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 9; i += 2) System.out.println("Odd: " + i);
    }
}

// -----------------------
// MAIN CLASS TO RUN ALL EXAMPLES
// -----------------------
public class J12_Multithreading {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==== Yield Example ====");
        YieldThread yt1 = new YieldThread();
        YieldThread yt2 = new YieldThread();
        yt1.setName("Yield-1");
        yt2.setName("Yield-2");
        yt1.start();
        yt2.start();
        yt1.join();
        yt2.join();

        System.out.println("\n==== Thread Class Basics ====");
        System.out.println("Main thread name: " + Thread.currentThread().getName());
        Thread.currentThread().setName("Main-Renamed");
        System.out.println("Main thread renamed: " + Thread.currentThread().getName());
        MyThread1 t1 = new MyThread1();
        t1.setName("Child-Thread");
        t1.start();
        t1.join();

        System.out.println("\n==== Sleep Example ====");
        SleepThread st = new SleepThread();
        st.setName("Sleep-Child");
        st.start();
        st.join();

        System.out.println("\n==== Synchronization Example ====");
        Addition addition = new Addition();
        MyThread3 t3 = new MyThread3(addition);
        MyThread4 t4 = new MyThread4(addition);
        t3.start(); t4.start();
        t3.join(); t4.join();
        System.out.println("Final sum after synchronized threads: " + addition.sum);

        System.out.println("\n==== Thread Priority Example ====");
        MyThread2 t2p = new MyThread2(); t2p.setName("Thread-Min"); t2p.setPriority(Thread.MIN_PRIORITY);
        MyThread2 t3p = new MyThread2(); t3p.setName("Thread-Max"); t3p.setPriority(Thread.MAX_PRIORITY);
        t2p.start(); t3p.start();
        t2p.join(); t3p.join();

        System.out.println("\n==== Join Example ====");
        JoinThread jt = new JoinThread();
        jt.start();
        jt.join(); // wait for child to finish
        System.out.println("Main thread resumes after join");

        System.out.println("\n==== Runnable Interface Example ====");
        Thread runnableThread = new Thread(new MyTask());
        runnableThread.start();
        runnableThread.join();

        System.out.println("\n==== Even/Odd Thread Example ====");
        new EvenThread().start();
        new OddThread().start();
    }
}

/*
NOTES / EXPLANATIONS:
1. start() -> starts a new thread and calls run()
2. run() -> contains thread's job
3. getName()/setName() -> get or set thread name
4. setPriority() -> sets thread priority (1-10)
5. yield() -> hints scheduler to switch threads
6. join() -> main thread waits for another thread to finish
7. sleep(ms) -> pauses thread for specified time
8. synchronized -> prevents data inconsistency for shared resources
9. Runnable interface -> preferred way to create threads, allows extending other classes
10. Thread scheduler decides order of execution; output may vary
*/
