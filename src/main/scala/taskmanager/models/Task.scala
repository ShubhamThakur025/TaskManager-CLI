package taskmanager.models

import java.util.UUID

sealed trait TaskStatus
case object Done extends TaskStatus
case object Pending extends TaskStatus

class Task (
           val UUID: UUID = UUID.randomUUID(),
           val task: String,
           val taskStatus: TaskStatus,
           val userId: UUID,
           val isLogin: Boolean
           )