class MyTask
{
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

        // Job 2 --> If job2 is a heavy/time consuming task then it may cause app to appear
        // as it has hung
        MyTask myTask = new MyTask();
        myTask.run();

        // Job 3
        for (int i = 1; i <= 10; i++) {
            System.out.println("Printer 1 executed task "+i);
        }

        // Job 4
        System.out.println("== Application terminated ==");
    }
}