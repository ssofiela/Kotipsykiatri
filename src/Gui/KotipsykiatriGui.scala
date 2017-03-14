package Gui
import scala.io.StdIn._
import duuni._

object KotipsykiatriGui extends App {

  private val game = new Kysymykset
  private val games = new alkuja
  private val vastaus = new vastaukset
  //private val player = game.player
  this.run()

 

  //private val player = game.player
  this.playTurn()

  private def run() = {
    println(games.aloitus)
    while (games.loppunut) {
      println("jatkuu")
      this.printAreaInfo()
      this.playTurn()
    
    }
    println(games.lopetus1)//(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
  }
  private def printAreaInfo() = {
    val area = "vastaa tähän"
     println("\n\n" + game.kysymys1())
    //println("-" * area.name.length)
    //println(area.fullDescription + "\n")
  }

  private def playTurn() = {
    println("JÖÖ")
    val command = readLine("Message: ")
    val turnReport = games.playTurn(command)
    println(game.kysymys1())
   // if (!turnReport.isEmpty) {
     // println(turnReport)
   // }
  }

}
/* 
  private val game = new Adventure
  private val player = game.player
  this.run()

  
  /** Runs the game. First, a welcome message is printed, then the player gets the chance to 
    * play any number of turns until the game is over, and finally a goodbye message is printed. */
  private def run() = {
    println(this.game.welcomeMessage)
    while (!this.game.isOver) {
      this.printAreaInfo()
      this.playTurn()
    } 
    println("\n" + this.game.goodbyeMessage)
  }
  /** Prints out a description of the player character's current location, as seen by the character. */
  private def printAreaInfo() = {
    val area = this.player.location
    println("\n\n" + area.name)
    println("-" * area.name.length)
    println(area.fullDescription + "\n")
  }
  /** Requests a command from the player, plays a game turn accordingly, and prints out a report of what happened.  */
  private def playTurn() = {
    println()
    val command = readLine("Command: ")
    val turnReport = this.game.playTurn(command)
    if (!turnReport.isEmpty) {
      println(turnReport) 
    }
  }
*/