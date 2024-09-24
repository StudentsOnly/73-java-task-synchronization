import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedTask {

    private int taskCount = 0;
    private final int maxTasks;
    private final Lock lock = new ReentrantLock();
    private final Condition taskCompleted = lock.newCondition();


    public SharedTask(int maxTasks) {
        this.maxTasks = maxTasks;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void incrementTaskCount() {
        taskCount++;
    }

    public int getMaxTasks() {
        return maxTasks;
    }

    public Lock getTaskLock() {
        return lock;
    }

    public Condition getTaskCompleted() {
        return taskCompleted;
    }
}
