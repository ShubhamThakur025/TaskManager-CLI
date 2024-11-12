package taskmanager.controllers

import taskmanager.models.{ Pending, Task, User}
import taskmanager.services.TaskService

object TaskController {
  def createNewTask(task: String, user: User): Unit = {
    val newTask: Task = new Task(task = task, taskStatus = Pending, userId = user.userId)
    TaskService.createNewTask(newTask, user)
    println("Task successfully created.")
  }
  def deleteTask(task: Task, user: User): Unit = {
    TaskService.deleteTaskOfUser(user, task)
    println("Task successfully deleted.")
  }
  def markTaskDone(task: Task, user: User): Unit = {
    TaskService.setStatusDone(task)
    println("Task completed! 🥳")
  }
  def markTestPending(task: Task, user: User): Unit = {
    TaskService.setStatusPending(task)
    println("Task marked Pending...")
  }
  def getAllTasksOfUser(user: User): List[Task] = TaskService.readTasksOfUser(user)
}
