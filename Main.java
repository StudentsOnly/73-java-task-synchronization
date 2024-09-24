
public class Main {
    public static void main(String[] args) {
        TaskSynchronizationExercise exercise = new TaskSynchronizationExercise();

        TaskExecutor executor = new TaskExecutor(exercise);
        TaskMonitor monitor = new TaskMonitor(exercise);

        monitor.start();
        executor.start();

        try {
            executor.join();
            monitor.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End");

    }
}