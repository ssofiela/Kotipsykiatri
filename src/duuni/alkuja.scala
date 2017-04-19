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
      "Doctor:" + t.kysymykset(1) + v.name + "! " + t.kysymykset(34) + "?"

    } else if (turnCount == 2) {
     "Doctor:" + t.kysymykset(2) + "." + t.kysymykset(35) + v.feel + "?"

    } else if (turnCount == 3) {
     "Doctor:" + t.kysymykset(5) + v.kolmas + "?"

    } else if (turnCount == 4) {
      "Doctor:" + t.kysymykset(4) + v.name + "!" + " " + t.kysymykset(36) + " " + v.neloseen + "."

    } else if (turnCount == 5) {
      var vitonen = v.vitonen

      var palauta = "Doctor:" + t.kysymykset(9) + " " + vitonen + ", " + v.name + ". " + t.kysymykset(26) 

      for (i <- v.feel.split(" ")) {
        if (i == "fine" || i == "good" || i == "well" || i == "graet" || i == "awesome" || i == "grateful" ||
          i == "happy" || i == "proud") {
          palauta = ("Doctor:" + t.kysymykset(14) + " " + v.feel + t.kysymykset(26) + ".")

        } else if (i == "bad" || i == "okey" || i == "angry" || i == "shy" || i == "mad" || i == "disapponted") {
          palauta = ("Doctor:" + " " + t.kysymykset(15) + v.feel + " " + ". " + t.kysymykset(16) )

        }
      }
      palauta

    } else if (turnCount == 6) {
      "Doctor:" + t.kysymykset(8) + " " + v.vitonen + "?"

    } else if (turnCount > 6) { // mieti tarkasti Vaik randomilla edellisen input tai nykynen
      // while(kysy < 12){

      if (kysy == 12) {
        kysy = 2
      } else {
        kysy += 1
      }
     
    //  println(b)
    //  println("turnCount:" + turnCount)
      if (m.yess(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {  //kun tulee yes tai no
        b = turnCount - 1
      //  println("tää menee yes ja b:" + b)
      }
      if (b % 5 == 0) {
        b = turnCount - 1

      } else if (b % 2 == 0) {
        b -= 2
      //  println("jaollinen kahella, b:" + b)
      } else if (b % 7 == 0) {
        b += 3
      } else if (b % 9 == 0) {
        b -= 3
      } else if (b % 5 == 0) {
        b += 1
      } else {
        b += 2
       // println("elseen b:" + b)
      }
     // b+= 1

      //  println(kysy)
      if (b > turnCount - 1) {
        b = turnCount - 1
      }

      /* if(b %2 == 0){    //tekee ettei aina valitse edellisen vastausta!
       b -= 2           
      } else {
         b += 2*/
      println("b" + b)
      // }
      // var buffer = KotipsykiatriGui.bufferiin(b).split(" ").toBuffer
      //println( t.kysymykset(kysy) , m.muutokset(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))
      if (m.yess(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.kysymykset(kysy).drop(7) + m.muutokset(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer) + "?"
      } else if(turnCount %4 == 0){
    	//  println("nyt pitäs tulla feeling")
        "Doctor:" + t.kysymykset(b) + v.feeling(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)
      } else {
       "Doctor:" + t.kysymykset(kysy) + m.muutokset(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer) + "?"
      }
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