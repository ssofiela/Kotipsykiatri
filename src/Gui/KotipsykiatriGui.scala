package Gui
import scala.io.StdIn._
import duuni._

object KotipsykiatriGui extends App {

  private val K = new Kysymykset
  private val A = new alkuja
  private val V = new vastaukset
  //private val player = game.player
  this.run()
  //println("moi")
  // ja mihin väliin pitäs kysymykset laittaa että saisin vuorotellen doctor, message ...

  //private val player = game.player
  //  this.playTurn()

  private def run() = {
    println(K.alku())
    if (K.Ending()) {
      K.End
    } else {
      K.question1()
    }
    if (K.Ending()) {
      K.End
    } else {
      K.question2()
      //println("Toinen kysymys kysytty hurraa :D")
    }
    if (K.Ending()) {
      K.End
    } else {
      K.question3()
    }
    if (K.Ending()) {
      K.End
    } else {
      K.question4()
    }
    if (K.Ending()) {
      K.End
    } else {
    K.question5()
    if (K.Ending()) {
      K.End              //end ei toimi vielä niin kuin pitäisi
    } else {
   // K.question6()
    }
    //println(game.kysymys4())*/
    // }

   // while (K.Ending) {

      // game.kaikki
     // println("jatkuu")
      //this.printAreaInfo()
     // this.playTurn()

   // }
    //println(games.lopetus1)//(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
  }
 

 /* private def playTurn() = {
    println("jee")
    println("command")
    val command = readLine("Message: ")
    println("2")
    val turnReport = A.playTurn(command)*/

  }
}
