package Gui
import scala.io.StdIn._
import duuni._
import scala.collection.mutable.Buffer

object KotipsykiatriGui extends App {

  private val K = new Kysymykset
  private val A = new alkuja
  private val V = new vastaukset
 

   var currentCommand = ""
   var bufferiin = Buffer[String]()      // nyt tääl on kaikki
  
  this.run()

   def run() = {
    println("Hello, What´s your name?")
    while (loppunut(currentCommand)) {
      val newCommand = readLine("Message: ")
      currentCommand = newCommand
      println("bufferiin:" + bufferiin)
      //Tarkasta, että käyttäjä kirjoitti jotain
      if (currentCommand.length > 0){
    	  bufferiin += newCommand      //tässä koska silloin tyhjiä ei lisätä bufferiin

        val turnReport = A.playTurn(currentCommand)
        println(turnReport)
      }
      else{
        
        println("Pls say something!")
        
      }   
    }
    println("End")//(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
  }


  def loppunut(s: String): Boolean = {      //TOIMIIIIII
    val splitted = s.split(" ")
    for (i<-splitted){
      if (i == "bye" || i == "goodbye"){
        return false
      }
    }
    true
  }
}
