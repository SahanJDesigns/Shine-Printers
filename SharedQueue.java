import java.util.ArrayList;

public class SharedQueue {
    ArrayList<PrintJob> printJobs = new ArrayList<PrintJob>(); // ArrayList to store the PrintJobs
    
    // Method to add a PrintJob to the array
    public synchronized void addJob(PrintJob job) {
        printJobs.add(job);
        notifyAll();
    }

    // Method to return a PrintJob
    public synchronized PrintJob getJob() {
        if (!printJobs.isEmpty()) {
            PrintJob toDO = printJobs.remove(0); // Removing the PrintJob to be carried out from the array
            return toDO;
        }
        System.out.println("No file to print!");
        return null;
    }

    public synchronized boolean isEmpty() {
        return printJobs.isEmpty();
    }
}
