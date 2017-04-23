package duuni

//import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader
import Gui._

class vastaukset {
  //  println("uusi vastaukset")
  var all = Buffer[String]() //tänne kerätään kaikki inputit
  var nameBuffer = Buffer[String]()
  var feelBuffer = Buffer[String]()
  // var t = new tiedosto
  var m = new muutokset
  var t = new tiedosto

  def bufferiFirst: Buffer[String] = { //
    // bufferKaikki
    val part = KotipsykiatriGui.bufferiin(0).split(" ")
    var answer = Buffer[String]()
    for (i <- 0 until part.size) {
      answer += part(i)
    }
    // println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size)
    answer
    //part
  }

  def bufferiSecond: Buffer[String] = { // sit kun kaikki bufferiin saadaan kaikki inputit 0 paikalle ykköset!!!

    val input = KotipsykiatriGui.bufferiin(1).split(" ")
    //kaikki += inputti(0)
    var answer = Buffer[String]()
    for (i <- 0 until input.size) {
      answer += input(i)
    }
    //  println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size + "tää on tokaan")
    answer
  }

  /*
   * tämä metodi on WhatIsMyName metodille boolean.
   * kun kysymys esimerkiksi: "What is your name?"
   * esiintyy inputissa, silloin metodi palauttaa true.
   */
  def IsItName(all: Buffer[String]): Boolean = {
    var trueFalse = true
    var string = all.mkString(" ")
    println("all:" + all)
    if (string.contains("What is your name?") || string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {
      trueFalse
    } else {
      trueFalse = false
    }
    println(trueFalse)
    trueFalse
  }

  /*
   * WhatIsMyName -metodi vastaa jos inputissa esiintyy vaikka:
   * What is your name? Ja tällöin antaa siihen vastauksena:
   *  I am just a doctor for you.
   */
  def WhatIsYourName(all: Buffer[String]): String = {
    var myName = ""
    var string = all.mkString(" ")
    println("all:" + all)
    if (string.contains("What is your name?") || string.contains("What´s your name?") || string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {

      myName = t.ask(36) + ":)"
    }
    myName
  }

  /*
   * idkB on boolean. Jos inputtina esiintyy i don't know, 
   * silloin metodi palauttaa true.
   */
  def idkB(s: Buffer[String]): Boolean = {
    var trueFalse = true
    var t = m.point(s)
    if (t(0).toLowerCase() == "i" && t(1) == "don't" && t(2) == "know") {
      trueFalse
    } else {
      trueFalse = false
    }
    println("idk: " + trueFalse)
    trueFalse
  }

  /*
   * commonB on common -metodille Boolean metodi.
   * katsoo jos splitataan pilkulla,
   * niin jos lauseessa on pilkku niin silloin kooksi tulee kaksi.
   * ja silloi Boolean antaa vastaukseksi true.
   */
  def commonB(b: String): Boolean = {
    var trueFalse = true
    var line = Buffer[String]()
    var split = b.split(", ")
    if (split.size == 2) {
      trueFalse

    } else {
      trueFalse = false
    }
    trueFalse
  }
  /*
 * jos on pilkku mukana lauseessa, 
 * common metodi katsoo pidemmän lauseen ja käyttää sitä 
 */
  def common(b: String): Buffer[String] = {
    var line = Buffer[String]()
    var split = b.split(", ")
    if (split.size == 2) {
      if (split(0).size > split(1).size) {
        line += split(0)
      } else {
        line += split(1)
      }
    }
    println("common line: " + line)
    var line2 = m.change(line)
    var buffer = line2.split(" ")
    buffer.toBuffer
  }
  
  def ConjunctionB(b: Buffer[String]):Boolean = {
    var trueFalse = false
    for(i <- b){
      if(i == "that" || i == "which" || i == "what"){
        trueFalse = true
      }
    }
    trueFalse
  }
  
  def Conjunction(b: Buffer[String]):String = {
     var line = ""
     var split1 = b.mkString("").split("that")
      var split2 = b.mkString("").split("which")
       var split3 = b.mkString("").split("what")
     if(split1.size == 2){
       if(split1(0).size >  split1(1).size){
        line += split1(0)
       } else {
        line += split1(1)
       }
     } else if(split2.size == 2){
       if(split2(0).size >  split2(1).size){
        line += split2(0)
       } else {
        line += split2(1)
       }
     } else{
       if(split3(0).size >  split3(1).size){
        line += split3(0)
       } else {
        line += split3(1)
       }
     }
    // println(" tää on conjuktio:"+ line.split(" ").toBuffer )
      var line2 = line.mkString("")
     println("twoPoints tä tää konjuktio: " + line2)
   line2
  }
  

  /*
   * tää on boolen metodi twoPoints metodille.
   * siinä splitataan '.' ja jos silloin koko on suurempi kuin 2, siinä on turha piste.
   */
  def twoPointsB(b: String): Boolean = {
    var trueFalse = true
    var line = Buffer[String]()

    var split = b.split('.')
    println("split size:" + split.size)
    if (split.size >= 2) {
      trueFalse

    } else {
      trueFalse = false
    }
    println("two points:" + trueFalse)
    trueFalse
  }

  /*
   * twoPoints metodi tsekkaa jos on monta lausetta inputissa. 
   * ja käyttää niistä sitä lausetta, jossa on eniten sanoja.
   */
  def twoPoints(b: String): Buffer[String] = {
    var line = Buffer[String]()
    var split = b.split('.')
    if (split.size == 2) {
      if (split(0).size > split(1).size) {
        line += split(0)
      } else {
        line += split(1)
      }
    } else if (split.size == 3) {
      if (split(0).size > split(1).size && split(0).size > split(2).size) {
        line += split(0)
      } else if (split(1).size > split(2).size && split(1).size > split(0).size) {
        line += split(1)
      } else {
        line += split(2)
      }
    }
    println("common line: " + line)
    var line2 = (line(0).split(" ").toBuffer)
     println("twoPoints tä tää line2: " + line2)
   line2
  }
  /*
 * this long method is taking the name off the line.
 * the first thig what this do, take of the end point if the line have point.
 * then it check that "hello"... is not the name
 * then its check what is size of the line just in case and take the name off.
 * the name method take just the first name if there is more names.
 */
  def name = {
    //println("montako kertaa name metodiin")
    var nameIs = "anonyme"
    val buf1 = this.bufferiFirst
    var line = Buffer[String]()
    line = m.exclamation(m.point(buf1))

    if (line.size == 1) {
      if (KotipsykiatriGui.bufferiin(0) == "Hello" || KotipsykiatriGui.bufferiin(0) == "Hi" ||
        KotipsykiatriGui.bufferiin(0) == "Hey" || KotipsykiatriGui.bufferiin(0) == "hello") {
        nameIs = "anonyme"
      } else {
        nameIs = KotipsykiatriGui.bufferiin(0)
      }
    } else if (line.size == 2) {
      if (line(0) == "it´s") {
        nameIs = line(1)
      } else if (line(0) == "It´s") {
        nameIs = line(1)
      }

    } else if (line.size == 3) {
      if (line(1) == "it´s") {
        nameIs = line(2)
      } else if (line(1) == "is") {
        nameIs = line(2)
      } else if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(1) == "i'm") {
        nameIs = line(2)
      } else if (line(1) == "I'm") {
        nameIs = line(2)
      } else if (line(0) == "It's") {
        nameIs = line(1)
      } else if (line(1) == "it's") {
        nameIs = line(2)
      } else if (line(1) == "i'm") {
        nameIs = line(2)
      }

    } else if (line.size == 4) {
      if (line(2) == "is") {
        nameIs = line(3)
      } else if (line(2) == "am") {
        nameIs = line(3)
      } else if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(2) == "is") {
        nameIs = line(3)
      }

    } else if (line.size == 5) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(2) == "am") {
        nameIs = line(3)
      } else if (line(2) == "is") {
        nameIs = line(3)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }

    } else if (line.size == 6) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(2) == "am") {
        nameIs = line(3)
      } else if (line(2) == "is") {
        nameIs = line(3)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }
    } else if (line.size == 7) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(2) == "am") {
        nameIs = line(3)
      } else if (line(2) == "is") {
        nameIs = line(3)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }
    } else if (line.size == 8) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(2) == "am") {
        nameIs = line(3)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }

    } else {
      nameIs = "anonyme"
    }
    nameBuffer += nameIs

    nameIs
  }

  /*
   * tää on perus metodin alun kolmannelle tohtorin kysymykselle.
   * otetaan huomioon uusimman inputin pisin lause, mutta poistetaan siitä mahdolliset thanks ja thank you kohdat.
   */
  def three = {
    var buffer = KotipsykiatriGui.bufferiin(2)
    var word = Buffer[String]() // tähän sana ilman pistettä
    if (this.commonB(buffer)) {
      word = this.common(buffer)
    } else if (this.twoPointsB(buffer)) {
      word = this.twoPoints(buffer)
    } else {
      var buf = KotipsykiatriGui.bufferiin(2).split(" ").toBuffer
      word = m.point(buf)
    }
    if (word.size == 4) {
      if (word(3) == "thanks") {
        word = word.take(3)
      }
    } else if (word.size == 5) {
      if (word(3) == "thank" && word(4) == "you") {
        word = word.take(3)
      } else if (word(4) == "thanks") {
        word = word.take(4)
      }

    } else if (word.size == 6) {
      if (word(4) == "thank" && word(5) == "you") {
        word = word.take(4)
      }
    }
    var lastOne = m.change(word)
    //println(jee)
    lastOne
  }

  /*def doingB(b: Buffer[String]): Boolean = { //tää ei oo kauheen hyvä
    var trueFalse = true

    for (i <- 0 until b.size) {
      if (b(i) == "doing" || b(i) == "going") {
        trueFalse
      } else {
        trueFalse = false
      }
    }
    trueFalse
  }

  def doing(b: Buffer[String]): String = { //tää ei oo kauheen hyvä
    var line = Buffer[String]()
    for (i <- 0 until b.size) {
      if (b(i) == "doing" || b(i) == "going") {
        if (!b(i + 2).isEmpty()) {
          line += b(i + 2)
        }
      }
    }
    line.mkString(" ")
  }*/

  /*
   * tää on be- metodille booleaan.
   */
  def beB(b: Buffer[String]): Boolean = {
    var trueFalse = false
    for (i <- 0 until b.size) {
      if (b(i) == "a" || b(i) == "the") {
        trueFalse = true

      }
    }
    println("(olla)totta on: " + trueFalse)
    trueFalse
  }

  /*
   * be- metodi katkaisee lauseen a tai the kohdalta ja käyttää niitten jälkeistä sanaa
   * pienellä ehdoilla, jos joku yleinen adjektiivi a tai the perässä, se tulee mukaan myös.
   * Jos inputissa ei esinny a tai the sanaa, käytetään koko inputtia.
   */
  def be(s: Buffer[String]): String = { //tätä voi suurentaa jos ehtii
    var word = Buffer[String]()
    var b = m.point(s)
    b = m.exclamation(b)
    if (b.size == 1) {
      word += b(0)
    } else if (b.size == 2) {
      word += b(0) + " " + b(1)
    } else if (b.size == 3) {
      if (b(0) == "a" || b(0) == "the" && b(1) == "little" || b(1) == "big" || b(1) == "beatifull" || b(1) == "old" || b(1) == "different") {
        word += b(1) + " " + b(2)
      } else if (b(1) == "a" || b(1) == "the") {
        word += b(2)
      } else{
         word += b(2)
      }
      
    } else if (b.size == 4) {
      if (b(0) == "a" || b(0) == "the" && b(1) == "little" || b(1) == "big" || b(1) == "beatifull" || b(1) == "old" || b(1) == "different") {
        word += b(1) + " " + b(2)
      } else if (b(1) == "a" || b(1) == "the" && b(2) == "little" || b(2) == "big" || b(2) == "beatifull" || b(2) == "old" || b(2) == "different") {
        word += b(2) + " " + b(3)
      } else if (b(2) == "a" || b(2) == "the") {
        word += b(3)
      }else {
         word += b(3)
      }
      
    } else if (b.size == 5) {
      if (b(2) == "a" || b(2) == "the" && b(3) == "little" || b(3) == "big" || b(3) == "beatifull" || b(3) == "old" || b(3) == "different") {
        word += b(3) + " " + b(4)
      } else if (b(2) == "a" || b(2) == "the") {
        word += b(3)
      } else {
        word += b(4)
      }
    } else {
      var number = 0
      for (i <- 0 until b.size) {
        if (b(i) == "a" || b(i) == "the") {
          number = i
        }
        if (b(number + 1) == "little" || b(number + 1) == "big" || b(number + 1) == "beatifull" || b(number + 1) == "old" || b(number + 1) == "different") {
          word += b(number + 1) + " " + b(number + 2)
        } else {
          word += b(number + 1)
        }

      }

    }

    println("(be)sana on:" + word)
    word(0).mkString("")
  }

  /*
   * Five-metodi on perus metodi alussa joka vastaa edellisen inputtiin.
   * Jos edellisessä inputissa on monta lausetta, niistä valitaan pisin.
   * Pisimmän valinta on common ja twoPoints metodeissa.
   */
  def Five = {
    var line = ""

    if (this.commonB(KotipsykiatriGui.bufferiin(4))) {
      line = m.change(m.exclamation(m.point(this.common(KotipsykiatriGui.bufferiin(4)))))
    } else if (this.twoPointsB(KotipsykiatriGui.bufferiin(4))) {
      line = m.change(m.exclamation(m.point(this.twoPoints(KotipsykiatriGui.bufferiin(4)))))
    } else {
      line = m.change(m.exclamation(m.point(KotipsykiatriGui.bufferiin(4).split(" ").toBuffer)))
    }
    line
  }

  /*
   * tää metodi poimii jonkun sanan mitä käyttää tulevassa lauseessa
   */
  def feeling(s: Buffer[String]): String = { //heitä tähän jos seuraavana a tai the niin ei sitä!

    var line = Buffer[String]()

    if (s.size < 3) {
      for (i <- s) {
        line += i
      }
    }
    if (s.size == 3) {
      if (s(1) == "is" || s(1) == "am")
        line += "you are " + s.last
    }
    if (s.size == 4) {
      if (s(1) == "is" || s(1) == "am") {
        line += "you are " + s(3)
      }
    }
    if (s.size >= 5) {
      for (i <- 0 until s.size) {
        if (s(i) == "am" || s(i) == "is") {
          line += "you are " + s(i + 1)
        }

      }
    }
    println("line feeling metodiin" + line)
    line.mkString(" ")

  }

  /*
   * this take the feel from the line.
   * check size of the line just in case.
   * and return "feeling"-verb, and the whole feeling 
   * what is reason that this is so long!
   */
  def feel(b: Buffer[String]): String = {

    var line = Buffer[String]()

    line = m.exclamation(m.point(b))

    var piece = ""
    if (line.size == 1) {
      piece = line(0)
    } else if (line.size == 2) {
      var lineNol = line(0).toLowerCase()
      if (lineNol == "very" || lineNol == "really" || lineNol == "so" ||
        lineNol == "pretty" || lineNol == "little" || lineNol == "not") {
        piece = lineNol + " " + line(1)
      } else {
        for (i <- line.mkString(" ")) {
          piece += i
        }
      }

    } else if (line.size == 3) {
      if (line(1) == "am") {
        piece = line(2)
      } else if (line(1) == "feel") {
        println("tänne")
        piece = line(2)
      } else {
        println("ei tänne")
        for (i <- line.mkString(" ")) {
          piece += i
        }
      }
    } else if (line.size == 4) {
      if (line(1) == "am" && (line(2) == "very" || line(2) == "really" || line(2) == "so" || line(2) == "not") ||
        line(2) == "pretty" || line(2) == "little") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "feel" && (line(2) == "very" || line(2) == "really" ||
        line(2) == "so" || line(2) == "pretty" || line(2) == "little" || line(2) == "not")) {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "a" || line(2) == "the") {
        piece = line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else if (line(2) == "am") {
        piece = line(3)
      } else if (line(1) == "feel") {
        piece = line(2)
      } else {
        for (i <- line.mkString(" ")) {
          piece += i
        }
      }
    } else if (line.size == 5) {
      if (line(1) == "am" && (line(2) == "very" || line(2) == "pretty" || line(2) == "little" ||
        line(2) == "really" | line(2) == "so" || line(2) == "not")) {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" ||
        line(3) == "really" || line(3) == "so" || line(3) == "pretty" || line(3) == "little" || line(3) == "not")) {
        piece = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else if (line(2) == "am") {
        piece = line(3)
      } else if (line(2) == "am" && line(3) == "feeling") {
        piece = line(3) + " " + line(4)
      } else {
        for (i <- line.mkString(" ")) {
          piece += i
        }
      }
    } else if (line.size == 6) {
      if (line(1) == "am" && line(2) == "very" || line(2) == "pretty" || line(2) == "little" ||
        line(2) == "really" | line(2) == "so" || line(2) == "not") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so" || line(3) == "little" || line(3) == "not")) {
        piece = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else {
        for (i <- line.mkString(" ")) {
          piece += i
        }
      }
    } else if (line.size == 7) {
      if (line(1) == "am" && line(2) == "very" || line(2) == "pretty" || line(2) == "little" ||
        line(2) == "really" | line(2) == "so" || line(2) == "not") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so" || line(3) == "little" || line(3) == "not")) {
        piece = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else {
        for (i <- line.mkString(" ")) {
          piece += i
        }
      }
    } else {
      for (i <- line.mkString(" ")) {
        piece += i
      }
    }
    this.feelBuffer += piece
    piece
  }

  /*
   * jos kiroilee
   */
  def swear(b: Buffer[String]): Boolean = {
    var trueFalse = false
    for (i <- 0 until b.size) {
      var lower = b(i).toLowerCase()
      if (lower == "fuck") {
        trueFalse = true
      }
    }
    println("kiroili on:" + trueFalse)
    trueFalse
  }

  /*
   * jos pyytää anteeksi
   */
  def sorry(b: Buffer[String]): Boolean = {
    var trueFalse = false
    for (i <- 0 until b.size) {
      var lower = b(i).toLowerCase()
      if (lower == "sorry") {
        trueFalse = true
      }
    }
    trueFalse
  }

}
