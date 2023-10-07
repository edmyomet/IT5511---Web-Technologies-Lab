import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Counter implements Runnable {
    Semaphore semaphore;
    private static int counter = 0;
    private static final int limit = 10;
    private static final int threadPoolSize = 5;

    public Counter(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public static void main(String[] args) {
        Semaphore sharedSemaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(new Counter(sharedSemaphore));
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        while (counter < limit) {
            increaseCounter();
        }
    }

    private void increaseCounter() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " : " + counter);
            counter++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}