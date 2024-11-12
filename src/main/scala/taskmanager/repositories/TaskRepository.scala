package taskmanager.repositories

import java.util.UUID
import taskmanager.models.{Done, Pending, Task, User}

object TaskRepository {
  private var loggedTasks: Map[UUID, Task] = Map.empty
  def createTask (task: Task, user: User): Unit = {
    user.addTask(task)
    loggedTasks = loggedTasks + (user.userId -> task)
  }
  def setStatusDone(task: Task): Unit = task.setStatus(Done)
  def setStatusPending(task: Task): Unit = task.setStatus(Pending)
  def readTasksOfUser (user: User): List[Task] = user.taskList
  def deleteTaskOfUser (user: User, task: Task): Unit = user.deleteTask(task.taskId)
}
