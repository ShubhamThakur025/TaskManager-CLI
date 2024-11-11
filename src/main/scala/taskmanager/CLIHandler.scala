package taskmanager

import taskmanager.controllers.UserController

import scala.io.StdIn.readLine

object CLIHandler {
  private def inputUsername(toppings: String): String = {
    println(s"Enter username: $toppings")
    readLine()
  }
  private def inputPassword(toppings: String): String = {
    println(s"Enter password: $toppings")
    readLine()
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
}
