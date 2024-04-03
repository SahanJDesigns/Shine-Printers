public class PrintJob {
    TextFile content
    public synchronized PrintJob(Object file) throws TypeNotSupportedException{
        if(file instanceof TextFile){
            TextFile textFile = (TextFile) file;
            
        } else {
            throw new TypeNotSupportedException();
        }
    }
}
