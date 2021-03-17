import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Multithreading {
    private static long results = 0;

    public int[] listMaker() {
        int[] myList = new int[100_000_000];
        for (int i = 0; i < myList.length; i++) {
            Random random = new Random();
            myList[i] = random.nextInt(99) + 1;
        }
        return myList;
    }

    static class myRunnable implements Runnable {
        private int[] myList;
        private int threadNumber = 1;
        private int totalThreads = 1;
        private long result = 0;

        public int getTotalThreads() {
            return totalThreads;
        }

        public myRunnable(int[] list, int ThreadNumber, int TotalThreads) {
            this.threadNumber = ThreadNumber;
            this.totalThreads = TotalThreads;
            this.myList = list;
        }

        @Override
        public void run() {
            int start = ((myList.length / totalThreads) * (threadNumber -1));
            int end = ((myList.length / totalThreads) * threadNumber) -1;
            if(totalThreads == threadNumber){end = myList.length;}
            for (int i = start; i < end; i++) {
                results += i;
            }
        }


    }

    public static long listSum(int[] list, int threads) {
        //code here

        Thread[] tArray = new Thread[threads];
        for (int i = 0; i < tArray.length; i++) {
            Runnable target;
            tArray[i] = new Thread(new myRunnable(list,i + 1, threads));
        }
        for (Thread thread : tArray) {
            thread.start();
        }
        return results;
    }


}
