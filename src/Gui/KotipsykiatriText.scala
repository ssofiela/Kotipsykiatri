package Gui
import scala.io.StdIn._
import duuni._
import scala.collection.mutable.Buffer

object KotipsykiatriText extends App {

  // private val K = new Kysymykset
  //  private val A = new alkuja
  private val answers = new Answers
  private val fileReader = new FileReader
  private var currentCommand = ""
  var commands = Buffer[String]() // nyt tääl on kaikki
  //var tee = Buffer[String]()
  var saving = Buffer[String]()

  this.run()

  def run() = {
    println("Doctor: Hello, What´s your name?")
    while (end(currentCommand)) {
      val newCommand = readLine("Message: ")
      currentCommand = newCommand
      println("bufferiin:" + commands)
      //Tarkasta, että käyttäjä kirjoitti jotain
      if (currentCommand.length > 0 && this.end(currentCommand)) {

        commands += newCommand //tässä koska silloin tyhjiä ei lisätä bufferiin

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
      println("Doctor:" + fileReader.ask(24) + answers.name + " " + fileReader.ask(25)) //(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
    } else {
      println("Doctor: " + fileReader.ask(26) + answers.name + " " + fileReader.ask(25))
    }
  }

  def end(s: String): Boolean = { //TOIMIIIIII
    val splitted = s.split(" ")
    for (i <- splitted) {
      if (i == "bye" || i == "goodbye") {
        return false
      }
    }
    true
  }
}
