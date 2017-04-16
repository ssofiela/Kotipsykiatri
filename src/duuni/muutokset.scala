

package duuni
import Gui._
import scala.collection.mutable.Buffer

class muutokset {

  
  def piste(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()
  
    if(b(b.length - 1).contains(".")) {
      val pituus = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, pituus - 1)
      //println(line)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
  }
    line
  }

  /* def playTurn(command: String) = {
    val action = new Action(command)
    val outcomeReport = action.execute(this.player)
    if (outcomeReport.isDefined) { 
      this.turnCount += 1 
    }
    outcomeReport.getOrElse("Unknown command: \"" + command + "\".")
  }
  */

}