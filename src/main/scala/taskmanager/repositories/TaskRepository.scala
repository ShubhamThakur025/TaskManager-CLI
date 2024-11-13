package taskmanager.repositories

import java.util.UUID
import taskmanager.models.{Done, Pending, Task, TaskStatus, User}

object TaskRepository {
  private var loggedTasks: Map[UUID, Task] = Map.empty
  def createTask (task: Task, user: User): Unit = {
    val updatedUser = user.addTask(task)
    UserRepository.updateUser(updatedUser)
    loggedTasks = loggedTasks + (user.userId -> task)
  }
  def setStatus(user: User, task: Task, status: TaskStatus): Unit = {
    val updatedUser = UserRepository.deleteTaskOfUser(user, task)
    val updatedTask = new Task(
      taskId = task.taskId,
      task = task.task,
      taskStatus = status,
      userId = user.userId
    )
    createTask(updatedTask, updatedUser)
  }
}
