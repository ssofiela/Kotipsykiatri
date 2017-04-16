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
  /*def loppunut(): Boolean = { // lopetus silloin kuin toinen laittanut sanan bye or thank you or thanks!!!
    var v 
    val splitted = v.all.split(" ")
    for(i <- splitted){
      if(i =="bye" || i == "goodbye"){
        return false
      }
    }
    true
    
  */
  
  

  def player = "oma"


  
  
  
  
  

}