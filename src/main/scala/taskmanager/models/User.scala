package taskmanager.models

import java.util.UUID

class User (
           val userId : UUID = UUID.randomUUID(),
           val username: String,
           val password: String,
           val taskList: List[Task]
           )