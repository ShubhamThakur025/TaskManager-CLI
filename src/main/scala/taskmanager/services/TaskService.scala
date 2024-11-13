package taskmanager.services

import taskmanager.models.{Done, Pending, Task, User}
import taskmanager.repositories.{TaskRepository, UserRepository}

object TaskService {
  def createNewTask(task: Task, user: User): Unit = TaskRepository.createTask(task, user)
  def setStatusDone(task: Task, user: User): Unit = TaskRepository.setStatus(user, task, Done)
  def setStatusPending(task: Task, user: User): Unit = TaskRepository.setStatus(user, task, Pending)
  def deleteTaskOfUser(user: User, task: Task): Unit = UserRepository.deleteTaskOfUser(user, task)
}
