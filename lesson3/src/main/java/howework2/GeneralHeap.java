package howework2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GeneralHeap {
    static ReentrantLock lock;
    static Condition condition;

    static volatile int value1 = 10;

    GeneralHeap() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public static void plus(){
        try {
            lock.lock();
            if (value1 % 2 == 0){
                value1++;
                System.out.println(value1);
            } else {
                condition.await();
            }
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void plusPlus (){
        try {
            lock.lock();
            if (value1 % 2 != 0){
                value1++;
                System.out.println(value1);
            } else {
                condition.await();
            }
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
