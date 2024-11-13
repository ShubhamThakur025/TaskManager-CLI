package taskmanager

import taskmanager.userinterface.UserAuthentication

object TaskManagerCLI {
  def main(args: Array[String]): Unit = {
    UserAuthentication.commenceUserAuthInterface()
    println("Byee 👋..")
  }
}
