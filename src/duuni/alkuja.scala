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
  var numberOfAsk = 8
  var yesOrNo = Buffer[Int]()
  var IsName = 0
  var ei = Buffer[Int]()
  var asks = Buffer[Int]()

  def playTurn(command: String): String = {
    //tl.aa
    this.turnCount += 1
    if (turnCount == 1) {
      "Doctor:" + t.ask(2) + v.name + "! " + t.ask(31) + "?"

    } else if (turnCount == 2) {
      /* var line = ""
      if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
         var split = KotipsykiatriGui.bufferiin(turnCount - 1).split(",")
        for (i <- split(0).split(" ")) {
          if (i == "am" || i == "is") {
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer.take(i.size)) + "?"

          } else {
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer.drop(i.size)) + "?"
          }
        }
        line
      } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
        var split = KotipsykiatriGui.bufferiin(turnCount - 1).split(".")
        for (i <- split(0).split(" ")) {
          if (i == "am" || i == "is") {
            println("jooei")
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer.take(i.size)) + "?"

          } else {
            println("joohmm")
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer.drop(i.size)) + "?"
          }
        }
        line
      } else {*/

      if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
        var c = m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer).mkString(" ")
        var line = Buffer[String]()
        var split = c.split('.')
        if (split.size == 2) {
          println("split(0:)" + split(0))
          line += split(0)
        }
       var finalBuffer = line(0).split(" ").toBuffer

        "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(finalBuffer) + "?"
      } else {
        "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + "?"
      }
    } else if (turnCount == 3) {
      "Doctor:" + t.ask(8) + " " + v.three + "?"

    } else if (turnCount == 4) {
      "Doctor:" + t.ask(7) + v.name + "!" + " " + t.ask(33) + " you are " + v.feelBuffer(0) + "."

    } else if (turnCount == 5) { //meniköhän oikein?  tähän jos piste ja jos pilkku
      var five = v.Five

      var palauta = "Doctor:" + t.ask(9) + " " + five + ", " + v.name + ". "
      println(v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + "<-")
      for (i <- 0 until v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer).split(" ").size) {
        //println("tädää")
        var buf = v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer).split(" ")

        if (buf(i) == "fine" || buf(i) == "good" || buf(i) == "well" || buf(i) == "great" || buf(i) == "awesome" || buf(i) == "grateful" ||
          buf(i) == "happy" || buf(i) == "proud") {

          // println("jeeee")
          palauta = ("Doctor:" + t.ask(19) + " " + v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + ".")

        } else if (buf(i) == "bad" || buf(i) == "okey" || buf(i) == "angry" || buf(i) == "shy" || buf(i) == "mad" || buf(i) == "disapponted" && buf(i - 1) != "not") {
          palauta = "Dpctor: " + (t.ask(20) + v.feel(KotipsykiatriGui.bufferiin(1).split(" ").toBuffer) + " " + t.ask(21) + ".")

        }
      }
      palauta

    } else if (turnCount == 6) {
      "Doctor:" + t.ask(11) + " " + v.Five + "?"

    } else if (turnCount > 6) { // mieti tarkasti Vaik randomilla edellisen input tai nykynen

      /*katsoo että kysymysten alut ovat tekstissä indekseissä välillä 2-12
 * jos 12 niin silloin hyppää kakkoseen ja muuten randomilla valitaan alku
 */
      if (numberOfAsk == 15) {
        numberOfAsk = 5
      } else {
        var r = scala.util.Random
        var random = r.nextInt(11)
        numberOfAsk = random + 5 //täs oli 2
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
      println("täs b on :" +b)
      for (i <- 0 until yesOrNo.size) {
        while (b == yesOrNo(i)) {
          println("b muuttuu et erisuuri kuin yes" + b)
          b = (i + 1)
        }
      }

    

      for (i <- 0 until ei.size) {
        while (b == ei(i)) {
          b = (i + 1)
        }
      }
      
      
      for (i <- 0 until asks.size) {
        while (b == asks(i)) {
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
        println("yesOrNo" + yesOrNo)
        var s = r.nextInt(8)
        if (s == 1 || s == 3 || s == 5 || s== 6 || s == 7) {
          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy pilkku TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            //            println("rrrrrrrr")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "."
            } else {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy ylimääräinen piste TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            //            println("tttttttt")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + t.ask(numberOfAsk) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "."
            } else {
              "Doctor:" + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + t.ask(numberOfAsk) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "?"
            }
          } else if (m.yess(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
            println("ppppp, ei tänne jos ei yes tai no")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              m.yes(m.exclamation(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(turnCount-2).split(" ").toBuffer))) + "."
            } else {
              m.yes(m.exclamation(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(turnCount-2).split(" ").toBuffer))) + "?"
            } //täs tokas on ainaki doctor
          } else {
            println("tänne ei pitäs päätyy koskaan")
            ""
          }
        } else if (s == 2 || s == 8) {
          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            println("TÄÄÄÄÄÄÄKÖ")
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 2))))) + "?"
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            println("joujouoo")
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(v.common(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 2)).mkString(" ")))) + "?"
          } else {
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(turnCount - 2).split(" ").toBuffer))) + "?"
          }

        } else {
          if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy pilkku
            println("555555")
            "Doctor: " + t.ask(11) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "?"

          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy ylimääräinen piste
            "Doctor: " + t.ask(11) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "?"

          } else {
            println("tää on yes else")
            "Doctor: " + t.ask(11) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer))) + "?"
          }
        }

        //______________________________________________
     /* } else if (m.yess(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) {
        /* if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 5
         
        }*/

        var s = r.nextInt(8)
        if (s == 1 || s == 3 || s == 5 || s == 7 || s == 8) {
          if (v.commonB(KotipsykiatriGui.bufferiin(b))) { //jos löytyy pilkku TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                        println("rrrrrrrr")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b-2))))) + "."
            } else {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b-2))))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(b))) { //jos löytyy ylimääräinen piste TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                        println("tttttttt")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b-2))))) + "."
            } else {
              "Doctor:" + m.yes(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b-2))))) + "?"
            }
          } else if (m.yess(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) {
            println("ppppp, ei tänne jos ei yes tai no")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              m.yes(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "."
            } else {
              m.yes(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "?"
            } //täs tokas on ainaki doctor
          } else {
            println("tänne ei pitäs päätyy koskaan")
            ""
          }
        } else if (s == 2 || s == 6) {
          if (v.commonB(KotipsykiatriGui.bufferiin(b))) {
            println("TÄÄÄÄÄÄÄKÖ")
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b - 2))))) + "?"
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
            println("joujouoo")
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(v.common(v.twoPoints(KotipsykiatriGui.bufferiin(b - 2)).mkString(" ")))) + "?"
          } else {
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b - 2).split(" ").toBuffer))) + "?"
          }

        } else if(s == 4){
          if (v.commonB(KotipsykiatriGui.bufferiin(b))) { //jos löytyy pilkku
            println("555555")
            "Doctor: " + t.ask(11) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b - 2))))) + "?"

          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) { //jos löytyy ylimääräinen piste
            "Doctor: " + t.ask(11) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b - 2))))) + "?"

          } else {
            println("tää on yes else")
            "Doctor: " + t.ask(11) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer))) + "?"
          }
        } else {  //tää on vaan kokeilu
          println("kuinka usein tänne?")
          "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b - 2).split(" ").toBuffer))) + "?"
        }*/
      

        /*
         * katsoo kiroileeko
         */
      } else if (v.swear(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        "Doctor:" + " Shame your langueage!"
        
        
      } else if(v.sorry(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + "Everything is fine!"

        //-----------------------------------------------------------

        /*
         * katsoo kysyykö nimeä
         */
      } else if (v.IsItName(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIII
        IsName = b

        v.WhatIsYourName(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)

        /*
         * kysyy jotain muuta kysymystä, eli jos löytyy kysymysmerkki.
         * Silloin vastauksena: "I don't know but do you know..."
         */
        //--------------------------------------------------------------------
      } else if (m.??(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIIII
        if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 5
          //println(b)
        }
        
        asks += turnCount -1
        println("asks bufferi:" + asks)
        if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          "Doctor:" + "I don't know but " + "what do you think that " + m.change(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1)))) + "?"
        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          var line = Buffer[String]()
          var c = KotipsykiatriGui.bufferiin(turnCount - 1)
          var split = c.split('.')
          if (split.size == 2) {
            if (split(0).contains('?')) {
              line += split(0)
            } else {
              line += split(1)
            }
          }
          "Doctor:" + "I don't know but " + "what do you think that " + m.change(m.point(line)) + "?"
        } else {
          "Doctor:" + "I don't know but " + "what do you think that " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer))) + "?"
        }

        /*
         * jos käyttäjä käyttää huutomerkkiä.
         * silloin vastauksena: "Why do you yell at me?"
         */
        //--------------------------------------------------------------------------
      } else if (m.!!(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIIIIIIIII
        "Doctor: " + m.!(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)

        //_________________________________________________________________________________

        /*
         * Jos käyttäjän lause on "i don't know"
         * sillo
         */
      } else if (v.idkB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("11111")
            "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "."
          } else {
            println("222222")
            "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))))) + "?"
          }
        }
        ei += turnCount - 1
        "Doctor: " + v.name + ", " + t.ask(5) + " you don't know." + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "?"

        /*} else if (v.doingB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        println("doing metodi")
        "Doctor: " + t.kysymykset(12) + " " + v.doing(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)*/

        //----------------------------------------------------------------------------------
        /*
         * jos turnCount %6 =0 niin silloin käytetään feel metodia.
         * Jota ennen katotaan mihinkä lauseeseen sitä käytetään jos on monta lausetta
         */
      } else if (turnCount % 6 == 0) {

        println("tään on turnCount%6 == 0 ")
        if (v.commonB(KotipsykiatriGui.bufferiin(b))) {
          println("tään on turnCount%6 == 0 ja löytyy pilkku ")
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            "Doctor:" + t.ask(numberOfAsk) + " " +". You think a lot of about " + m.change(v.feel(m.exclamation(v.common(KotipsykiatriGui.bufferiin(b)))).split(" ").toBuffer) + "."
          } else {
            "Doctor:" + t.ask(39) + " " + m.change(v.feel(m.exclamation(v.common(KotipsykiatriGui.bufferiin(b)))).split(" ").toBuffer) + "." + t.ask(40)
          }

        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("turnCount%6, kaks pistettä, 5,7")
            "Doctor: " + t.ask(numberOfAsk) + " " + ". You think a lot of about " + m.change(v.feel(m.exclamation(v.twoPoints(KotipsykiatriGui.bufferiin(b)))).split(" ").toBuffer) + "."
          } else {
            println("turnCount%6, kaks pistettä")
            "Doctor: " + t.ask(39) + " " + m.change(v.feel(m.exclamation(v.twoPoints(KotipsykiatriGui.bufferiin(b)))).split(" ").toBuffer) + "." + t.ask(40)
          }

        } else if (numberOfAsk == 5 || numberOfAsk == 7) {
          println("tään on turnCount%6 == 0 ja ei löydy pilkkuu ")
          "Doctor:" + t.ask(numberOfAsk) + " "+ ". You think a lot of about " +  m.change(v.feel(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)).split(" ").toBuffer) + ". " + t.ask(40)
        } else {
          println("tään on turnCount%6 == 0 ja ei löydy pilkkuu")
          "Doctor:" + t.ask(39) + " " + m.change(v.feel(m.exclamation(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)).split(" ").toBuffer) + ". "+t.ask(40)
        }

        //------------------------------------------------------------------------------------
        /*
         * jos turnCount % 7 = 0.
         * Niin käytetään feeling metodia
         * Jota ennen katsotaan jos käyttäjä on laittanut useamman lauseen, että mihin sitä katsotaan.
         * Myös jos lauseen lopussa on piste tai huutomerkki, se otetaan pois.
         */
      } else if (turnCount % 7 == 0) {

        if (!(v.feeling(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer).isEmpty())) { //tähä ei mitään ylimäärästä tai siis pilkku ja piste tänneki!!!!!!!!!!!!!!

          if (v.commonB(KotipsykiatriGui.bufferiin(b))) {
            println("turnCoun%4 ja löyty pilkku") //TOIMIIIIIIIIIIIIIIIIIIIIIII
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor:" + t.ask(38) + " " + v.feeling(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "."
            } else {
              "Doctor:" + t.ask(38) + " " + v.feeling(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(b))) {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("turnCount%4 ja löyty kaks pistettä")
              "Doctor: " + t.ask(38) + " " + v.feeling(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "."
            } else {
              println("turnCount%4 ja löyty kaks pistettä")
              "Doctor: " + t.ask(38) + " " + v.feeling(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "?"
            }
          } else {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("tään on turnCount%4 == 0 ja löytyyEI pilkku ")
              "Doctor:" + t.ask(37) + " " + v.feeling(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "."

            } else {

              "Doctor:" + t.ask(37) + " " + v.feeling(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "?"

            }
          }

        } else { // kun feeling is empty

          if (v.commonB(KotipsykiatriGui.bufferiin(b))) {
            println("turnCount%4 löyty pikku mutta ei ole am tai is")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("aaaaaaa")
              "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "."
            } else {
              println("bbbbb")
              "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(b))) {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("cccccccc")
              "Doctor: " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "."
            } else {
              println("ddddddd")
              "Doctor: " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "?"
            }
          } else if(v.ConjunctionB(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)){
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("cccccccc000000")
              "Doctor: " + t.ask(numberOfAsk) + " " + v.Conjunction(m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))).split("").toBuffer) + "."
          } else {
              println("ddddddd000000")
              "Doctor: " + t.ask(numberOfAsk) + " " + v.Conjunction(m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))).split("").toBuffer) + "?"
            }
            
            } else {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("eeeeeeee")
              "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "."
            } else {
              println("fffffff")
              "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "?"
            }
          }
        }
        
        
        
        
        
        
        //-------------------------------------------------------------------------
        
     /* } else if(turnCount % 8 == 0) {
        ???
*/
        //-------------------------------------------------------------------------
        /*
         * Kun turnCount % 5 = 0.
         * Silloin lisänä tulee käyttäjän nimi alkuun.
         * muuten normaalisti käyttäen inputtia poistetaan piste tai huutomerkki lopusta jos on.
         * ja muutetaan input change metodin avulla järkeväksi.
         */
      } else if (turnCount % 5 == 0) {
        if (v.commonB(KotipsykiatriGui.bufferiin(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg3")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh3")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "?"
          }
        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg2")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh2")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "?"
          }
        } else if(v.ConjunctionB(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)){
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg0000000")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + v.Conjunction(m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))).split("").toBuffer) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh00000000")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + v.Conjunction(m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))).split("").toBuffer) + "?"
          }
        
          
        } else {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh")
            "Doctor: " + v.name + ", " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "?"
          }

        }

        //------------------------------------------------------------------------------------------------------------
        /*
         * jos käyttäjän inputissa esiintyy a tai the
         * käyttäjän inputista otetaan sen jälkeinen sana tai sanat.
         * Sitä ennen poistetaan loppu piste tai huutomerkki.
         * Ja jos inputtina monta sanaa, katsotaan mikä lause otetaan tutkittavaksi.
         */
      } else if (v.beB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)) {
        println("olla metodis, alkuja")
        val r = scala.util.Random
        var num = r.nextInt(2)

        if (v.commonB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          if (num == 1) {
            println("iiiiiiii3")
            "Doctor: " + t.ask(35) + " " + v.be(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))) + "?"
          } else {
            println("jjjjjjjjj3")
            "Doctor: " + t.ask(34) + " " + v.be(v.common(KotipsykiatriGui.bufferiin(turnCount - 1))) + "?"
          }
        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(turnCount - 1))) {
          if (num == 1) {
            println("iiiiiiiii2")
            "Doctor: " + t.ask(35) + " " + v.be(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1))) + "?"
          } else {
            println("jjjjjjjjj2")
            "Doctor: " + t.ask(34) + " " + v.be(v.twoPoints(KotipsykiatriGui.bufferiin(turnCount - 1))) + "?"
          }
        } else if(v.ConjunctionB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)){
          if (num == 1) {
            println("iiiiiiiii000000")
            "Doctor: " + t.ask(35) + " " + v.Conjunction(v.be(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer).split("").toBuffer) + "?"
          } else {
            println("jjjjjjjjj000000")
            "Doctor: " + t.ask(34) + " " + v.Conjunction(v.be(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer).split("").toBuffer) + "?"
          }
        } else {
          if (num == 1) {
            println("iiiiiii")
            "Doctor: " + t.ask(35) + " " + v.be(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + "?"
          } else {
            println("jjjjj")
            "Doctor: " + t.ask(34) + " " + v.be(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer) + "?"
          }
        }

        //------------------------------------------------------------------------------
      } else { //loppu else alkaa tästä
        if (v.commonB(KotipsykiatriGui.bufferiin(b))) {
          println("tään on lopun elsessä ja löytyy pilkku ")
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("kkkkk")
            "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "."
          } else {
            println("llllllll") //    TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriGui.bufferiin(b))))) + "?"
          }

        } else if (v.twoPointsB(KotipsykiatriGui.bufferiin(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("kaks pistettä, 5,7")
            "Doctor: " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "."
          } else {
            println("kaks pistettä" + m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) //TOIMIIIIIIIIIIIIIIIIIIIIIIIIIII  otin tästä pois välilyönnin
            "Doctor: " + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) + "?"
          }
        } else if(v.ConjunctionB(KotipsykiatriGui.bufferiin(turnCount - 1).split(" ").toBuffer)){
           if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("kaks pistettä, 5,7, 0000000000")
            "Doctor: " + t.ask(numberOfAsk) + " " +v.Conjunction(m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))).split("").toBuffer) + "."
          } else {
            println("000000000, kaks pistettä" + m.exclamation(m.point(v.twoPoints(KotipsykiatriGui.bufferiin(b))))) 
            "Doctor: " + t.ask(numberOfAsk) + " " + v.Conjunction(m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))).split("").toBuffer) + "?"
          }
        } else if (numberOfAsk == 5 || numberOfAsk == 7) {
          println("tää on lopun elsessä ja ei löydy pilkkua")
          "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "."

        } else {
          println("lopun else, ei pilkkua")
          "Doctor:" + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(b).split(" ").toBuffer))) + "?"
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
