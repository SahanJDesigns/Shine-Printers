class Printer implements Runnable {
    private Queue<PrintJob> sharedQueue;

    public Printer(BlockingQueue<PrintJob> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                PrintJob printJob = sharedQueue.take();
                // Process print job
                System.out.println("Printing: " + printJob.getContent());
                Thread.sleep(1000); // Simulate printing time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}