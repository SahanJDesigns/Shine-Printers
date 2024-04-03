class Printer extends Thread {
    PrintJob printJob;
    String name;

    // Constructor
    Printer(String name){
        this.name = name;
    }

    // Method to receive a print job
    public void getPrintJob(PrintJob printJob){
        this.printJob = printJob;
    }

    // Method to print 
    public void printPrinter(){
        printJob.Print();
    }
}
