package work
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
  private var b = 6
  private var numberOfAsk = 8
  /*
   * jos esiintyy "yes" tai "no", puheessa, random hyppää b niiden yli.
   */
  private var yesOrNo = Buffer[Int]()
  private var IsName = 0
  /*
   * jos esiintyy "I don't know" niin sitä ei käytetä enää tohtorin puheissa
   */
  private var ifIdk = Buffer[Int]()
  private var asks = Buffer[Int]()
  private var fileSaved = 0

  def playTurn(command: String): String = {
    /*
 * turnCount kertoo monesko "kysymys" on menossa
 */
    this.turnCount += 1

    /*
     * kun turnCount on 1, silloin playTurn metodi kutsuu name metodia
     * ja liittää sen tekstiin, jos ei haluta tallentaa jo tässä välissä.
     */
    if (turnCount == 1) {
      if (KotipsykiatriText.commands(turnCount - 1) == "File.txt") {
        SaveData.saving
        fileSaved = turnCount
        "Save is complete"
      } else {
        "Doctor:" + fileReader.ask(2) + answers.name + "! " + fileReader.ask(31) + "?"
      }
      /*
       * jos on piste niin ottaa ensimmäisen lauseen,
       * muuten käyttää feel metodii, jolla selvitetään käyttäjän tunnetila.
       */
    } else if (turnCount == 2) {
      if (KotipsykiatriText.commands(turnCount - 1) == "File.txt") {
        fileSaved = turnCount
        SaveData.saving
        "Save is complete"

        /*
         * jos löytyy kaks pistettä, poistetaan lopun piste.
         * splitataan pisteen pohdalta ja valitaan ensimmäinen lause.
         */
      } else if (answers.twoPointsB(KotipsykiatriText.commands(turnCount - 1))) {
        //katsotaan että feel kuuluu oikealle puolelle lauseita
        var endPointOff = changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer).mkString(" ")
        var line = Buffer[String]()
        var split = endPointOff.split('.')
        if (split.size == 2) {
          line += split(0)
        }
        var finalBuffer = line(0).split(" ").toBuffer

        "Doctor:" + fileReader.ask(5) + "." + fileReader.ask(32) + answers.feel(finalBuffer) + "?"
      } else {
        "Doctor:" + fileReader.ask(5) + "." + fileReader.ask(32) + answers.feel(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + "?"
      }

      /*
       * kun turnCount on 3, jos haluaa tallentaa tai sitten katsotaan tokan kysymyksen vastauksen pohjalta
       * onko käyttäjän tunnetila hyvä, huono, vai ei selvillä. Jos hyvä olo vastaa: "I am happy to hear that you are" ja jos huono: 
       * "I hope you have better day tomorrow and you are not "..
       */
    } else if (turnCount == 3) {
      if (KotipsykiatriText.commands(turnCount - 1) == "File.txt") {
        SaveData.saving
        "Save is complete"
      } else {
        var five = answers.Five

        var palauta = "Doctor:" + fileReader.ask(9) + " " + five + ", " + answers.name + ". "
        for (i <- 0 until answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer).split(" ").size) {
          var buf = answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer).split(" ")

          if (buf(i) == "fine" || buf(i) == "good" || buf(i) == "well" || buf(i) == "great" || buf(i) == "awesome" || buf(i) == "grateful" ||
            buf(i) == "happy" || buf(i) == "proud") {
            palauta = ("Doctor:" + fileReader.ask(19) + " " + answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer) + ".")

          } else if (buf(i) == "bad" || buf(i) == "sad" || buf(i) == "okey" || buf(i) == "angry" || buf(i) == "shy" || buf(i) == "mad" || buf(i) == "disapponted" && buf(i - 1) != "not") {
            palauta = "Dpctor: " + (fileReader.ask(20) + answers.feel(KotipsykiatriText.commands(1).split(" ").toBuffer) + " " + fileReader.ask(21) + ".")
          }
        }
        palauta
      }

    } else { //tästä lähtee kaikkien loppujen kysymyksien ehtoja:

      /*katsoo että kysymysten alut ovat tekstissä indekseissä välillä 2-12
 			* jos 12 niin silloin hyppää kakkoseen ja muuten randomilla valitaan alku
 			*/
      if (numberOfAsk == 15) {
        numberOfAsk = 5
      } else {
        var r = scala.util.Random
        var random = r.nextInt(11)
        numberOfAsk = random + 5
      }

      /*
       * valitaan randomilla mistä inputista tohtori keskustelee seuraavaksi
       */
      val r = scala.util.Random
      var num = r.nextInt(13)
      if (num == 1 || num == 5 || num == 6 || num == 4 || num == 8) {
        b += 1
      } else if (num == 2 || num == 9) {
        b += 2
      } else if (num == 3 || num == 7) {
        b -= 1
      } else {
        b = b

      }

      /*
       * tällä karkoitetaan ettei kysymyksistä tulisi outoja ja skipataa seuraavia asioita:
       */
      for (i <- 0 until yesOrNo.size) { //"yes" tai "no" vastauksia
        while (b == yesOrNo(i)) {
          b = (i + 1)
        }
      }

      for (i <- 0 until ifIdk.size) { //" i don't know" vastauksia
        while (b == ifIdk(i)) {
          b = (i + 1)
        }
      }

      if (fileSaved == b) { //kun tallennetaan tiedostoon
        b = b + 1
      }

      for (i <- 0 until asks.size) { //käyttäjän käyttämiä kysymyksiä
        while (b == asks(i)) {
          b = (i + 1)
        }
      }

      if (b == IsName) { //nimen kysymistä
        b = IsName + 1
      }

      /*
       * tää katsoo, että b eli randomilla valittu käyttäjän kommentti ei ole yli kaikkien määrää
       */
      if (b > turnCount - 1) {
        b = turnCount - 1
      }

      /*
       * jos kirjoitetaan "File.txt" tallennetaan data File.txt kansioon.
       */
      if (KotipsykiatriText.commands(turnCount - 1) == "File.txt") {
        SaveData.saving
        fileSaved = turnCount
        "Save is complete"

        /*
       * kun vastauksena yes tai no, niin silloin vastaus valitaan randomilla parista, että mikä vastaus tulee.
       */
      } else if (changes.yess(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        yesOrNo += turnCount - 1 // tää lisää turnCount -1 yesOrNo bufferiin jotta sitä vastausta ei käytettäis enää.
        var s = r.nextInt(8) //valitaan randomilla kolmesta eri vaihtoehdosta
        if (s == 1 || s == 3 || s == 5 || s == 6 || s == 7) {

          if (numberOfAsk == 5 || numberOfAsk == 7) { //jos 5 tai 7 kysymys, silloin "." muuten "?"
            changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + " " +
              changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "."
          } else {
            changes.yes(changes.exclamation(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) + fileReader.ask(numberOfAsk) + " " +
              changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "?"
          }
          //randomilla valitut toiset vaihtoehdot
        } else if (s == 2 || s == 8) {
          "Doctor: " + fileReader.ask(7) + answers.name + ". " + fileReader.ask(37) + " " +
            changes.change(changes.exclamation(answers.Conjunction(answers.common(answers.twoPoints(KotipsykiatriText.commands(b)).mkString(" "))))) + "?"
        } else {
          "Doctor: " + fileReader.ask(11) + " " + changes.change(changes.exclamation(answers.Conjunction(answers.common(answers.twoPoints(KotipsykiatriText.commands(b)).mkString(" "))))) + "?"
        }

        /*
         * katsoo kiroileeko ja palauttaa "Shame your language!"
         */
      } else if (answers.swear(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + " Shame your langueage!"

        /*
         * katsoo jos pyytää anteeksi niin vastaa "Everything is fine!"
         */
      } else if (answers.sorry(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + "Everything is fine!"

        /*
         * katsoo kysyykö nimeä ja vastaa: I am just a doctor for you :)
         */
      } else if (answers.IsItName(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIII
        IsName = b
        answers.WhatIsYourName(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)

        /*
         * kysyy jotain muuta kysymystä, eli jos löytyy kysymysmerkki.
         * Silloin vastauksena: "I don't know but do you know..."
         * katsoo jos monta lausetta, että kysymys on oikeassa lauseessa
         */
        //--------------------------------------------------------------------
      } else if (changes.??(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) { //TOIMIIIIIIIIIIIIIIIIIII
      
        asks += turnCount - 1 //tää katsoo, ettei b käytä enää (turnCount -1) arvoa
        if (answers.commonB(KotipsykiatriText.commands(turnCount - 1))) {
          "Doctor: " + "I don't know but " + "what do you think that " + changes.change(changes.point(answers.common(KotipsykiatriText.commands(turnCount - 1)))) + "?"
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
          "Doctor: " + "I don't know but " + "what do you think that " + changes.change(changes.point(line)) + "?"
        } else {
          "Doctor: " + "I don't know but " + "what do you think that " + changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer))) + "?"
        }

        /*
         * jos käyttäjä käyttää huutomerkkiä.
         * silloin vastauksena: "Why do you yell at me?"
         */
      } else if (changes.!!(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {
        "Doctor: " + changes.!(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)

        /*
         * Jos käyttäjän lause on "i don't know"
         * sillo vastaa: " I understand that you don't know"...
         */
      } else if (answers.idkB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer)) {

        ifIdk += turnCount - 1
        if (numberOfAsk == 5 || numberOfAsk == 7) {
          "Doctor: " + answers.name + ", " + fileReader.ask(5) + " you don't know." + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "?"
        } else {
          "Doctor: " + answers.name + ", " + fileReader.ask(5) + " you don't know." + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "?"
        }

        /*
         * jos turnCount %4 =0 ja feel metodi palauttaa jotain,
         * silloin käytetään tätä. jos numberOfAsk on 7 ati 5, niin silloin loppuun ".", muuten"?"
         */
      } else if (turnCount % 4 == 0 && !changes.change(answers.feel2(changes.exclamation(KotipsykiatriText.commands(b).split(" ").toBuffer)).split(" ").toBuffer).isEmpty()) {

        if (numberOfAsk == 5 || numberOfAsk == 7) {
          "Doctor: " + fileReader.ask(numberOfAsk) + " " + answers.name + ". You think a lot of about " + changes.change(answers.feel2(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))).split(" ").toBuffer) + "." + fileReader.ask(40)
        } else {
          "Doctor: " + fileReader.ask(39) + " " + changes.change(answers.feel2(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))).split(" ").toBuffer) + ". " + fileReader.ask(40)
        }

        /*
         * jos turnCount % 7 = 0.
         * Niin käytetään feeling metodia
         * Jota ennen katsotaan jos käyttäjä on laittanut useamman lauseen, että mihin sitä katsotaan.
         * Myös jos lauseen lopussa on piste tai huutomerkki, se otetaan pois.
         */
      } else if (turnCount % 7 == 0) {
        if (!(answers.feeling(KotipsykiatriText.commands(b).split(" ").toBuffer).isEmpty())) { //tähä ei mitään ylimäärästä tai siis pilkku ja piste tänneki!!!!!!!!!!!!!!

          if (numberOfAsk == 5 || numberOfAsk == 7) {
            "Doctor: " + fileReader.ask(37) + " " + answers.feeling(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "."
          } else {
            "Doctor: " + fileReader.ask(37) + " " + answers.feeling(changes.exclamation(changes.point(KotipsykiatriText.commands(b).split(" ").toBuffer))) + "?"
          }

        } else { // kun feeling is empty

          if (numberOfAsk == 5 || numberOfAsk == 7) {
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "."
          } else {
            "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "?"
          }
        }

        /*
         * Kun turnCount % 5 = 0.
         * Silloin lisänä tulee käyttäjän nimi alkuun.
         * muuten normaalisti käyttäen inputtia poistetaan piste tai huutomerkki lopusta jos on.
         * ja muutetaan input change metodin avulla järkeväksi ja jos on monta lauseetta, valitaan pisin lause.
         */
      } else if (turnCount % 5 == 0) {
        if (numberOfAsk == 5 || numberOfAsk == 7) {
          "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " +
            changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "."
        } else {
          "Doctor: " + answers.name + ", " + fileReader.ask(numberOfAsk) + " " +
            changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "?"
        }

        //------------------------------------------------------------------------------------------------------------
        /*
         * jos käyttäjän inputissa esiintyy a tai the
         * käyttäjän inputista otetaan sen jälkeinen sana tai sanat.
         * Sitä ennen poistetaan loppu piste tai huutomerkki.
         * randomilla valitaan kahdesta vaihtoehdosta.
         */
      } else if (answers.beB(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer) && turnCount % 2 == 0) {
        val r = scala.util.Random
        var num = r.nextInt(2)

        if (num == 1) {
          "Doctor: " + fileReader.ask(35) + " " + answers.be(changes.exclamation(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer))) + "?"
        } else {
          "Doctor: " + fileReader.ask(34) + " " + answers.be(changes.exclamation(changes.point(KotipsykiatriText.commands(turnCount - 1).split(" ").toBuffer))) + "?"
        }

        /*
         * randomilla valitaan kahdesta tarinan alusta kumpaa käytetään:
         * "When I was kid", jolloin verbit muutetaan imperfektiksi ja 
         * "If I think my future", joilloin imperfektit muutetaan preesenssiin
         */
      } else if (turnCount % 4 == 0) {
        val r = scala.util.Random
        var num = r.nextInt(2)
        if (num == 1) {
          "Doctor: " + fileReader.ask(51) + changes.imp(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + " " + fileReader.ask(52) + ". What do you think about it?"
        } else {
          "Doctor: " + fileReader.ask(53) + changes.pre(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + ". What do you think about it?"
        }

        /*
         * jos ei mikään edellistä tullut valituksi
         * tämä käyttää randomilla valittua käyttäjän vastausta ja 
         * tekee siitä uuden kysymyksen
         */
      } else { //loppu else alkaa tästä
        if (numberOfAsk == 5 || numberOfAsk == 7) {
          "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "."
        } else {
          "Doctor: " + fileReader.ask(numberOfAsk) + " " + changes.change(changes.exclamation(changes.point(answers.Conjunction(answers.twoPoints(answers.common(KotipsykiatriText.commands(b)).mkString(" ")))))) + "?"
        }

      }
    }
  }
}


