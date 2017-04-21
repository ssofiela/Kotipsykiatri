package Gui
import scala.io.StdIn._
import duuni._
import scala.collection.mutable.Buffer

object KotipsykiatriGui extends App {

 // private val K = new Kysymykset
  private val A = new alkuja
  private val V = new vastaukset
  private val T = new tiedosto
  private val tl = new tallenna

  var currentCommand = ""
  var bufferiin = Buffer[String]() // nyt tääl on kaikki
  var tee = ""
  var too= ""

  this.run()

  def run() = {
    println("Doctor: Hello, What´s your name?")
    while (loppunut(currentCommand)) {
      val newCommand = readLine("Message: ")
      currentCommand = newCommand
      println("bufferiin:" + bufferiin)
      //Tarkasta, että käyttäjä kirjoitti jotain
      if (currentCommand.length > 0) {
        bufferiin += newCommand //tässä koska silloin tyhjiä ei lisätä bufferiin
        tee = newCommand
        tl.oo
        val turnReport = A.playTurn(currentCommand)
        too = turnReport
        tl.aa
        println(turnReport)
      } else {

        println("Pls say something!")

      }
    }
    val r = scala.util.Random
    r.nextInt(2)
    if (r == 1) {
      println("Doctor:" + T.ask(24) + V.name + " " + T.ask(25)) //(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
    } else {
    println("Doctor: " + T.ask(26) + V.name + " " + T.ask(25))
    }
  }

  def loppunut(s: String): Boolean = { //TOIMIIIIII
    val splitted = s.split(" ")
    for (i <- splitted) {
      if (i == "bye" || i == "goodbye") {
        return false
      }
    }
    true
  }
}
