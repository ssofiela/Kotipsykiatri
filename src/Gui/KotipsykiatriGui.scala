package Gui
import scala.io.StdIn._
import duuni._

object KotipsykiatriGui extends App {

  private val game = new Kysymykset
  private val games = new alkuja
  private val vastaus = new vastaukset
  //private val player = game.player
  this.run()
  //println("moi")
  // ja mihin väliin pitäs kysymykset laittaa että saisin vuorotellen doctor, message ...

  //private val player = game.player
  //  this.playTurn()

  private def run() = {
    println(game.alku())
    if (game.loppunut()) {
      game.lopetus
    } else {
      game.kysymys1()
    }
    if (game.loppunut()) {
      game.lopetus
    } else {
      game.kysymys2()
      //println("Toinen kysymys kysytty hurraa :D")
    }
    if (game.loppunut()) {
      game.lopetus
    } else {
      game.kysymys3()
    }
    if (game.loppunut()) {
      game.lopetus
    } else {
      game.kysymys4()
    }
    // game.kysymys5()
    //println(game.kysymys4())*/
    // }

    while (game.loppunut) {

      // game.kaikki
      println("jatkuu")
      this.printAreaInfo()
      this.playTurn()

    }
    //println(games.lopetus1)//(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
  }
  private def printAreaInfo() = {
    val area = "vastaa tähän"
    // println(game.kysymys1())
    //println("-" * area.name.length)
    //println(area.fullDescription + "\n")
  }

  private def playTurn() = {
    println("jee")
    println("command")
    val command = readLine("Message: ")
    println("2")
    val turnReport = games.playTurn(command)

  }

  // if (!turnReport.isEmpty) {
  // println(turnReport)
  // }//
  // }
}