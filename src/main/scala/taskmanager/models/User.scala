package taskmanager.models

import java.util.UUID

class User(
            val userId: UUID = UUID.randomUUID(),
            val username: String,
            val password: String,
            val taskList: List[Task] = List.empty
          ) {

  def addTask(task: Task): User = new User(userId, username, password, taskList :+ task)

  def deleteTask(deleteTaskId: UUID): User = {
    val updatedTaskList = taskList.filterNot(_.taskId == deleteTaskId)
    new User(userId, username, password, updatedTaskList)
  }
}