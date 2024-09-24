import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskSynchronizationExercise {

  private int taskCount = 0;
  private Lock taskLock = new ReentrantLock();
  private Condition taskCompleted = taskLock.newCondition();


  public void increment() {
    try {
      Thread.sleep(50); // simulate time the task needs without the resource
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    taskLock.lock();
    try {
      taskCount++;
      System.out.println(Thread.currentThread().getName() + " task count: " + taskCount);
    } finally {
      taskCompleted.signalAll();
      taskLock.unlock();
    }
  }

  public void monitor() {
    taskLock.lock();
    try {
      while (taskCount < 10) {
        try {
          System.out.println(Thread.currentThread().getName() + " await, task count: " + taskCount);
          taskCompleted.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Required number of tasks completed.");
    } finally {
      taskLock.unlock();
    }
  }
}
