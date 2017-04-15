package duuni
import scala.collection.mutable.Buffer

class alkuja {

  def palyTurn = {
    println("kun on vastannut")
  }
  def playTurn(command: String) = {
    val kysymys = new Kysymykset
    //val outcomeReport = action.execute(this.player)
    //if (outcomeReport.isDefined) { 
    // this.turnCount += 1 
    val vuoro = 1

  }

  /*def playTurn(command: String) = {
    val action = new vastaukset(command)
    val outcomeReport = action.execute(this.player)
    //if (outcomeReport.isDefined) { 
      //this.turnCount += 1 
    }
    //outcomeReport.getOrElse("Unknown command: \"" + command + "\".")
  }
   */

  //Boolean joka kattoo millon voi laittaa lopetus lauseen
  def loppunut: Boolean = { // lopetus silloin kuin toinen laittanut sanan bye or thank you or thanks!!!
    val vastaus = new vastaukset
    var uusi = Buffer[String]()
    for (i <- 0 until vastaus.bufferiFirst.length) { //mieti millon // ei ainakaan first!!!

      if ((vastaus.bufferiFirst(i) == "bye")) {
        uusi += "bye"
      } else if ((vastaus.bufferiFirst(i) == "thank")) {
        uusi += "thank"
      } else if ((vastaus.bufferiFirst(i) == "thanks")) {
        uusi += "thanks"
      } else {
        uusi = uusi
      }
    }
    if (uusi == None) {
      false
    } else {
      true
    }

  }
  
  

  def player = "oma"

  //tässä kysymysten pohjia:
  // alotukseen vaan hello tai joku
  // ja seut
/*  def aloitus = "Doctor: Hello, What is your name?"
  
  def eka = "Doctor: Nice to meet you "
  def piste = "."
  def eka1 = " How are you today? "
  //def eka1 = "?"



  def toka = "Doctor: I understand that"
  def tokanJälkeenPiste = "."
  def toka1 = " What makes that you are "// tähän tokan kohan pelkkä ilmasu!!


  //"I see your problem, "
  /*def toka2 = "what do you feel about "
  def toka3 = "?"*/
  

  def kolmas = "Doctor: Okey, what are you thinking that " //koko vastaus HUOM! muutokset
  
  def neljäs = "Doctor: I see "
  def neljäs2 = "Tell me more that " //sama kuin edelliseen
  
  def viidesHappy = "Doctor: I am happy to hear that " //koko vastaus muutoksineen
  def viidenUnhappy = "Doctor: I hope you have beter day tomorrow that you are not " //kaikista tokan pelkkä ilmasu
  def viidesUnhappy2 =" anymore"
  def viidesElse = "Doctor: jotain"

  def lopetus1 = "I hope only the best for you, Bye"
  def lopetus2 = "bye"
  */
  
  
  
  
  

}