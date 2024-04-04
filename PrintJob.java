public class PrintJob {
    private TextFile file;

    // Constructor
    PrintJob(Object file) throws TypeNotSupportedException {
        if (file instanceof TextFile) {
            this.file = (TextFile) file;
        } else {
            throw new TypeNotSupportedException();
        }
    }

    // Method to carry out a print job
    public synchronized void Print(){
        System.out.println(file.getContent());
    }   
}
