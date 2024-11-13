package taskmanager.repositories

import taskmanager.models.{Task, User}

import java.util.UUID

object UserRepository {
  private var registeredUsers: Map[UUID, User] = Map.empty

  def createUser(user: User): Unit = {
    registeredUsers += (user.userId -> user)
  }
  def readUser(userId: UUID): Option[User] = registeredUsers.get(userId)
  def findUserByUsername(username: String): Option[User] = registeredUsers.values.find(_.username == username)
  def updateUser(user: User): Unit = {
    registeredUsers += (user.userId -> user)
  }
  def deleteUser(userId: UUID): Unit = {
    registeredUsers -= userId
  }
  def readTasksOfUser (user: User): List[Task] = user.taskList
  def deleteTaskOfUser (user: User, task: Task): User = {    
    val updatedUser = user.deleteTask(task.taskId)
    UserRepository.updateUser(updatedUser)
    updatedUser
  }
}
