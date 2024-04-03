class Printer extends Thread {
    PrintJob printJob;
    String name;

    // Method to receive a print job
    public synchronized void getPrintJob(SharedQueue sharedQueue){
        this.printJob = sharedQueue.getJob();
    }

    // Method to print a PrintJob
    public void printPrinter(){
        printJob.Print();
    }
}
