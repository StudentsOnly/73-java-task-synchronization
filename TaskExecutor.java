public class TaskExecutor extends Thread {

    private final SharedTask sharedTask;

    public TaskExecutor(SharedTask sharedTask) {
        this.sharedTask = sharedTask;
    }

    @Override
    public void run() {
        for (int i = 0; i < sharedTask.getMaxTasks(); i++) {
            sharedTask.getTaskLock().lock();
            try {
                sharedTask.incrementTaskCount();
                System.out.println("TaskExecutor: Task " + sharedTask.getTaskCount() + " completed.");

                sharedTask.getTaskCompleted().signal();
            } finally {
                sharedTask.getTaskLock().unlock();
            }

            try {
                Thread.sleep(500); // 500 milliseconds delay between tasks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
