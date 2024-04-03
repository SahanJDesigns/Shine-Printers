class Printer extends Thread {
    PrintJob printJob;
    String name;
    // Method to receive a print job
    public void getPrintJob(PrintJob printJob){
        this.printJob = printJob;
    }

    // Method to print a PrintJob
    public void printPrinter(){
        printJob.Print();
    }
}
