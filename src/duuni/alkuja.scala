package duuni
import scala.collection.mutable.Buffer
import Gui._

class alkuja {

  val m = new muutokset
  val t = new tiedosto
 val v = new vastaukset
  //var tl = new tallenna
  //private val kysymys = new Kysymykset
  private var turnCount = 0
  var b = 6
  var kysy = 8
  var yesOrNo = Buffer[Int]()
  var IsName = 0
  var ei = Buffer[Int]()

  def playTurn(command: String): String = {
    //tl.aa
    this.turnCount += 1
    if (turnCount == 1) {
      "Doctor:" + t.ask(2) + v.name + "! " + t.ask(31) + "?"

    } else if (turnCount == 2) {
      "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + "?"

    } else if (turnCount == 3) {
      "Doctor:" + t.ask(8) + v.three + "?"

    } else if (turnCount == 4) {
      "Doctor:" + t.ask(7) + v.name + "!" + " " + t.ask(33) + " you are " + v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + "."

    } else if (turnCount == 5) { //meniköhän oikein?
      var vitonen = v.vitonen

      var palauta = "Doctor:" + t.ask(9) + " " + vitonen + ", " + v.name + ". "
      println(v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + "<-")
      for (i <- v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer).split(" ")) {
        //println("tädää")
        if (i == "fine" || i == "good" || i == "well" || i == "great" || i == "awesome" || i == "grateful" ||
          i == "happy" || i == "proud") {
          // println("jeeee")
          palauta = ("Doctor:" + t.ask(19) + " " + v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + ".")

        } else if (i == "bad" || i == "okey" || i == "angry" || i == "shy" || i == "mad" || i == "disapponted") {
          palauta = "Dpctor: " + (t.ask(20) + v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + " " + t.ask(21) + ".")

        }
      }
      palauta

    } else if (turnCount == 6) {
      "Doctor:" + t.ask(11) + " " + v.vitonen + "?"

    } else if (turnCount > 6) { // mieti tarkasti Vaik randomilla edellisen input tai nykynen

      /*katsoo että kysymysten alut ovat tekstissä indekseissä välillä 2-12
 * jos 12 niin silloin hyppää kakkoseen ja muuten randomilla valitaan alku
 */
      if (kysy == 15) {
        kysy = 5
      } else {
        var r = scala.util.Random
        var random = r.nextInt(11)
        kysy = random + 5 //täs oli 2
      }

      /*
       * valitaan randomilla mistä inputista tohtori keskustelee seuraavaksi
       */
      val r = scala.util.Random
      var num = r.nextInt(13)
      if (num == 1 || num == 5 || num == 6 || num == 4) {
        b += 1
      } else if (num == 2 || num == 9) {
        b += 2
      } else if (num == 3 || num == 7 || num == 8) {
        b -= 1
      } else {
        b = b

      }

      /*
       * tällä karkoitetaan ettei kysymyksistä tulisi outoja, että skippaa inputit missä vaan yes tai no
       */
      // println("yesOrNot:" + yesOrNo + "IsName:" + IsName)

      for (i <- 0 until yesOrNo.size) {
        if (b == yesOrNo(i)) {
          b = (i + 1)
        }
      }
      
      if (b > turnCount - 1) {
    	  b = turnCount - 1
      }

      for (i <- 0 until ei.size) {
        if (b == ei(i)) {
          b = (i + 1)
        }
      }
      println("ei on:" + ei)
      if (b == IsName) {
        b = IsName + 1
      }

      if (b > turnCount - 1) {
        b = turnCount - 1
      }

      // println("b" + b)

      /*
       * kun vastauksena yes tai no, niin silloin vastaus valitaan randomilla parista, että mikä vastaus tulee.
       */
      if (m.yess(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        /* if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 5
         
        }*/
        yesOrNo += turnCount - 1
        var s = r.nextInt(5)
        if (s == 1 || s == 3 || s == 5) {
          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy pilkku
            println("rrrrrrrr")
            if (kysy == 5 || kysy == 7) {
             "Doctor: "+  m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.ask(kysy) +" "+ v.common(m.change(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer))).mkString(" ") + "."
            } else {
            "Doctor: "+  m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.ask(kysy)  +" "+ v.common(m.change(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer))).mkString(" ") + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy ylimääräinen piste
            println("tttttttt")
            if (kysy == 5 || kysy == 7) {
             "Doctor: "+ m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.ask(kysy) + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
            } else {
             "Doctor:" +m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.ask(kysy)  + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
            }
          } else { //muuten
            println("ppppp")
            if (kysy == 5 || kysy == 7) {
            m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.ask(kysy)  + m.change(KotipsykiatriGui.bufferiin(turnCount - 3).split(" ").toBuffer) + "."
            } else {
             m.yes(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + t.ask(kysy)  + m.change(KotipsykiatriGui.bufferiin(turnCount - 2).split(" ").toBuffer) + "?"
            }
          }
        } else if (s == 2) {
           if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          println("TÄÄÄÄÄÄÄKÖ")
          "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + v.common(m.change(m.point(KotipsykiatriGui.bufferiin(turnCount - 2).split(" ").toBuffer))).mkString(" ") + "?"
        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
           "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + v.common(m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 2))))).mkString(" ") + "?"
        } else{
           "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(turnCount - 2).split(" ").toBuffer)) + "?"
        }
        
           } else {
          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy pilkku

            "Doctor: " + t.ask(11)  + v.common(m.change(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer))).mkString(" ") + "?"

          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy ylimääräinen piste
            "Doctor: " + t.ask(11)  + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"

          } else {
             println("tää on yes else")
            "Doctor: " + t.ask(11)  +" " + m.change(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + "?"
          }
        }

        /*
         * 
         * 
         */
      } else if (v.IsItName(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        IsName = b

        v.WhatIsYourName(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)

        /*
         * 
         * 
         */
      } else if (m.??(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 5
          //println(b)
        }

        "Doctor:" + "I don't know but " + "what do you think about " + m.changeReverse(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"

      } else if (m.!!(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + m.!(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)

      } else if (v.idkB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          if (kysy == 5 || kysy == 7) {
            "Doctor:" + t.ask(kysy) + " " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
          } else {
            "Doctor:" + t.ask(kysy) + " " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
          }
        }
        ei += turnCount - 1
        "Doctor: " + v.name + ", " + t.ask(5) + " you don't know." + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"

        /*} else if (v.doingB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        println("doing metodi")
        "Doctor: " + t.kysymykset(12) + " " + v.doing(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)*/

      } else if (turnCount % 6 == 0) { //tähän pitää laittaa tietyt alut!!! vaik suoraan sinne vastaukset

        println("tään on turnCount%6 == 0 ")
        if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          println("tään on turnCount%6 == 0 ja löytyy pilkku ")
          if (kysy == 5 || kysy == 7) {
            "Doctor:" + t.ask(kysy) + " " + v.feel(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))) + "."
          } else {
            "Doctor:" + t.ask(kysy) + " " + v.feel(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))) + "?"
          }

        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          if (kysy == 5 || kysy == 7) {
            println("turnCount%6, kaks pistettä, 5,7")
            "Doctor: " + t.ask(kysy) + " " + ". You think a lot of about " + v.feel(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1))) + "."
          } else {
            println("turnCount%6, kaks pistettä")
            "Doctor: " + t.ask(kysy) + " " + (v.feel(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
          }

        } else if (kysy == 5 || kysy == 7) {
          println("tään on turnCount%6 == 0 ja ei löydy pilkkuu ")
          "Doctor:" + t.ask(kysy) + " " + v.feel(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer) + "."
        } else {
          println("tään on turnCount%6 == 0 ja ei löydy pilkkuu")
          "Doctor:" + t.ask(kysy) + " " + v.feel(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer) + "?"
        }

      } else if (turnCount % 4 == 0) { //LISÄÄ PISTE JA KYSYMYSMERKKI muuta 7777

        if (!(v.feeling(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer).isEmpty())) { //tähä ei mitään ylimäärästä tai siis pilkku ja piste tänneki!!!!!!!!!!!!!!

          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            println("turnCoun%4 ja löyty pilkku")
            if (kysy == 5 || kysy == 7) {
              "Doctor:" + t.ask(kysy) + " " + v.feeling(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
            } else {
              "Doctor:" + t.ask(kysy) + " " + v.feeling(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            if (kysy == 5 || kysy == 7) {
              println("turnCount%4 ja löyty kaks pistettä")
              "Doctor: " + t.ask(kysy) + " " + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
            } else {
              println("turnCount%4 ja löyty kaks pistettä")
              "Doctor: " + t.ask(kysy) + " " + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
            }
          } else {
            if (kysy == 5 || kysy == 7) {
              println("tään on turnCount%4 == 0 ja löytyyEI pilkku ")
              "Doctor:" + t.ask(37) + " " + v.feeling(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer) + "."

            } else {

              "Doctor:" + t.ask(37) + " " + v.feeling(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer) + "?"

            }
          }

        } else { // kun feeling is empty

          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            println("turnCount%4 löyty pikku mutta ei ole am tai is")
            if (kysy == 5 || kysy == 7) {
              "Doctor:" + t.ask(kysy) + " " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
            } else {
              "Doctor:" + t.ask(kysy) + " " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            if (kysy == 5 || kysy == 7) {
              "Doctor: " + t.ask(kysy) + " " + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
            } else {
              "Doctor: " + t.ask(kysy) + " " + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
            }
          } else {
            if (kysy == 5 || kysy == 7) {
              "Doctor:" + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "."
            } else {
              "Doctor:" + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"
            }
          }
        }

      } else if (turnCount % 5 == 0) {
        if (kysy == 5 || kysy == 7) {
          "Doctor:" + v.name + ", " + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "."
          //  println("muutettu:" + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)))
        } else {
          "Doctor:" + v.name + ", " + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"
        }

      } else if (v.ollaB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        println("olla metodis, alkuja")
        val r = scala.util.Random
        var num = r.nextInt(2)
        if (num == 1) {
          "Doctor: " + t.ask(35) + " " + v.olla(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + "?"
        } else {
          "Doctor: " + t.ask(34) + " " + v.olla(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + "?"
        }

      } else { //loppu else alkaa tästä
        if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          println("tään on lopun elsessä ja löytyy pilkku ")
          if (kysy == 5 || kysy == 7) {
            "Doctor:" + t.ask(kysy) + " " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
          } else {
            "Doctor:" + t.ask(kysy) + " " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
          }

        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          if (kysy == 5 || kysy == 7) {
            println("kaks pistettä, 5,7")
            "Doctor: " + t.ask(kysy) + " " + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "."
          } else {
            println("kaks pistettä")
            "Doctor: " + t.ask(kysy) + " " + m.change(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
          }
        } else if (kysy == 5 || kysy == 7) {
          println("tää on lopun elsessä ja ei löydy pilkkua")
          "Doctor:" + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "."

        } else {
          println("lopun else, ei pilkkua")
          "Doctor:" + t.ask(kysy) + " " + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + "?"
        }
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
