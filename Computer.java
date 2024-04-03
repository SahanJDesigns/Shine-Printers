import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Computer extends Thread {
    public static TextFile ReadAFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder(); // Object to append the content of the file

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return new TextFile(contentBuilder.toString());
    }

    // Method to create a print job
    PrintJob createPrintJob(TextFile textFile) {
        return new PrintJob(textFile);
    }

    // Method to submit a print job
    public PrintJob submitPrintJob(PrintJob printJob) throws InterruptedException {
        System.out.println("Print job submitted: " + printJob.getContent());
        return printJob;
    }

    // Submitting print jobs to the shared queue
    for (PrintJob printJob : printJobs) {
        try{
            submitPrintJob(printJob);
            Thread.sleep(1000); // Sleep for 1 second between print jobs
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }  
}

