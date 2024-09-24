public class TaskMonitor extends Thread {
    TaskSynchronizationExercise exercise;

    public TaskMonitor(TaskSynchronizationExercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public void run() {
        exercise.taskLock.lock();
        try {
            while (exercise.taskCount < 10) {
                try {
                    System.out.println("Waiting, task count: " + exercise.taskCount);
                    exercise.taskCompleted.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("10 tasks completed");
            exercise.terminateExecution = true;
            Thread.currentThread().interrupt();
        } finally {
            exercise.taskLock.unlock();
        }
    }
}
