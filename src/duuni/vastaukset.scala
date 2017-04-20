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
    var vastaukset = Buffer[String]()
    for (i <- 0 until part.size) {
      vastaukset += part(i)
    }
    // println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size)
    vastaukset
    //part
  }

  def bufferiSecond: Buffer[String] = { // sit kun kaikki bufferiin saadaan kaikki inputit 0 paikalle ykköset!!!

    val inputti = KotipsykiatriGui.bufferiin(1).split(" ")
    //kaikki += inputti(0)
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    //  println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size + "tää on tokaan")
    vastaukset
  }

 

  def IsItName(all: Buffer[String]): Boolean = {
    var kumpi = true
    var string = all.mkString(" ")
    println("all:" + all)
    if (string.contains("What is your name?") || string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {
      kumpi
    } else {
      kumpi = false
    }
    println(kumpi)
    kumpi
  }

  def WhatIsYourName(all: Buffer[String]): String = {
    var myName = ""
    var string = all.mkString(" ")
    println("all:" + all)
    if (string.contains("What is your name?") || string.contains("What´s your name?") ||string.contains("what is your name?") || string.contains("Who are you?") || string.contains("who are you?")) {

      myName = t.kysymykset(36) + ":)"
    }
    myName
  }
  
  def idkB(s: Buffer[String]): Boolean = {
    var kumpi = true
    var t = m.piste(s)
    if(t(0) == "i" && t(1) == "don't" && t(2) == "know"){
      kumpi
    } else {
      kumpi = false
    }
    println("idk: " + kumpi)
    kumpi
  }

  def commonB(b: String): Boolean= {
    var totta = true
     var line = Buffer[String]()
   var splitattu =  b.split(", ")
   if(splitattu.size == 2){
     totta
       
     } else {
       totta = false
   }
     totta
  }
  
  def common(b: String): String = {
     var line = Buffer[String]()
   var splitattu =  b.split(", ")
   if(splitattu.size == 2){
     if(splitattu(0).size > splitattu(1).size){
       line += splitattu(0)
     } else {
       line += splitattu(1)
     }
     }
     println("common line: " + line)
     var line2 = m.muutokset(line)
     line2.mkString(" ")
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
    line = m.piste(buf1)

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

  def kolmas = {
    var bufferi = KotipsykiatriGui.bufferiin(2).split(" ").toBuffer
    var sana = Buffer[String]() // tähän sana ilman pistettä

    sana = m.piste(bufferi)

    if (sana.size == 4) {
      if (sana(3) == "thanks") {
        sana = sana.take(3)
      }
    } else if (sana.size == 5) {
      if (sana(3) == "thank" && sana(4) == "you") {
        sana = sana.take(3)
      } else if (sana(4) == "thanks") {
        sana = sana.take(4)
      }

    } else if (sana.size == 6) {
      if (sana(4) == "thank" && sana(5) == "you") {
        sana = sana.take(4)
      }
    }
    var jee = m.muutokset(sana)
    //println(jee)
    jee
  }

  def doingB(b: Buffer[String]): Boolean = {
    var totta = true

    for (i <- 0 until b.size) {
      if (b(i) == "doing" || b(i) == "going") {
        totta
      } else {
        totta = false
      }
    }
    totta
  }

  def doing(b: Buffer[String]): String = {
    var loppu = Buffer[String]()
    for (i <- 0 until b.size) {
      if (b(i) == "doing" || b(i) == "going") {
        if (!b(i + 2).isEmpty()) {
          loppu += b(i + 2)
        }
      }
    }
    loppu.mkString(" ")
  }
  
  def ollaB(b: Buffer[String]): Boolean ={
    var totta = false
    for(i <- 0 until b.size){
      if(b(i) == "a" || b(i) == "the"){
       totta = true
      
      }
    }
    println("totta on: " + totta)
    totta
  }
  
  
  def olla(s: Buffer[String]): String ={
    var sana = ""
   var b = m.piste(s)
    b = m.huutari(b)
    for(i <- 0 until b.size){
      if(b(i) == "a" || b(i) == "the"){
        sana = b(i +1)
      }
    }
    println("sana on:" + sana)
    sana
  }
  
  
def vitonen = {
  m.muutokset(m.piste(KotipsykiatriGui.bufferiin(4).split(" ").toBuffer))
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
        } else {
          line += s(i)
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

    line = m.piste(b)

    var palauta = ""
    if (line.size == 1) {
      palauta = line(0)
    } else if (line.size == 2) {
      if (line(0) == "very" || line(0) == "really" || line(0) == "so" ||
        line(0) == "pretty" || line(0) == "little") {
        palauta = line(0) + " " + line(1)
      } else {
          palauta = line.mkString(" ")
      }
    } else if (line.size == 3) {
      if (line(1) == "am") {
        palauta = line(2)
      } else if (line(1) == "feel") {
        palauta = line(2)
      } else {
        palauta = line.mkString(" ")
      }
    } else if (line.size == 4) {
      if (line(1) == "am" && (line(2) == "very" || line(2) == "really" || line(2) == "so") ||
        line(2) == "pretty" || line(2) == "little") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "feel" && (line(2) == "very" || line(2) == "really" ||
        line(2) == "so" || line(0) == "pretty" || line(0) == "little")) {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      } else if (line(2) == "am") {
        palauta = line(3)
      } else if (line(1) == "feel") {
        palauta = line(2)
      } else {
        palauta = line.mkString(" ")
      }
    } else if (line.size == 5) {
      if (line(1) == "am" && (line(2) == "very" || line(2) == "pretty" || line(2) == "little" ||
        line(2) == "really" | line(2) == "so")) {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" ||
        line(3) == "really" || line(3) == "so" || line(3) == "pretty" || line(3) == "little")) {
        palauta = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      } else if (line(2) == "am") {
        palauta = line(3)
      } else if (line(2) == "am" && line(3) == "feeling") {
        palauta = line(3) + " " + line(4)
      } else {
        palauta = line.mkString(" ")
      }
    }else if (line.size == 6) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so")) {
        palauta = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      } else {
        palauta = line.mkString(" ")
      }
    } else if (line.size == 7) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so")) {
        palauta = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      } else {
        palauta = line.mkString(" ")
      }
    } else {
      palauta = line.mkString(" ")
    }
    palauta
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
