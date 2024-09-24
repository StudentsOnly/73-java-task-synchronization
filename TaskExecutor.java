public class TaskExecutor extends Thread {
    TaskSynchronizationExercise exercise;

    public TaskExecutor(TaskSynchronizationExercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            exercise.taskLock.lock();
            if (exercise.terminateExecution){
                return;
            }
            try {
                exercise.taskCount++;
                System.out.println("Executor = task count: " + exercise.taskCount);
            } finally {
                exercise.taskCompleted.signal();
                exercise.taskLock.unlock();
            }
        }
    }
}
