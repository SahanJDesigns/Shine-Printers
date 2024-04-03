public class PrintJob {
    private TextFile file;

    public PrintJob(Object file) throws TypeNotSupportedException {
        if (file instanceof TextFile) {
            this.file = (TextFile) file;
        } else {
            throw new TypeNotSupportedException();
        }
    }

    public synchronized void Print(){
        System.out.println(file.getContent());
    }
    
}
