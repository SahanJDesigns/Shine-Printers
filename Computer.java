class Computer extends Thread{
    PrintJob createPrintJob(Object file){
        return new PrintJob(file);
    }
}