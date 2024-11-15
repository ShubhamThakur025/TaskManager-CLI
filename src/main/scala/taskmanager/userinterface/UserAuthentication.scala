package taskmanager.userinterface

import taskmanager.CLIHandler
import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}

object UserAuthentication {
  private def showMenu(): Unit = {
    val menu =
      """
        |1. Register as a new user.
        |2. Log in to my account.
        |Others: Exit
        |""".stripMargin
    println("========================================================")
    println(s"Press the key to perform the appropriate action. $menu")
    println("========================================================")
  }

  private def start(): Unit = {
    println("=================================")
    println("Welcome to our Task Manager tool! 🏢🏢")
    println("=================================")
    val asciiArt = """ _____         _       __  __
                     ||_   _|_ _ ___| | __  |  \/  | __ _ _ __   __ _  __ _  ___ _ __
                     |  | |/ _` / __| |/ /  | |\/| |/ _` | '_ \ / _` |/ _` |/ _ \ '__|
                     |  | | (_| \__ \   <   | |  | | (_| | | | | (_| | (_| |  __/ |
                     |  |_|\__,_|___/_|\_\  |_|  |_|\__,_|_| |_|\__,_|\__, |\___|_|
                     |                                               |___/
                     |""".stripMargin
    println(asciiArt)
  }

  def commenceUserAuthInterface(): Unit = {
    start()
    breakable{
      while(true){
        showMenu()
        readLine() match {
          case "1" => CLIHandler.registerHandler()
          case "2" => CLIHandler.loginHandler()
          case _ =>
            println("Exiting... 🥲")
            break
        }
      }
    }
  }

}
