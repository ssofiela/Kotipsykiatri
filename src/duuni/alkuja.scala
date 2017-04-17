package duuni
import scala.collection.mutable.Buffer
import Gui._

class alkuja {

  val m = new muutokset
  val t = new tiedosto
  private val v = new vastaukset
  //private val kysymys = new Kysymykset
  private var turnCount = 0
  var b = 5
  var kysy = 8

  def playTurn(command: String): String = {
    this.turnCount += 1
    if (turnCount == 1) {
      t.kysymykset(1) + v.name + "! " + t.kysymykset(34) + "?"

    } else if (turnCount == 2) {
      t.kysymykset(2) + "." + t.kysymykset(35) + v.feel + "?"

    } else if (turnCount == 3) {
      t.kysymykset(5) + v.kolmas + "?"

    } else if (turnCount == 4) {
      t.kysymykset(4) + v.name + "!" + " " + t.kysymykset(36) + " " + v.neloseen + "."

    } else if (turnCount == 5) {
      var vitonen = v.vitonen

      var palauta = t.kysymykset(9) + " " + vitonen + ", " + v.name + ". " + t.kysymykset(26) + vitonen + "."

      for (i <- v.feel.split(" ")) {
        if (i == "fine" || i == "good" || i == "well" || i == "graet" || i == "awesome" || i == "grateful" ||
          i == "happy" || i == "proud") {
          palauta = (t.kysymykset(14) + " " + v.feel + ". " + t.kysymykset(26) + vitonen + ".")

        } else if (i == "bad" || i == "okey" || i == "angry" || i == "shy" || i == "mad" || i == "disapponted") {
          palauta = (" " + t.kysymykset(15) + v.feel + " " + ". " + t.kysymykset(16) + vitonen + ".")

        }
      }
      palauta

    } else if (turnCount == 6) {
      t.kysymykset(8) + " " + v.vitonen + "?"

    } else if (turnCount > 6) { // mieti tarkasti Vaik randomilla edellisen input tai nykynen
      
      kysy += 1
      println(kysy)
      b += 1
      println("b" + b)
     // var buffer = KotipsykiatriGui.bufferiin(b).split(" ").toBuffer
      println( t.kysymykset(kysy) , m.muutokset(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))
      t.kysymykset(kysy) +  m.muutokset(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)
      //var kysy = 9
      //var b = KotipsykiatriGui.bufferiin(6)

      /* var joo = t.kysymykset.size
      var juu = KotipsykiatriGui.bufferiin
      var jee = ""
      for (i <- 8 until joo) {
        println(i)
        for(u <- 3 until KotipsykiatriGui.bufferiin.size) { // 5 ja 4?  toka on 3
      println(u)
    	 
      var jee = t.kysymykset(i) + juu(u)
        }
      }
      println(jee)
      jee*/

    } else {
      "Doctor: I didn't understand you" // lisää komentoja
    }
  }

  def player = "oma"
  def uusiVuoro = {

  }

}