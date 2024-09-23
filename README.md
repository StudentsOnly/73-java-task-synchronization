## Exercise: Task Synchronization

#### Objective: 
The objective of this exercise is to practice using reentrant locks and Condition objects to coordinate the execution of multiple threads that need to perform tasks concurrently.

#### Instructions:

1.	Create a Java class named TaskSynchronizationExercise.
2.	Inside the class, define a shared task count variable named taskCount and initialize it to 0.
3.	Create a ReentrantLock instance named taskLock to protect access to the taskCount variable.
4.	Create a Condition instance named taskCompleted associated with the taskLock. This condition will signal when tasks are completed.
5.	Implement two classes that extend the Thread class: TaskExecutor and TaskMonitor. These threads will perform tasks and monitor the task execution, respectively.
6.	In the TaskExecutor class, simulate the execution of tasks by incrementing the taskCount by 1. Use the ReentrantLock to synchronize access to the taskCount and signal when a task is completed using the taskCompleted condition.
7.	In the TaskMonitor class, periodically monitor the taskCount and wait until a certain number of tasks (e.g., 10) have been completed.
8.	Print a message when the required number of tasks is completed.
