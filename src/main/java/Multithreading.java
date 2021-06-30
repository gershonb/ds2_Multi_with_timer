import java.util.*;

public class Multithreading {


    public static List<Integer> mylist = new ArrayList<>();
    public static List<Integer> temp_safe = Collections.synchronizedList(mylist);
    public static long sum = 0;
    public static final Object lock = new Object();

    static class Mythread extends Thread {
        @Override
        public void run() {
            //System.out.println("Thread starts...");
            //System.out.println("temp size " + temp.size());
            long x = 0;
            List<Integer> threadListCopy = temp_safe;
            for (Integer integer : threadListCopy) {
                //System.out.println(x + " + " + integer);
                x += integer;
            }
            synchronized (this) {
                sum += x;
            }
            //System.out.println("Finished..." + sum);
        }
    }


    public static void listMaker(int size) {
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            mylist.add(random.nextInt(99) + 1);
        }
    }

    public static long sumTest() {

        long sum = 0;
        for (Integer integer : mylist) {
            sum += integer;
        }

        return sum;
    }


    public static void main(String[] args) throws InterruptedException {
        //code here
        //System.out.println("Start...");
        //System.out.println("Make list...");
        listMaker(100_000_000);
        int threadAmount = 40;
        Thread[] threadArray = new Mythread[threadAmount];
        int lookAhead = (mylist.size() / threadAmount);
        //System.out.println("LA- " + mylist.size()  + "_" + threadAmount);
        int i = 0;
        int threadsNumber = 0;
        //Fill thread array
        for (int j = 0; j < threadArray.length; j++) {
            threadArray[j] = new Mythread();
        }


        while (i < mylist.size()) {
            threadArray[threadsNumber].start();
            i += lookAhead;
            threadsNumber++;
            //System.out.println(sum);
        }
        Thread.sleep(3 * 1_000);
        sum /= threadAmount;
        System.out.println("Total: " + sum);
        System.out.println("Total check: " + sumTest());
    }
}

