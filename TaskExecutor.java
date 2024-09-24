public class TaskExecutor extends Thread {

  TaskSynchronizationExercise exercise = new TaskSynchronizationExercise();

  public TaskExecutor(TaskSynchronizationExercise exercise) {
    this.exercise = exercise;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      exercise.increment();
    }
  }
}
