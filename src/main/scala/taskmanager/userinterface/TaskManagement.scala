package taskmanager.userinterface

import taskmanager.CLIHandler
import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}

object TaskManagement {
  private def showMenu(): Unit = {
    val menu =
      """
        |1. Create a new task.
        |2. Mark task as done.
        |3. Mark task as pending.
        |4. Delete a task.
        |5. View All Tasks.
        |6. Logout from the application.
        |Others: Invalid Keys. Avoid them.
        |""".stripMargin
    println("========================================================")
    println(s"Press the key to perform the appropriate action. $menu")
    println("========================================================")
  }

  private def start(): Unit = {
    println("=================================")
    println("Welcome to our Task Manager tool family!")
    println("=================================")
    println("Let us see some important instructions:")
  }

  def commenceTaskInterface(): Unit = {
    start()
    breakable{
      while(true){
        showMenu()
        readLine() match {
          case "1" => CLIHandler.createNewTaskForUser()
          case "2" => CLIHandler.markTaskDone()
          case "3" => CLIHandler.markTaskPending()
          case "4" => CLIHandler.deleteTask()
          case "5" => CLIHandler.showAllTasksOfUser()
          case "6" =>
            CLIHandler.logoutHandler()
            break
          case _ => println("Invalid Input.")
        }
      }
    }
  }
}
