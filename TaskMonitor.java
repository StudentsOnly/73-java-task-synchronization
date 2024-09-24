public class TaskMonitor extends Thread {

    private final SharedTask sharedTask;

    public TaskMonitor(SharedTask sharedTask) {
        this.sharedTask = sharedTask;
    }

    @Override
    public void run() {
        sharedTask.getTaskLock().lock();
        try {
            while (sharedTask.getTaskCount() < sharedTask.getMaxTasks()) {

                sharedTask.getTaskCompleted().await(); // Await signal from TaskExecutor
                System.out.println("TaskMonitor: " + sharedTask.getTaskCount() + " tasks completed.");
            }

            System.out.println("TaskMonitor: All " + sharedTask.getMaxTasks() + " tasks are completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sharedTask.getTaskLock().unlock();
        }
    }
}
