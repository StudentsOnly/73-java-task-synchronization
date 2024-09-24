public class TaskMonitor extends Thread {

  TaskSynchronizationExercise exercise = new TaskSynchronizationExercise();

  public TaskMonitor(TaskSynchronizationExercise exercise) {
    this.exercise = exercise;
  }

  @Override
  public void run() {
    exercise.monitor();
  }
}
