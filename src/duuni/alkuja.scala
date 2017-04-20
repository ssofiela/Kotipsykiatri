package duuni
import scala.collection.mutable.Buffer
import Gui._

class alkuja {

  val m = new muutokset
  val t = new tiedosto
  private val v = new vastaukset
  //private val kysymys = new Kysymykset
  private var turnCount = 0
  var b = 6
  var kysy = 8
  var yesOrNo = 0
  var IsName = 0

  def playTurn(command: String): String = {
    this.turnCount += 1
    if (turnCount == 1) {
      "Doctor:" + t.kysymykset(1) + v.name + "! " + t.kysymykset(34) + "?"

    } else if (turnCount == 2) {
      "Doctor:" + t.kysymykset(2) + "." + t.kysymykset(35) + v.feel + "?"

    } else if (turnCount == 3) {
      "Doctor:" + t.kysymykset(5) + v.kolmas + "?"

    } else if (turnCount == 4) {
      "Doctor:" + t.kysymykset(4) + v.name + "!" + " " + t.kysymykset(36) + " you are" + v.feel + "."

    } else if (turnCount == 5) {    //meniköhän oikein?
      var vitonen = v.vitonen

      var palauta = "Doctor:" + t.kysymykset(9) + " " + vitonen + ", " + v.name + ". "

      for (i <- v.feel.split(" ")) {
        if (i == "fine" || i == "good" || i == "well" || i == "graet" || i == "awesome" || i == "grateful" ||
          i == "happy" || i == "proud") {
          palauta = ("Doctor:" + t.kysymykset(14) + " " + v.feel + ".")

        } else if (i == "bad" || i == "okey" || i == "angry" || i == "shy" || i == "mad" || i == "disapponted") {
          palauta = "Dpctor: " + (t.kysymykset(15) + v.feel + " " + t.kysymykset(16) + ".")

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
      if (m.yess(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) { //kun tulee yes tai no
        b = turnCount - 1
        //  println("tää menee yes ja b:" + b)
      }
      val r = scala.util.Random //vielä ehkä vähemmän hajontaa????
      var num = r.nextInt(10)
      if (num == 1 || num == 5 || num == 6 || num == 4) {
        b += 1
      } else if (num == 2) {
        b += 2
      } else if (num == 3 || num == 7 || num == 8) {
        b -= 1
      } else {
        b = b

      }
      if (b == yesOrNo) {
        b = yesOrNo + 1
      }
      if (b == IsName) {
        b = IsName + 1
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
        if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 2
          println("yesOrNo:" + yesOrNo)
        }
        yesOrNo = b
       // println("olen YEs metodissa")
        var s = r.nextInt(5)
        if (s == 1 || s == 3 || s == 5) {
          m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)
        } else if (s == 2) {
         "Doctor: " + t.kysymykset(4) + v.name + "."
        } else {
          "Doctor: " + t.kysymykset(8) + " " + m.muutokset(KotipsykiatriGui.bufferiin(turnCount -1).split(" ").toBuffer) + "?"
        }
      } else if (v.IsItName(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        IsName = b
        //	println("your name???")

        v.WhatIsYourName(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)

      } else if (m.??(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 2
          //println(b)
        }

        "Doctor:" + "I don't know but " + "what do you think about " + m.muutoksetReverse(m.piste(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"

      } else if (m.!!(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + m.!(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)
        
      } else if(v.doingB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)){
        println("doing metodi")
        "Doctor: " + t.kysymykset(9) + v.doing(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)

      } else if (turnCount % 4 == 0) {
        //  println("nyt pitäs tulla feeling")
        "Doctor:" + t.kysymykset(b) + v.feeling(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)

      } else if (turnCount % 5 == 0) {
        "Doctor:" + v.name + ", " + t.kysymykset(kysy) + " " + m.muutokset(m.piste(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"
      } else if (kysy == 2 || kysy == 4) {
        // println("muutettu:" + m.muutokset(m.piste(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)))

        "Doctor:" + t.kysymykset(kysy) + " " + m.muutokset(m.piste(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "."
      } else {

        "Doctor:" + t.kysymykset(kysy) + " " + m.muutokset(m.piste(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"
      }

    } else {
      "Doctor: I didn't understand you" // lisää komentoja
    }
  }

  def player = "oma"

}

/*
 * tee doing ja going eri metodit jossa taas tosi tarkasti!!
 * sit 
 */
