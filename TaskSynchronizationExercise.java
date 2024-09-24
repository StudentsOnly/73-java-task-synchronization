import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskSynchronizationExercise {
    int taskCount;
    ReentrantLock taskLock;
    Condition taskCompleted;
    Boolean terminateExecution;

    public TaskSynchronizationExercise() {
        this.taskCount = 0;
        this.taskLock = new ReentrantLock();
        this.taskCompleted = taskLock.newCondition();
        this.terminateExecution = false;
    }

}



