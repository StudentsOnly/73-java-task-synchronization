public class Main {

  public static void main(String[] args) {

    TaskSynchronizationExercise ex = new TaskSynchronizationExercise();

    Thread executor = new TaskExecutor(ex);
    Thread monitor = new TaskMonitor(ex);

    executor.start();
    monitor.start();

    try {
      executor.join();
      monitor.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
