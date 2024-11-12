package taskmanager

import taskmanager.controllers.{TaskController, UserController}
import taskmanager.models.Task
import taskmanager.services.UserService
import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}

object CLIHandler {
  private def inputUsername(toppings: String): String = {
    println(s"Enter username: $toppings")
    readLine()
  }
  private def inputPassword(toppings: String): String = {
    println(s"Enter password: $toppings")
    readLine()
  }
  private def enterTask(): String = {
    println("Explain your task")
    readLine()
  }
  private def enterTaskNumber(): Int = {
    println("Enter the number of the task")
    readLine().toInt
  }
  def registerHandler(): Unit = {
    println("=============================")
    println("Registration")
    println("=============================")
    println("Enter the data as per instructions:")
    val username = inputUsername("Make it unique.")
    if UserController.checkIfUsernameExists(username) then
      println("Username already exists. Try again.")
    else
      println("Lucky. We don't have someone of that name!")
      val password = inputPassword("Make it hard to guess!")
      UserController.registerUser(username, password)
  }

  def loginHandler(): Unit = {
    println("Enter the data as per instructions:")
    val username = inputUsername("Come on! Try to remember.")
    if UserController.checkIfUsernameExists(username) then
      val password = inputPassword("Last step. Try to remember...🤔")
      println("Logging you in..............")
      UserController.loginUser(username, password)
    else
      println("You're not on our list. Register!")
  }

  def showAllTasksOfUser(): List[Task] = {
    println("Fetching your tasks....")
    val loggedInUserData = UserService.getLoggedInUsers.head
    val userTasks = TaskController.getAllTasksOfUser(loggedInUserData)
    var count = 0
    if(userTasks.nonEmpty){
      userTasks.foreach(task => println(s"{$count}: task.task"))
      count += 1
    }
    userTasks
  }

  def createNewTaskForUser(): Unit = {
    println("Enter the data as per instructions:")
    val newTask: String = enterTask()
    val loggedInUserData = UserService.getLoggedInUsers.head
    TaskController.createNewTask(newTask, loggedInUserData)
  }

  def markTaskDone(): Unit = {
    val loggedInUserData = UserService.getLoggedInUsers.head
    val userTasks = showAllTasksOfUser()
    val index = enterTaskNumber()
    var init = 1
    breakable{
      for (task <- userTasks) {
        if init == index then
          TaskController.markTaskDone(task, loggedInUserData)
          break
        init += 1
      }
    }
  }

  def markTaskPending(): Unit = {
    val loggedInUserData = UserService.getLoggedInUsers.head
    val userTasks = showAllTasksOfUser()
    val index = enterTaskNumber()
    var init = 1
    breakable {
      for (task <- userTasks) {
        if init == index then
          TaskController.markTestPending(task, loggedInUserData)
          break
        init += 1
      }
    }
  }
  def deleteTask(): Unit = {
    val loggedInUserData = UserService.getLoggedInUsers.head
    val userTasks = showAllTasksOfUser()
    val index = enterTaskNumber()
    var init = 1
    breakable {
      for (task <- userTasks) {
        if init == index then
          TaskController.deleteTask(task, loggedInUserData)
          break
        init += 1
      }
    }
  }
  
  def logoutHandler(): Unit = {
    println("Logging out:")
    val loggedInUserData = UserService.getLoggedInUsers.head
    val username = loggedInUserData.username
    UserController.logoutUser(username)
  }
  
}
