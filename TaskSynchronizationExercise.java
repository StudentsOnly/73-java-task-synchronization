public class TaskSynchronizationExercise {

    public static void main(String[] args) {

        int maxTasks = 10;

        SharedTask sharedTask = new SharedTask(maxTasks);

        // Create TaskExecutor and TaskMonitor threads with maxTasks
        TaskExecutor taskExecutor = new TaskExecutor(sharedTask);
        TaskMonitor taskMonitor = new TaskMonitor(sharedTask);

        taskMonitor.start();
        taskExecutor.start();
    }
}

