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

  def WhatIsYourName(all: Buffer[String]): String = {
    var myName = ""
    var string = all.mkString(" ")
    println("all:" + all)
    if (string.contains("What is your name?") || string.contains("What´s your name?") || string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {

      myName = t.ask(36) + ":)"
    }
    myName
  }

  def idkB(s: Buffer[String]): Boolean = {
    var trueFalse = true
    var t = m.point(s)
    if (t(0) == "i" && t(1) == "don't" && t(2) == "know") {
      trueFalse
    } else {
      trueFalse = false
    }
    println("idk: " + trueFalse)
    trueFalse
  }

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
    line = m.point(buf1)

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
      } else if (line(1) == "I'm") { //kysy iskältä kumpi '
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
      }

    } else if (line.size == 5) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(2) == "am") {
        nameIs = line(3)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }

    } else if (line.size == 6) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }
    } else if (line.size == 7) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }
    } else if (line.size == 8) {
      if (line(1) == "am") {
        nameIs = line(2)
      } else if (line(3) == "is") {
        nameIs = line(4)
      }

    } else {
      nameIs = "anonyme"
    }
    nameBuffer += nameIs
    //lisätään nameBufferiin, että sitä voidaan sieltä käyttää myöhemmissä vaiheissa
    nameIs
  }

  def three = {
    var buffer = KotipsykiatriGui.bufferiin(2).split(" ").toBuffer
    var word = Buffer[String]() // tähän sana ilman pistettä

    word = m.point(buffer)

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

  def doingB(b: Buffer[String]): Boolean = { //tää ei oo kauheen hyvä
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
  }

  def ollaB(b: Buffer[String]): Boolean = {
    var trueFalse = false
    for (i <- 0 until b.size) {
      if (b(i) == "a" || b(i) == "the") {
        trueFalse = true

      }
    }
    println("totta on: " + trueFalse)
    trueFalse
  }

  def olla(s: Buffer[String]): String = { //tätä voi suurentaa jos ehtii
    var word = ""
    var b = m.point(s)
    b = m.exclamation(b)
    for (i <- 0 until b.size) {
      if (b(i) == "a" || b(i) == "the") {
        if (b(i + 1) == "little" || b(i + 1) == "big" || b(i + 1) == "very" || b(i + 1) == "really" || b(i + 1) == "so")
          word = b(i + 1) + b(i + 2)
      }
    }
    println("sana on:" + word)
    word
  }

  def vitonen = {
    m.change(m.point(KotipsykiatriGui.bufferiin(4).split(" ").toBuffer))
  }

  def feeling(s: Buffer[String]): String = {
    println("s")
    var line = Buffer[String]()
    if (s.size < 3) {
      for (i <- s) {
        line += i
      }
    }
    if (s.size >= 3) {
      for (i <- 0 until s.size) {
        if (s(i) == "am" || s(i) == "is") {
          line += "you are " + s(i + 1)
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

    line = m.point(b)

    var piece = ""
    if (line.size == 1) {
      piece = line(0)
    } else if (line.size == 2) {
      if (line(0) == "very" || line(0) == "really" || line(0) == "so" ||
        line(0) == "pretty" || line(0) == "little") {
        piece = line(0) + " " + line(1)
      } else {
        piece = line.mkString(" ")
      }
    } else if (line.size == 3) {
      if (line(1) == "am") {
        piece = line(2)
      } else if (line(1) == "feel") {
        piece = line(2)
      } else {
        piece = line.mkString(" ")
      }
    } else if (line.size == 4) {
      if (line(1) == "am" && (line(2) == "very" || line(2) == "really" || line(2) == "so") ||
        line(2) == "pretty" || line(2) == "little") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "feel" && (line(2) == "very" || line(2) == "really" ||
        line(2) == "so" || line(0) == "pretty" || line(0) == "little")) {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else if (line(2) == "am") {
        piece = line(3)
      } else if (line(1) == "feel") {
        piece = line(2)
      } else {
        piece = line.mkString(" ")
      }
    } else if (line.size == 5) {
      if (line(1) == "am" && (line(2) == "very" || line(2) == "pretty" || line(2) == "little" ||
        line(2) == "really" | line(2) == "so")) {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" ||
        line(3) == "really" || line(3) == "so" || line(3) == "pretty" || line(3) == "little")) {
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
        piece = line.mkString(" ")
      }
    } else if (line.size == 6) {
      if (line(1) == "am" && line(2) == "very") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so")) {
        piece = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else {
        piece = line.mkString(" ")
      }
    } else if (line.size == 7) {
      if (line(1) == "am" && line(2) == "very") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so")) {
        piece = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        piece = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        piece = line(2)
      } else {
        piece = line.mkString(" ")
      }
    } else {
      piece = line.mkString(" ")
    }
    piece
  }

  /*  if (buf2(buf2.length - 1).contains("?")) {
      palauta = t.kysymykset(18) //+ t.kysymykset(2)
    }
    feelBuffer += palauta
    //println(palauta + "on palauta")
    palauta
  }*/

  /* def josKysymys: Boolean = { // mieti milloin kysymysmerkki
    var kysymys = kaikki
    for(i <- 0 until kysymys.size){
      if(kysymys(i) == "?"){
        true
      } else {
        false
      }
    }
  }*/

  /* def huutaa(): Boolean = { // pitäs tehä kaikille noille buffereille ??? miten tää oli
    var jou = this.bufferiFirst
    //var jou2 = this.bufferiKolmas
    println("huutaminen")
    var jou4 = Buffer[String]()
    for (jou3 <- 0 until bufferiFirst.size) {
      jou4 += bufferiFirst(jou3).toUpperCase()
    }
    if (jou == jou4) {
      true
    } else {
      false

    }
  }

  def huutoon() = {
    println("Doctor: Do you feel awfull when you use upper cases?")
  }
}*/

}
