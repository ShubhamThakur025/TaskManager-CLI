package taskmanager.services

import taskmanager.models.User

import java.util.UUID

object LoginManager {
  private var loggedInUsers: Set[UUID] = Set.empty
  def loginUser(user: User): Unit = loggedInUsers = loggedInUsers + user.userId
  def logoutUser(user: User): Unit = loggedInUsers = loggedInUsers - user.userId
  def getLoginUsersData: Set[UUID] = loggedInUsers
  def isUserLoggedIn(user: User): Boolean = loggedInUsers.contains(user.userId)
}
