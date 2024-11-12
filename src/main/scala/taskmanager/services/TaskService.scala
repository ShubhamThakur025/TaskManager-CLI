package taskmanager.services

import taskmanager.models.{Task, User}
import taskmanager.repositories.TaskRepository

object TaskService {
  def createNewTask(task: Task, user: User): Unit = TaskRepository.createTask(task, user)
  def readTasksOfUser(user: User): List[Task] = TaskRepository.readTasksOfUser(user)
  def setStatusDone(task: Task): Unit = TaskRepository.setStatusDone(task)
  def setStatusPending(task: Task): Unit = TaskRepository.setStatusPending(task)
  def deleteTaskOfUser(user: User, task: Task): Unit = user.deleteTask(task.taskId)
}
