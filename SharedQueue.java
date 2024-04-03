import java.util.ArrayList;

public class SharedQueue {
    ArrayList<PrintJob> printJobs = new ArrayList<PrintJob>();
    
    public synchronized void addJob(PrintJob job) {
        printJobs.add(job);
    }

    public synchronized void getJob() {
        if (!printJobs.isEmpty()) {
            printJobs.remove(0);
        }
    }
}
