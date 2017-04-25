package duuni
import scala.collection.mutable.Buffer
import Gui._

object Turn {

  private val changes = new Changes
  private val fileReader = new FileReader
  private val answers = new Answers
  /*
 * monesko vuoro on menossa
 */
  var turnCount = 0
  /*
   * tärkeä tässä luokassa, siinä on numero, johon tohtorin puhe keskittyy sillä kerralla eli
   * mikä on esim KotipsykiatriText.commands(b).
   */
  var b = 6
  var numberOfAsk = 8
  /*
   * jos esiintyy "yes" tai "no", puheessa, random hyppää b niiden yli.
   */
  var yesOrNo = Buffer[Int]()
  var IsName = 0
  /*
   * jos esiintyy "I don't know" niin sitä ei käytetä enää tohtorin puheissa
   */
  var ifIdk = Buffer[Int]()
  var asks = Buffer[Int]()

  def playTurn(command: String): String = {
    //tl.aa
    this.turnCount += 1
    if (turnCount == 1) {
      "Doctor:" + fileReader.ask(2) + answers.name + "! " + fileReader.ask(31) + "?"

    } else if (turnCount == 2) {
      /* var line = ""
      if (v.commonB(KotipsykiatriText.commands(turnCount - 1))) {
         var split = KotipsykiatriText.commands(turnCount - 1).split(",")
        for (i <- split(0).split(" ")) {
          if (i == "am" || i == "is") {
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer.take(i.size)) + "?"

          } else {
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer.drop(i.size)) + "?"
          }
        }
        line
      } else if (v.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
        var split = KotipsykiatriText.commands(turnCount - 1).split(".")
        for (i <- split(0).split(" ")) {
          if (i == "am" || i == "is") {
            println("jooei")
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer.take(i.size)) + "?"

          } else {
            println("joohmm")
           line = "Doctor:" + t.ask(5) + "." + t.ask(32) + v.feel(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer.drop(i.size)) + "?"
          }
        }
        line
      } else {*/

      if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
        var c = changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer).mkString(" ")
        var line = Buffer[String]()
        var split = c.split('.')
        if (split.size == 2) {
          println("split(0:)" + split(0))
          line += split(0)
        }
        var finalBuffer = line(0).split(" ").toBuffer

        "Doctor:" + fileReader.ask(5) + "." + fileReader.ask(32) + answers.feel(finalBuffer) + "?"
      } else {
        "Doctor:" + fileReader.ask(5) + "." + fileReader.ask(32) + answers.feel(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + "?"
      }
    } else if (turnCount == 3) {
      "Doctor:" + fileReader.ask(8) + " " + answers.three + "?"

    } else if (turnCount == 4) {
      "Doctor:" + fileReader.ask(7) + answers.name + "!" + " " + fileReader.ask(33) + " you are " + answers.feelBuffer(0) + "."

    } else if (turnCount == 5) { //meniköhän oikein?  tähän jos piste ja jos pilkku
      var five = answers.Five

      var palauta = "Doctor:" + fileReader.ask(9) + " " + five + ", " + answers.name + ". "
      println(answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer) + "<-")
      for (i <- 0 until answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer).split(" ").size) {
        //println("tädää")
        var buf = answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer).split(" ")

        if (buf(i) == "fine" || buf(i) == "good" || buf(i) == "well" || buf(i) == "great" || buf(i) == "awesome" || buf(i) == "grateful" ||
          buf(i) == "happy" || buf(i) == "proud") {

          // println("jeeee")
          palauta = ("Doctor:" + fileReader.ask(19) + " " + answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer) + ".")

        } else if (buf(i) == "bad" || buf(i) == "okey" || buf(i) == "angry" || buf(i) == "shy" || buf(i) == "mad" || buf(i) == "disapponted" && buf(i - 1) != "not") {
          palauta = "Dpctor: " + (fileReader.ask(20) + answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer) + " " + fileReader.ask(21) + ".")

        }
      }
      palauta

    } else if (turnCount == 6) {
      "Doctor:" + fileReader.ask(11) + " " + answers.Five + "?"

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
      println("täs b on :" + b)
      for (i <- 0 until yesOrNo.size) {
        while (b == yesOrNo(i)) {
          println("b muuttuu et erisuuri kuin yes" + b)
          b = (i + 1)
        }
      }

      for (i <- 0 until ifIdk.size) {
        while (b == ifIdk(i)) {
          b = (i + 1)
        }
      }

      for (i <- 0 until asks.size) {
        while (b == asks(i)) {
          b = (i + 1)
        }
      }

      println("ei on:" + ifIdk)
      if (b == IsName) {
        b = IsName + 1
      }

      if (b > turnCount - 1) {
        b = turnCount - 1
      }

      if (KotipsykiatriText.commands(turnCount - 1) == "File.txt") {
        SaveData.saving
        "kansioon arkistoitu"
        // println("b" + b)
        //     

        /*
       * kun vastauksena yes tai no, niin silloin vastaus valitaan randomilla parista, että mikä vastaus tulee.
       */
      } else if (changes.yess(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
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
        if (s == 1 || s == 3 || s == 5 || s == 6 || s == 7) {
          if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) { //jos löytyy pilkku TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            //            println("rrrrrrrr")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "."
            } else {
              "Doctor: " + changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "?"
            }
          } else if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) { //jos löytyy ylimääräinen piste TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            //            println("tttttttt")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "."
            } else {
              "Doctor:" + changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "?"
            }
          } else if (answers.ConjunctionB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("yes, 000000000000")
              "Doctor: " + changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + (changes.change(changes.exclamation(answers.Conjunction(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))))) + "."
            } else {
              println("yes2, 0000000000")
              "Doctor:" + changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + (changes.change(changes.exclamation(answers.Conjunction(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))))) + "?"
            }
          } else if (changes.yess(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
            println("ppppp, ei tänne jos ei yes tai no")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."
            } else {
              changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"
            } //täs tokas on ainaki doctor
          } else {
            println("tänne ei pitäs päätyy koskaan")
            ""
          }
        } else if (s == 2 || s == 8) {
          if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) {
            println("TÄÄÄÄÄÄÄKÖ")
            "Doctor: " + fileReader.ask(7) + answers.name + ". " + fileReader.ask(37) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(turnCount - 2))))) + "?"
          } else if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
            println("joujouoo")
            "Doctor: " + fileReader.ask(7) + answers.name + ". " + fileReader.ask(37) + " " + changes.change(changes.exclamation(answers.common(answers.twoPoints(KotipsykiatriText.commands(turnCount - 2)).mkString(" ")))) + "?"
          } else {
            "Doctor: " + fileReader.ask(7) + answers.name + ". " + fileReader.ask(37) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(turnCount - 2).split(" ").toBuffer))) + "?"
          }

        } else {
          if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) { //jos löytyy pilkku
            println("555555")
            "Doctor: " + fileReader.ask(11) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(turnCount - 1))))) + "?"

          } else if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) { //jos löytyy ylimääräinen piste
            "Doctor: " + fileReader.ask(11) + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(turnCount - 1))))) + "?"

          } else {
            println("tää on yes else")
            "Doctor: " + fileReader.ask(11) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer))) + "?"
          }
        }

        //______________________________________________
        /* } else if (m.yess(KotipsykiatriText.commands(b).split(" ").toBuffer)) {
        /* if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 5
         
        }*/

        var s = r.nextInt(8)
        if (s == 1 || s == 3 || s == 5 || s == 7 || s == 8) {
          if (v.commonB(KotipsykiatriText.commands(b))) { //jos löytyy pilkku TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                        println("rrrrrrrr")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriText.commands(b-2))))) + "."
            } else {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriText.commands(b-2))))) + "?"
            }
          } else if (v.twoPointsB(KotipsykiatriText.commands(b))) { //jos löytyy ylimääräinen piste TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                        println("tttttttt")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor: " + m.yes(m.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriText.commands(b-2))))) + "."
            } else {
              "Doctor:" + m.yes(m.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriText.commands(b-2))))) + "?"
            }
          } else if (m.yess(KotipsykiatriText.commands(b).split(" ").toBuffer)) {
            println("ppppp, ei tänne jos ei yes tai no")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              m.yes(m.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."
            } else {
              m.yes(m.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)) + t.ask(numberOfAsk) + " " + m.change(m.exclamation(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"
            } //täs tokas on ainaki doctor
          } else {
            println("tänne ei pitäs päätyy koskaan")
            ""
          }
        } else if (s == 2 || s == 6) {
          if (v.commonB(KotipsykiatriText.commands(b))) {
            println("TÄÄÄÄÄÄÄKÖ")
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriText.commands(b - 2))))) + "?"
          } else if (v.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
            println("joujouoo")
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(v.common(v.twoPoints(KotipsykiatriText.commands(b - 2)).mkString(" ")))) + "?"
          } else {
            "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(KotipsykiatriText.commands(b - 2).split(" ").toBuffer))) + "?"
          }

        } else if(s == 4){
          if (v.commonB(KotipsykiatriText.commands(b))) { //jos löytyy pilkku
            println("555555")
            "Doctor: " + t.ask(11) + " " + m.change(m.exclamation(m.point(v.common(KotipsykiatriText.commands(b - 2))))) + "?"

          } else if (v.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) { //jos löytyy ylimääräinen piste
            "Doctor: " + t.ask(11) + m.change(m.exclamation(m.point(v.twoPoints(KotipsykiatriText.commands(b - 2))))) + "?"

          } else {
            println("tää on yes else")
            "Doctor: " + t.ask(11) + " " + m.change(m.exclamation(m.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer))) + "?"
          }
        } else {  //tää on vaan kokeilu
          println("kuinka usein tänne?")
          "Doctor: " + t.ask(7) + v.name + ". " + t.ask(37) + " " + m.change(m.exclamation(m.point(KotipsykiatriText.commands(b - 2).split(" ").toBuffer))) + "?"
        }*/

        /*
         * katsoo kiroileeko
         */
      } else if (answers.swear(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        "Doctor:" + " Shame your langueage!"

      } else if (answers.sorry(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + "Everything is fine!"

        //-----------------------------------------------------------

        /*
         * katsoo kysyykö nimeä
         */
      } else if (answers.IsItName(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIII
        IsName = b

        answers.WhatIsYourName(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)

        /*
         * kysyy jotain muuta kysymystä, eli jos löytyy kysymysmerkki.
         * Silloin vastauksena: "I don't know but do you know..."
         */
        //--------------------------------------------------------------------
      } else if (changes.??(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIIII
        if (b < 12) {
          b = turnCount - 1
        } else {
          val r = scala.util.Random
          var num = r.nextInt(10)
          b = num + 5
          //println(b)
        }

        asks += turnCount - 1
        println("asks bufferi:" + asks)
        if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) {
          "Doctor:" + "I don't know but " + "what do you think that " + changes.change(changes.point(answers.common(KotipsykiatriText.commands(turnCount - 1)))) + "?"
        } else if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
          var line = Buffer[String]()
          var c = KotipsykiatriText.commands(turnCount - 1)
          var split = c.split('.')
          if (split.size == 2) {
            if (split(0).contains('?')) {
              line += split(0)
            } else {
              line += split(1)
            }
          }
          "Doctor:" + "I don't know but " + "what do you think that " + changes.change(changes.point(line)) + "?"
        } else {
          "Doctor:" + "I don't know but " + "what do you think that " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer))) + "?"
        }

        /*
         * jos käyttäjä käyttää huutomerkkiä.
         * silloin vastauksena: "Why do you yell at me?"
         */
        //--------------------------------------------------------------------------
      } else if (changes.!!(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIIIIIIIII
        "Doctor: " + changes.!(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)

        //_________________________________________________________________________________

        /*
         * Jos käyttäjän lause on "i don't know"
         * sillo
         */
      } else if (answers.idkB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("11111")
            "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(turnCount - 1))))) + "."
          } else {
            println("222222")
            "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(turnCount - 1))))) + "?"
          }
        }
        ifIdk += turnCount - 1
        "Doctor: " + answers.name + ", " + fileReader.ask(5) + " you don't know." + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"

        /*} else if (v.doingB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        println("doing metodi")
        "Doctor: " + t.kysymykset(12) + " " + v.doing(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)*/

        //----------------------------------------------------------------------------------
        /*
         * jos turnCount %6 =0 niin silloin käytetään feel metodia.
         * Jota ennen katotaan mihinkä lauseeseen sitä käytetään jos on monta lausetta
         */
      } else if (turnCount % 4 == 0 && !changes.change(answers.feel2(changes.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)).split(" ").toBuffer).isEmpty()) {

        println("tään on turnCount%6 == 0 ")
        if (answers.commonB(KotipsykiatriText.commands(b))) {
          println("tään on turnCount%6 == 0 ja löytyy pilkku ")
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + ". You think a lot of about " + changes.change(answers.feel2(changes.exclamation(answers.common(KotipsykiatriText.commands(b)))).split(" ").toBuffer) + "."
          } else {
            "Doctor: " + fileReader.ask(39) + " " + changes.change(answers.feel2(changes.exclamation(answers.common(KotipsykiatriText.commands(b)))).split(" ").toBuffer) + "." + fileReader.ask(40)
          }

        } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("turnCount%6, kaks pistettä, 5,7")
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + ". You think a lot of about " + changes.change(answers.feel2(changes.exclamation(answers.twoPoints(KotipsykiatriText.commands(b)))).split(" ").toBuffer) + "."
          } else {
            println("turnCount%6, kaks pistettä")
            "Doctor: " + fileReader.ask(39) + " " + changes.change(answers.feel2(changes.exclamation(answers.twoPoints(KotipsykiatriText.commands(b)))).split(" ").toBuffer) + "." + fileReader.ask(40)
          }
        } else if (answers.ConjunctionB(KotipsykiatriText.commands(b).split(" ").toBuffer)) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("turnCount%6, kaks pistettä, 5,7 0000000000")
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + ". You think a lot of about " + (changes.change(answers.feel2(answers.Conjunction(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))).split(" ").toBuffer)) + "."
          } else {
            println("turnCount%6, kaks pistettä 00000000")
            "Doctor: " + fileReader.ask(39) + " " + (changes.change(answers.feel2(answers.Conjunction(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))).split(" ").toBuffer)) + "." + fileReader.ask(40)
          }

        } else if (numberOfAsk == 5 || numberOfAsk == 7) {
          println("tään on turnCount%6 == 0 ja ei löydy pilkkuu ")
          "Doctor: " + fileReader.ask(numberOfAsk) + ". You think a lot of about " + changes.change(answers.feel2(changes.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)).split(" ").toBuffer) + ". " + fileReader.ask(40)
        } else {
          println("tään on turnCount%6 == 0 ja ei löydy pilkkuu")
          "Doctor: " + fileReader.ask(39) + " " + changes.change(answers.feel2(changes.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)).split(" ").toBuffer) + ". " + fileReader.ask(40)
        }

        //------------------------------------------------------------------------------------
        /*
         * jos turnCount % 7 = 0.
         * Niin käytetään feeling metodia
         * Jota ennen katsotaan jos käyttäjä on laittanut useamman lauseen, että mihin sitä katsotaan.
         * Myös jos lauseen lopussa on piste tai huutomerkki, se otetaan pois.
         */
      } else if (turnCount % 7 == 0) {

        if (!(answers.feeling(KotipsykiatriText.commands(b).split(" ").toBuffer).isEmpty())) { //tähä ei mitään ylimäärästä tai siis pilkku ja piste tänneki!!!!!!!!!!!!!!

          if (answers.commonB(KotipsykiatriText.commands(b))) {
            println("turnCoun%4 ja löyty pilkku") //TOIMIIIIIIIIIIIIIIIIIIIIIII
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              "Doctor:" + fileReader.ask(38) + " " + answers.feeling(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "."
            } else {
              "Doctor:" + fileReader.ask(38) + " " + answers.feeling(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "?"
            }
          } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("turnCount%4 ja löyty kaks pistettä")
              "Doctor: " + fileReader.ask(38) + " " + answers.feeling(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "."
            } else {
              println("turnCount%4 ja löyty kaks pistettä")
              "Doctor: " + fileReader.ask(38) + " " + answers.feeling(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "?"
            }
          } else {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("tään on turnCount%4 == 0 ja löytyyEI pilkku ")
              "Doctor:" + fileReader.ask(37) + " " + answers.feeling(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."

            } else {

              "Doctor:" + fileReader.ask(37) + " " + answers.feeling(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"

            }
          }

        } else { // kun feeling is empty

          if (answers.commonB(KotipsykiatriText.commands(b))) {
            println("turnCount%4 löyty pikku mutta ei ole am tai is")
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("aaaaaaa")
              "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "."
            } else {
              println("bbbbb")
              "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "?"
            }
          } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("cccccccc")
              "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "."
            } else {
              println("ddddddd")
              "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "?"
            }
          } else if (answers.ConjunctionB(KotipsykiatriText.commands(b).split(" ").toBuffer)) {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("cccccccc000000")
              "Doctor: " + fileReader.ask(numberOfAsk) + " " + (changes.change(answers.Conjunction(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))))) + "."
            } else {
              println("ddddddd000000")
              "Doctor: " + fileReader.ask(numberOfAsk) + " " + (changes.change(answers.Conjunction(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))))) + "?"
            }

          } else {
            if (numberOfAsk == 5 || numberOfAsk == 7) {
              println("eeeeeeee")
              "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."
            } else {
              println("fffffff")
              "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"
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
        if (answers.commonB(KotipsykiatriText.commands(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg3")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh3")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "?"
          }
        } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg2")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh2")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "?"
          }
        } else if (answers.ConjunctionB(KotipsykiatriText.commands(b).split(" ").toBuffer)) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg0000000")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + answers.Conjunction(changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))).split("").toBuffer) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh00000000")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + answers.Conjunction(changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))).split("").toBuffer) + "?"
          }

        } else {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("ggggggg")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."
            //  println("muutettu:" + m.change(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))
          } else {
            println("hhhhhhh")
            "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"
          }

        }

        //------------------------------------------------------------------------------------------------------------
        /*
         * jos käyttäjän inputissa esiintyy a tai the
         * käyttäjän inputista otetaan sen jälkeinen sana tai sanat.
         * Sitä ennen poistetaan loppu piste tai huutomerkki.
         * Ja jos inputtina monta sanaa, katsotaan mikä lause otetaan tutkittavaksi.
         */
      } else if (answers.beB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer) && turnCount % 2 == 0) {
        println("olla metodis, alkuja")
        val r = scala.util.Random
        var num = r.nextInt(2)

        if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) {
          if (num == 1) {
            println("iiiiiiii3")
            "Doctor: " + fileReader.ask(35) + " " + answers.be(answers.common(KotipsykiatriText.commands(turnCount - 1))) + "?"
          } else {
            println("jjjjjjjjj3")
            "Doctor: " + fileReader.ask(34) + " " + answers.be(answers.common(KotipsykiatriText.commands(turnCount - 1))) + "?"
          }
        } else if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
          if (num == 1) {
            println("iiiiiiiii2")
            "Doctor: " + fileReader.ask(35) + " " + answers.be(answers.twoPoints(KotipsykiatriText.commands(turnCount - 1))) + "?"
          } else {
            println("jjjjjjjjj2")
            "Doctor: " + fileReader.ask(34) + " " + answers.be(answers.twoPoints(KotipsykiatriText.commands(turnCount - 1))) + "?"
          }
        } else if (answers.ConjunctionB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
          if (num == 1) {
            println("iiiiiiiii000000")
            "Doctor: " + fileReader.ask(35) + " " + answers.Conjunction(answers.be(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer).split("").toBuffer) + "?"
          } else {
            println("jjjjjjjjj000000")
            "Doctor: " + fileReader.ask(34) + " " + answers.Conjunction(answers.be(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer).split("").toBuffer) + "?"
          }
        } else {
          if (num == 1) {
            println("iiiiiii")
            "Doctor: " + fileReader.ask(35) + " " + answers.be(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer) + "?"
          } else {
            println("jjjjj")
            "Doctor: " + fileReader.ask(34) + " " + answers.be(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer) + "?"
          }
        }

      } else if (turnCount % 3 == 0) { //tähän randomilla vähän lisää jos toimii
        val r = scala.util.Random
        var num = r.nextInt(2)
        if (num == 1) {
          if (answers.commonB(KotipsykiatriText.commands(b))) {
            println("tään on lopun elsessä ja löytyy pilkku ")

            println("kkkkk")
            "Doctor:" + fileReader.ask(50) + (changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))).mkString(" ").toLowerCase() + " " + fileReader.ask(51) + ". What do you think about it?"

          } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {

            println("kaks pistettä, 5,712")
            "Doctor: " + fileReader.ask(50) + (changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))).mkString(" ").toLowerCase() + " " + fileReader.ask(51) + ". What do you think about it?"

          } else {
            println("lopun else, ei pilkkua")
            "Doctor:" + fileReader.ask(50) + (changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))).mkString(" ").toLowerCase() + " " + fileReader.ask(51) + ". What do you think about it?"
          }
        } else {
          if (answers.commonB(KotipsykiatriText.commands(b))) {
            println("tään on lopun elsessä ja löytyy pilkku3 ")

            println("kkkkk3")
            "Doctor:" + fileReader.ask(52) + (changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))).mkString(" ").toLowerCase() + ". What do you think about it?"

          } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {

            println("kaks pistettä, 5,73")
            "Doctor: " + fileReader.ask(52) + (changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))).mkString(" ").toLowerCase() + " " + ". What do you think about it?"

          } else {
            println("lopun else, ei pilkkua")
            "Doctor:" + fileReader.ask(52) + (changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))).mkString(" ").toLowerCase() + ". What do you think about it?"
          }
        }

        //------------------------------------------------------------------------------
      } else { //loppu else alkaa tästä
        if (answers.commonB(KotipsykiatriText.commands(b))) {
          println("tään on lopun elsessä ja löytyy pilkku ")
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("kkkkk")
            "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "."
          } else {
            println("llllllll") //    TOIMIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.common(KotipsykiatriText.commands(b))))) + "?"
          }

        } else if (answers.twoPointsB(KotipsykiatriText.commands(b))) {
          if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("kaks pistettä, 5,7")
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "."
          } else {
            println("kaks pistettä" + changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) //TOIMIIIIIIIIIIIIIIIIIIIIIIIIIII  otin tästä pois välilyönnin
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.twoPoints(KotipsykiatriText.commands(b))))) + "?"
          }
          /*} else if(v.ConjunctionB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)){
           if (numberOfAsk == 5 || numberOfAsk == 7) {
            println("kaks pistettä, 5,7, 0000000000")
            "Doctor: " + t.ask(numberOfAsk) + " " +m.change(v.Conjunction(m.exclamation(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))) + "."
          } else {
            println("000000000, kaks pistettä")
            "Doctor: " + t.ask(numberOfAsk) + " " +  m.change(v.Conjunction(m.exclamation(m.point(KotipsykiatriText.commands(b).split(" ").toBuffer)))) + "?"
          }*/
        } else if (numberOfAsk == 5 || numberOfAsk == 7) {
          println("tää on lopun elsessä ja ei löydy pilkkua")
          "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."

        } else {
          println("lopun else, ei pilkkua")
          "Doctor:" + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"
        }
      }

    } else {
      "Doctor: I didn't understand you" 
    }

  }

 // def player = "oma"

}


