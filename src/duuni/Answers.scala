package duuni

//import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader
import Gui._

class Answers {
  
 // var all = Buffer[String]() //tänne kerätään kaikki inputit
 // var nameBuffer = Buffer[String]()
  var feelBuffer = Buffer[String]()
 
   private var changes = new Changes
   private var fileReader = new FileReader

  def bufferiFirst: Buffer[String] = { 
  
    val part = KotipsykiatriText.commands(0).split(" ")
    var answer = Buffer[String]()
    for (i <- 0 until part.size) {
      answer += part(i)
    }
  
    answer
    
  }

  def bufferiSecond: Buffer[String] = { // sit kun kaikki commands saadaan kaikki inputit 0 paikalle ykköset!!!

    val input = KotipsykiatriText.commands(1).split(" ")
    var answer = Buffer[String]()
    for (i <- 0 until input.size) {
      answer += input(i)
    }
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
    if (string.contains("What is your name?") || string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {
      trueFalse
    } else {
      trueFalse = false
    }
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
    if (string.contains("What is your name?") || string.contains("What´s your name?") || string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {
      myName = fileReader.ask(36) + ":)"
    }
    myName
  }

  /*
   * idkB on boolean. Jos inputtina esiintyy i don't know, 
   * silloin metodi palauttaa true.
   */
  def idkB(s: Buffer[String]): Boolean = {
    var trueFalse = true
    var t = changes.point(s)
    if (t(0).toLowerCase() == "i" && t(1) == "don't" && t(2) == "know") {
      trueFalse
    } else {
      trueFalse = false
    }
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
    var line2 = changes.change(line)
    var buffer = line2.split(" ")
    buffer.toBuffer
  }

  def ConjunctionB(b: Buffer[String]): Boolean = {
    var trueFalse = false
    for (i <- b) {
      if (i == "that" || i == "which" || i == "what" || i == "but" || i == "and" || i == "because") {
        trueFalse = true
      }
    }
    trueFalse
  }

  def Conjunction(b: Buffer[String]): Buffer[String] = {
    var line = ""
    var split1 = b.mkString(" ").split("that")
    var split2 = b.mkString(" ").split("which")
    var split3 = b.mkString(" ").split("what")
    var split4 = b.mkString(" ").split("but")
    var split5 = b.mkString(" ").split("and")
    var split6 = b.mkString(" ").split("because")
    if (split1.size == 2) {
      if (split1(0).size >= split1(1).size) {
        line = split1(0)
      } else {
        line = split1(1)
      }
    } else if (split2.size == 2) {
      if (split2(0).size >= split2(1).size) {
        line = split2(0)
      } else {
        line = split2(1)
      }
    } else if (split3.size == 2) {
      if (split3(0).size >= split3(1).size) {
        line = split3(0)
      } else {
        line = split3(1)
      }
    } else if (split3.size == 2) {
      if (split4(0).size >= split4(1).size) {
        line = split4(0)
      } else {
        line = split4(1)
      }
    } else if (split5.size == 2) {
      if (split5(0).size >= split5(1).size) {
        line = split5(0)
      } else {
        line = split5(1)
      }
    } else if (split6.size == 2) {
      if (split6(0).size >= split6(1).size) {
        line = split6(0)
      } else {
        line = split6(1)
      }
    }
    var line2 = line.split(" ").toBuffer
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
    var line2 = (line(0).split(" ").toBuffer)
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
    line = changes.exclamation(changes.point(buf1))

    if (line.size == 1) {
      if (KotipsykiatriText.commands(0) == "Hello" || KotipsykiatriText.commands(0) == "Hi" ||
        KotipsykiatriText.commands(0) == "Hey" || KotipsykiatriText.commands(0) == "hello") {
        nameIs = "anonyme"
      } else {
        nameIs = KotipsykiatriText.commands(0)
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
   // nameBuffer += nameIs
    nameIs
  }

  /*
   * tää on perus metodin alun kolmannelle tohtorin kysymykselle.
   * otetaan huomioon uusimman inputin pisin lause, mutta poistetaan siitä mahdolliset thanks ja thank you kohdat.
   */
  def three = {
    var buffer = KotipsykiatriText.commands(2)
    var word = Buffer[String]() // tähän sana ilman pistettä
    if (this.commonB(buffer)) {
      word = this.common(buffer)
    } else if (this.twoPointsB(buffer)) {
      word = this.twoPoints(buffer)
    } else {
      var buf = KotipsykiatriText.commands(2).split(" ").toBuffer
      word = changes.point(buf)
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
    var lastOne = changes.change(word)
    lastOne
  }
  
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
    var b = changes.point(s)
    b = changes.exclamation(b)
    if (b.size == 1) {
      word += b(0)
    } else if (b.size == 2) {
      word += b(0) + " " + b(1)
    } else if (b.size == 3) {
      if (b(0) == "a" || b(0) == "the" && b(1) == "little" || b(1) == "big" || b(1) == "beatifull" || b(1) == "old" || b(1) == "different") {
        word += b(1) + " " + b(2)
      } else if (b(1) == "a" || b(1) == "the") {
        word += b(2)
      } else {
        word += b(2)
      }

    } else if (b.size == 4) {
      if (b(0) == "a" || b(0) == "the" && b(1) == "little" || b(1) == "big" || b(1) == "beatifull" || b(1) == "old" || b(1) == "different") {
        word += b(1) + " " + b(2)
      } else if (b(1) == "a" || b(1) == "the" && b(2) == "little" || b(2) == "big" || b(2) == "beatifull" || b(2) == "old" || b(2) == "different") {
        word += b(2) + " " + b(3)
      } else if (b(2) == "a" || b(2) == "the") {
        word += b(3)
      } else {
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
          println("i:" + i)
          number = i
        }
        if (b(number + 1) == "little" || b(number + 1) == "big" || b(number + 1) == "beatifull" || b(number + 1) == "old" || b(number + 1) == "different") {
          word += b(number + 1) + " " + b(number + 2)
        } else {
          word += b(number + 1)
        }
      }
    }
    println("(be)sana on:" + word) //tos oli word(0)
    word.last.mkString("")
  }

  /*
   * Five-metodi on perus metodi alussa joka vastaa edellisen inputtiin.
   * Jos edellisessä inputissa on monta lausetta, niistä valitaan pisin.
   * Pisimmän valinta on common ja twoPoints metodeissa.
   */
  def Five = {
    var line = ""
    if (this.commonB(KotipsykiatriText.commands(2))) {// oli 4
      line = changes.change(changes.exclamation(changes.point(this.common(KotipsykiatriText.commands(2)))))
    } else if (this.twoPointsB(KotipsykiatriText.commands(2))) {
      line = changes.change(changes.exclamation(changes.point(this.twoPoints(KotipsykiatriText.commands(2)))))
    } else if (this.ConjunctionB(KotipsykiatriText.commands(2).split(" ").toBuffer)) {
      line = changes.change(changes.exclamation(changes.point(this.Conjunction(KotipsykiatriText.commands(2).split(" ").toBuffer))))
    } else {
      line = changes.change(changes.exclamation(changes.point(KotipsykiatriText.commands(2).split(" ").toBuffer)))
    }
    line
  }

  /*
   * tää metodi poimii jonkun sanan mitä käyttää tulevassa lauseessa
   */
  def feeling(s: Buffer[String]): String = { //heitä tähän jos seuraavana a tai the niin ei sitä!
    var line = Buffer[String]()
    var someWords = Buffer[String]("a", "the")
    if (s.size < 3) {
      for (i <- s) {
        line += i
      }
      line = changes.change(line).split(" ").toBuffer
    } else {
      for (i <- 0 until s.size) {
        if (s(i) == "is" || s(i) == "am") {
          if (s.size - 1 == i) {
            line += "you are"
          } else if (s.size - 1 == (i + 1)) {
            line += "you are " + s(i + 1)
          } else {
            for (u <- 0 until someWords.size) {
              if (s(i + 1) == someWords(u)) {
                return "you are " + s(i + 1) + " " + s(i + 2)
              } else {
                return "you are " + s(i + 1)
              }
            }
          }
        }
      }

    }
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
    line = changes.exclamation(changes.point(b))
    var piece = ""
    if (line.size == 1) {
      piece = line(0)
    } else if(line.size == 2){
      piece = line(0) + " " + line(1)
    } else {
      for (i <- 0 until line.size) {
        if (line(i) == "am" || line(i) == "is" || line(i) == "feel" || line(i) == "feels") {
          if (line(i + 1) == "feeling" || line(i + 1) == "so" || line(i + 1) == "very" || line(i + 1) == "really" || 
              line(i + 1) == "pretty" || line(i + 1) == "little" || line(i + 1) == "not") {
            if (line(i + 2) == "feeling" || line(i + 2) == "so" || line(i + 2) == "very" || line(i + 2) == "really" || 
                line(i + 2) == "pretty" || line(i + 2) == "little" || line(i + 2) == "not") {
              piece = line(i + 1) + " " + line(i + 2) + " " + line(i + 3)
            } else {
              piece = line(i + 1) + " " + line(i + 2)
            }
          } else {
            piece = line(i + 1)
          }
        } else {
          piece == "insensitive"
        }
      }
    }
    feelBuffer += piece
    piece
  }

  def feel2(b: Buffer[String]): String = { //toimi ainakin kerran!
    var finalString: String = ""
    var line = Buffer[String]()
    var words = Buffer[String]("very", "really", "so", "little", "not", "like")
    line = changes.exclamation(changes.point(b))
    var number: Int = 0
    for (i <- 0 until line.size) {
      if (line(i) == "feel" || line(i) == "feels") {
        if (line.size - 1 == i) {
          finalString = line(i)
        } else if (line.size - 1 == (i + 1)) {
          finalString = line(i + 1)
        } else {
          for (u <- 0 until words.size) {
            if (line(i + 1) == words(u)) {
              return line(i + 1) + " " + line(i + 2)
            } else {
              return line(i + 1)
            }
          }
        }
      }
    }
    this.feelBuffer += finalString
    finalString
  }

  /*
   * jos kiroilee
   */
  def swear(b: Buffer[String]): Boolean = {
    var trueFalse = false
    for (i <- 0 until b.size) {
      var lower = b(i).toLowerCase()
      if (lower == "fuck" || lower == "fucking" || lower == "shit" || lower == "asshole" ||
        lower == "bitch" || lower == "hell" || lower == "crap") {
        trueFalse = true
      }
    }
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
