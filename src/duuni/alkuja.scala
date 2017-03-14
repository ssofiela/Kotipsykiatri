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
    for (i <- 0 until vastaus.bufferi.length) {

      if ((vastaus.bufferi(i) == "bye")) {
        uusi += "bye"
      } else if ((vastaus.bufferi(i) == "thank")) {
        uusi += "thank"
      } else if ((vastaus.bufferi(i) == "thanks")) {
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
  def aloitus = "Doctor: Hello, What is your name?"
  def eka = "how are you doing, "
  def eka1 = "?"

  def toka = "I see your problem, "
  def toka2 = "what do you feel about "
  def toka3 = "?"

  def kolmas = "I understand the fact that you feel "
  def kolmas2 = "?"

  def lopetus1 = "I hope only the best for you, Bye"
  def lopetus2 = "bye"
  

}