public class Main {
    public static void main(String arg[]){
        SharedQueue sharedQueue = new SharedQueue();

        Thread computer1 = new Computer(){
            @Override
            public void run() {
                // Reading the file
                for(int i=0;i<100;i++){
                    TextFile file1 = ReadAFile("Files\\file"+(i+1)+".txt");
                    // Creating a print job and sending it to print
                    try {
                        PrintJob printJob1 = new PrintJob(file1);
                        submitPrintJob(printJob1,sharedQueue);
                    } catch (TypeNotSupportedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        };
 
        Thread computer2 = new Computer(){
            @Override
            public void run() {
            // Reading the file
            for(int i=100;i<200;i++){
                    TextFile file1 = ReadAFile("Files\\file"+(i+1)+".txt");
                    // Creating a print job and sending it to print
                    try {
                        PrintJob printJob1 = new PrintJob(file1);
                        submitPrintJob(printJob1,sharedQueue);
                    } catch (TypeNotSupportedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        };
 

        Thread computer3 = new Computer(){
            @Override
            public void run() {
                // Reading the file
                for(int i=200;i<300;i++){
                    TextFile file1 = ReadAFile("Files\\file"+(i+1)+".txt");
                    // Creating a print job and sending it to print
                    try {
                        PrintJob printJob1 = new PrintJob(file1);
                        submitPrintJob(printJob1,sharedQueue);
                    } catch (TypeNotSupportedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        };

        Thread printer1 = new Printer() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    synchronized (sharedQueue) {
                        if (sharedQueue.isEmpty()){
                            try {
                                sharedQueue.wait(2000);
                                if(sharedQueue.isEmpty()){
                                    System.out.println("No print job notified within 1000ms. Shutting down the Printer 01.");
                                    break;
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else{
                            getPrintJob(sharedQueue);
                            printPrinter();
                        }
                    }
                }
            }
        };

        Thread printer2 = new Printer() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    synchronized (sharedQueue) {
                        if (sharedQueue.isEmpty()){
                            try {
                                sharedQueue.wait(2000);
                                if(sharedQueue.isEmpty()){
                                    System.out.println("No print job notified within 1000ms. Shutting down the Printer 02.");
                                    break;
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else{
                            getPrintJob(sharedQueue);
                            printPrinter();
                        }
                    }
                }
            }
        };
        
        computer1.start();
        computer2.start();
        computer3.start();
        printer1.start();
        printer2.start();
    }
}
