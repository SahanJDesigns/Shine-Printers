public class Main {
    public static void main(String arg[]){
        SharedQueue sharedQueue = new SharedQueue();


        Thread computer1 = new Computer(){
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
                TextFile file3 = ReadAFile("file_03");
                //creating a print job and sending to print
                try {
                    PrintJob printJob3 = new PrintJob(file3);
                    submitPrintJob(printJob3,sharedQueue);
                } catch (TypeNotSupportedException e) {
                    System.err.println(e.getMessage());
                }
            }
        };

        Thread printer1 = new Printer(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while(!sharedQueue.isEmpty()){
                    getPrintJob(sharedQueue);
                    printPrinter();
                }
            };
        };

        Thread printer2 = new Printer(){
            @Override
            public void run() {
                while(!sharedQueue.isEmpty()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    getPrintJob(sharedQueue);
                    printPrinter();
                }
            };
        };


        computer1.start();
        computer2.start();
        computer3.start();
        printer1.start();
        printer2.start();
    }
}
