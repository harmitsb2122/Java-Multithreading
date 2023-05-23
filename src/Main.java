class Printer{
    void print(int numOfCopies ,String name)
    {
        for (int i = 1; i <= numOfCopies; i++) {
            System.out.println("Printing "+i+"th copy of "+name);
        }
    }
}
class MyThread1 implements Runnable
{
    Printer printer;

    MyThread1(Printer printer)
    {
        this.printer = printer;
    }
    @Override
    public void run()
    {
        printer.print(10,"X");
    }
}

class MyThread2 implements Runnable
{
    Printer printer;

    MyThread2(Printer printer)
    {
        this.printer = printer;
    }
    @Override
    public void run()
    {
        printer.print(10,"Y");
    }
}

public class Main {

    // main method represents main thread
    public static void main(String[] args) {

        // Job 1
        System.out.println("== Application started ==");

        // Lets have a common printer for now
        Printer printer = new Printer();

        // Threads executing async
        Thread t1 = new Thread(new MyThread1(printer));
        Thread t2 = new Thread(new MyThread2(printer));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        // Job 4
        System.out.println("== Application terminated ==");
    }
}