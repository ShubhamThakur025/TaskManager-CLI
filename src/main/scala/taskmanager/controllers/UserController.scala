package taskmanager.controllers

import taskmanager.models.User
import taskmanager.services.UserService
import org.mindrot.jbcrypt.BCrypt
import scala.util.{Success, Failure}

object UserController {
  private def encryptPassword(password: String): String = {
    BCrypt.hashpw(password, BCrypt.gensalt())
  }
  private def verifyPassword(hashedPassword: String, password: String): Boolean = {
    BCrypt.checkpw(password, hashedPassword)
  }
  def checkIfUsernameExists(username: String): Boolean = {
    UserService.getUserDataByUsername(username) match
      case Success(user: User) => true
      case Failure(_) => false
  }
  def registerUser(username: String, password: String): Unit = {
    val hashedPassword: String = encryptPassword(password)
    val newUser: User = new User(username = username, password = hashedPassword, taskList = List.empty)
    UserService.registerUser(newUser)
    println("You registered successfully!")
  }
  def loginUser(username: String, password: String): Unit = {
    UserService.getUserDataByUsername(username) match
      case Success(user: User) =>
        if(verifyPassword(user.password, password)){
          UserService.addUserToLoginList(user)
          println("You logged in successfully!")
        } else{
          println("Invalid Credentials.")
        }
      case Failure(exception: Exception) => println(s"An exception occurred while logging in: ${exception.getMessage}")
  }
  def logoutUser(username: String, password: String): Unit = {
    UserService.getUserDataByUsername(username) match
      case Success(user: User) =>
        UserService.removeUserFromLoginList(user)
        println("You logged out successfully!")
      case Failure(exception: Exception) => println(s"An exception occurred while logging out: ${exception.getMessage}")
  }
  def deleteUser(username: String): Unit = {
    UserService.getUserDataByUsername(username) match
      case Success(user: User) =>
        UserService.deleteUserData(user)
        println("You were removed from the system")
      case Failure(exception: Exception) => println(s"An exception occurred while removing: ${exception.getMessage}")

  }
}
