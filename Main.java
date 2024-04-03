public class Main {
    public static void main(String arg[]){
        SharedQueue sharedQueue = new SharedQueue();


        Thread computer = new Computer(){
            @Override
            public void run() {
                //reading the file
                TextFile file1 = ReadAFile("file_01");
                //creating a print job and sending to print
                try {
                    PrintJob printJob1 = new PrintJob(file1);
                    submitPrintJob(printJob1,sharedQueue);
                } catch (TypeNotSupportedException e) {
                    System.err.println(e.getMessage());
                }
            }
        };

        Thread computer2 = new Computer(){
            @Override
            public void run() {
                //reading the file
                TextFile file2 = ReadAFile("file_02");
                //creating a print job and sending to print
                try {
                    PrintJob printJob2 = new PrintJob(file2);
                    submitPrintJob(printJob2,sharedQueue);
                } catch (TypeNotSupportedException e) {
                    System.err.println(e.getMessage());
                }
            }
        };

        Thread computer3 = new Computer(){
            @Override
            public void run() {
                //reading the file
                TextFile file3 = ReadAFile("file_01");
                //creating a print job and sending to print
                try {
                    PrintJob printJob3 = new PrintJob(file3);
                    submitPrintJob(printJob3,sharedQueue);
                } catch (TypeNotSupportedException e) {
                    System.err.println(e.getMessage());
                }
            }
        };

    }
}