package taskmanager.repositories

import taskmanager.models.User
import java.util.UUID

object UserRepository {
  private var registeredUsers: Map[UUID, User] = Map.empty
    def createUser (user: User, userId: UUID): Unit = registeredUsers = registeredUsers + (userId -> user)
    def readUser (userId: UUID): Option[User] = registeredUsers.get(userId)
    def findUserByUsername(username: String): Option[User] = registeredUsers.values.find(_.username == username)
    def updateUser(user: User, userId: UUID): Unit = registeredUsers = registeredUsers + (userId -> user)
    def deleteUser (userId: UUID): Unit = registeredUsers = registeredUsers - userId
}
