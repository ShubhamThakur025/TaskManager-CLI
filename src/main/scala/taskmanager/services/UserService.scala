package taskmanager.services

import taskmanager.models.User
import taskmanager.repositories.UserRepository

import java.util.UUID
import scala.util.{Failure, Success, Try}

object UserService {
  def registerUser(user: User): Unit = UserRepository.createUser(user = user, userId = user.userId)
  def updateUserData(user: User): Unit = UserRepository.updateUser(user = user, userId = user.userId)
  def deleteUserData(user: User): Unit = UserRepository.deleteUser(user.userId)
  def getUserData(userId: UUID): Try[User] = {
    UserRepository.readUser(userId) match
      case Some(user) => Success(user)
      case None => Failure(new NoSuchElementException(s"No user exists with user Id: $userId"))
  }
  def getUserDataByUsername(username: String): Try[User] = {
    UserRepository.findUserByUsername(username) match
      case Some(user) => Success(user)
      case None => Failure(new NoSuchElementException(s"No user exists with username: $username"))
  }
  def addUserToLoginList(user: User): Unit = LoginManager.loginUser(user)
  def removeUserFromLoginList(user: User): Unit = LoginManager.logoutUser(user)
  def isUserLoggedIn(user: User): Boolean = LoginManager.isUserLoggedIn(user)
}
