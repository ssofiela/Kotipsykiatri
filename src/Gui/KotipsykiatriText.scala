package Gui
import scala.io.StdIn._
import work._
import scala.collection.mutable.Buffer

object KotipsykiatriText extends App {

 
  private val answers = new Answers
  private val fileReader = new FileReader
  private var currentCommand = ""
  var commands = Buffer[String]() // nyt tääl on kaikki
 
  var saving = Buffer[String]()

  this.run()

  def run() = {
    println("Doctor: Hello, What´s your name?")
    while (end(currentCommand)) {
      val newCommand = readLine("Message: ")
      currentCommand = newCommand
      //Tarkasta, että käyttäjä kirjoitti jotain
      if (currentCommand.length > 0 && this.end(currentCommand)) {

        commands += newCommand //jos käyttäjä kirjoittaa jotain, se lisätään bufferiin
        val turnReport = Turn.playTurn(currentCommand)
        saving += turnReport

        println(turnReport)
      } else if (this.end(currentCommand)) {

        println("Pls say something!")

      }
    }
    val r = scala.util.Random
    var random = r.nextInt(2)
    if (random == 1) {
      println("Doctor:" + fileReader.ask(24) +" " + answers.name + " " + fileReader.ask(25)) + "!"
    } else {
      println("Doctor: " + fileReader.ask(26) + answers.name + " " + fileReader.ask(25)) + "!"
    }
  }

  def end(s: String): Boolean = { 
    val splitted = s.split(" ")
    for (i <- splitted) {
      if (i == "bye" || i == "Bye" || i == "goodbye" || i == "Goodbye") {
        return false
      }
    }
    true
  }
}
