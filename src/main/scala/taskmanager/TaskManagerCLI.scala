package taskmanager

import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}

object TaskManagerCLI {
  def showMenu(): Unit = {
    val menu =
      """
        |1. Register as a new user.
        |2. Log in to my account.
        |Others: Exit
        |""".stripMargin
    println(s"Press the key to perform the appropriate action. $menu")
  }
  def start(): Unit = {
    println("=================================")
    println("Welcome to our Task Manager tool!")
    println("=================================")
  }
  def main(args: Array[String]): Unit = {
    start()
    breakable{
      while(true){
        showMenu()
        readLine() match {
          case "1" => CLIHandler.registerHandler()
          case "2" => CLIHandler.loginHandler()
          case _ =>
            println("Exiting...")
            break
        }
      }
    }
  }
}
