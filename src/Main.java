class MyTask extends Thread
{
    @Override
    public void run()
    {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Printer 2 executed task "+i);
        }
    }
}

public class Main {

    // main method represents main thread
    public static void main(String[] args) {

        // Job 1
        System.out.println("== Application started ==");

        // Job 2 --> Now Job 2 is executed parallely with Job 3
        MyTask myTask = new MyTask(); // child thread / worker thread
        myTask.start();

        // Job 3
        for (int i = 1; i <= 10; i++) {
            System.out.println("Printer 1 executed task "+i);
        }

        // Job 4
        System.out.println("== Application terminated ==");
    }
}