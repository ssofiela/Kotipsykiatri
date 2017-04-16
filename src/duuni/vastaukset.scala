package duuni

//import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader

class vastaukset {
  // println("uusi vastaukset")
  var all = Buffer[String]() //tänne kerätään kaikki inputit
  var nameBuffer = Buffer[String]()
  var feelBuffer = Buffer[String]()
  var t = new tiedosto
  var m = new muutokset
  //val inputs = readLine("Message: ")
  //kaikki += inputs
  //println(kaikki)

  /*def findAnswer(input: Reader) = {
    val input = readLine("prompt> ")
    
  }*/

  def bufferKaikki = { // tätä pitää jokaisen kysymyksen jölkeen kysyy kerran
    //bufferkaikki lukee inputin, lisää inputin ja lisää inputin sen all bufferiin
    val input = readLine("Message: ")
    all += input
    //println("kaikki: " + all)
  }

  def bufferiFirst: Buffer[String] = { //
    bufferKaikki
    val part = all(0).split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until part.size) {
      vastaukset += part(i)
    }
    //  println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size)
    vastaukset
    //part
  }

  def bufferiSecond: Buffer[String] = { // sit kun kaikki bufferiin saadaan kaikki inputit 0 paikalle ykköset!!!
    bufferKaikki
    val inputti = all(1).split(" ")
    //kaikki += inputti(0)
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    //  println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size + "tää on tokaan")
    vastaukset
  }

  def bufferiThird: String = {
    // println("tulin kolmos bufferiin")
    bufferKaikki
    var vastaukset = all(2)
    vastaukset
  }
  def bufferiFour: String = {
    // println("tulin kolmos bufferiin")
    bufferKaikki
    var vastaukset = all(3)
    vastaukset
  }
  def bufferiFive: String = {
    bufferKaikki
    var vastaukset = all(4)
    vastaukset
  }

  def bufferiSix: String = {
    bufferKaikki
    var vastaukset = all(5)
    vastaukset
  }
  def bufferiEight: String = {
    bufferKaikki
    var vastaukset = all(7)
    vastaukset
  }

  /*def bufferiKolmas = { //tokalle miten saada toka
    bufferKaikki
    val inputti = all(2).split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    //println(vastaukset, "toka")
    vastaukset
  }*/

  def WhatIsYourName: String = {
    var myName = ""
    if (all(0).contains("What is your name?") || all(0).contains("what is your name?") || all(0).contains("Who are you?") || all(0).contains("who are you?") ||
      all(0).contains("and you?") || all(0).contains("what about you?")) {
      myName = t.kysymykset(19)
    }
    myName
  }

  /*
 * this long method is taking the name off the line.
 * the first thig what this do, take of the end point if the line have point.
 * then it check that "hello"... is not the name
 * then its check what is size of the line just in case and take the name off.
 * the name method take just the first name if there is more names.
 */
  def name = {
    var nameIs = "anonyme"
    val buf1 = this.bufferiFirst
    var line = Buffer[String]()
    line =  m.piste(buf1)
   

    if ( line.size == 1) {
      if (all(0) == "Hello" || all(0) == "Hi" || all(0) == "Hey" || all(0) == "hello") {
        nameIs = "anonyme"
      } else {
        nameIs = all(0)
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
    var bufferi = bufferiThird.split(" ").toBuffer
    var sana = Buffer[String]() // tähän sana ilman pistettä

   sana =  m.piste(bufferi)

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
    var kokoLause = Buffer[String]()

    for (kaikkiSanat <- sana) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "I") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you"
      } else if (kaikkiSanat == "We") {
        kokoLause += "you"
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "My") {
        kokoLause += "your"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "was") {
        kokoLause += "were"
      } else if (kaikkiSanat == "a") {
        kokoLause += "the"
      } else if (kaikkiSanat == "here") {
        kokoLause += "there"
      } else {
        kokoLause += kaikkiSanat
      }

    }

    kokoLause.mkString(" ")

  }

  def neloseen = { //kolmosen vastaus
    var bufferi = bufferiFour.split(" ").toBuffer
    var sana = Buffer[String]() // tähän sana ilman pistettä

   sana =  m.piste(bufferi)

    var kokoLause = ""
    for (kaikkiSanat <- sana) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "I") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you"
      } else if (kaikkiSanat == "We") {
        kokoLause += "you"
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "My") {
        kokoLause += "your"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "was") {
        kokoLause += "were"
      } else if (kaikkiSanat == "a") {
        kokoLause += "the"
      } else if (kaikkiSanat == "here") {
        kokoLause += "there"
      } else {
        kokoLause += kaikkiSanat
      }

    }
    kokoLause
    //kokoLause.mkString(" ")

  }

  def vitonen = { //tää on ihan väärin
    var buf5 = bufferiFive.split(" ").toBuffer
    var line = Buffer[String]()

    line =  m.piste(buf5)
    
    
    var kokoLause = Buffer[String]()
    for (kaikkiSanat <- line) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "I") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you"
      } else if (kaikkiSanat == "We") {
        kokoLause += "you"
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "My") {
        kokoLause += "your"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "was") {
        kokoLause += "were"
      } else if (kaikkiSanat == "a") {
        kokoLause += "the"
      } else if (kaikkiSanat == "here") {
        kokoLause += "there"
      } else {
        kokoLause += kaikkiSanat
      }

    }
    println("kokoLause:" + kokoLause)
    kokoLause.mkString(" ")
    //kokoLause.mkString(" ")

  }

  def kutonen = {
    println("pääsin kutoseen kuitenkin")   // !!!!!!!!!!!!!!!!!TÄÄÄ EI TOIMIIIIIIIIIIII

    var buf6 = bufferiSix.split(" ").toBuffer

    var line = Buffer[String]()

    line =  m.piste(buf6)
    var kutone = ""
    if (line.size == 1) {
      if ((line =="no") || (line == "No") || (line =="not") ||( line =="Not")) {
        println("jotain lopettamista")
      } else if (line.contains("yes") || line.contains("Yes") || line.contains("sure") || line.contains("Sure") || line.contains("maybe") || line.contains("Maybe")) {
        kutone = t.kysymykset(21) + " " + nameBuffer(0) + "?"
      } else {
        kutone = t.kysymykset(21) + " " + nameBuffer(0) + "?"
      }
    } else if (line.size > 1) {
      if (line.contains("no") || line.contains("No") || line.contains("not") || line.contains("Not")) {
        println("jotain lopettamista")
      } else if (line.contains("yes") || line.contains("Yes") || line.contains("sure") || line.contains("Sure") || line.contains("maybe") || line.contains("Maybe")) {
        kutone = t.kysymykset(21) + " " + nameBuffer(0) + "?"
      } else {
        kutone = t.kysymykset(21) + " " + nameBuffer(0) + "?"
      }
    } else {
      kutone = t.kysymykset(21) + " " + nameBuffer(0) + "?"
    }
    kutone
    //println("kutose metodu:" + kutone)
  }

  def kasi = {
    var buf8 = bufferiEight.split(" ").toBuffer
    var line = Buffer[String]()

    line =  m.piste(buf8)
    
    var kokoLause = Buffer[String]()
    for (kaikkiSanat <- line) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "I") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you"
      } else if (kaikkiSanat == "We") {
        kokoLause += "you"
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "My") {
        kokoLause += "your"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "was") {
        kokoLause += "were"
      } else if (kaikkiSanat == "a") {
        kokoLause += "the"
      } else if (kaikkiSanat == "here") {
        kokoLause += "there"
      } else {
        kokoLause += kaikkiSanat
      }

    }
    println(kokoLause)
    kokoLause.mkString(" ")
    //kokoLause.mkString(" ")

  }

  def feeling = {
    var buf2 = bufferiSecond //tähän kans muutokset i -> you...
    var line = Buffer[String]()

   line =  m.piste(buf2)

    var lopullinen = ""
    if (line.size == 1) { //toimii
      lopullinen = "you are " + all(1)
    } else if (line.size > 1) {
      lopullinen = all(1)
    } else {
      lopullinen = "I can help you better if you answer that are you fine?"
    }

    // println("lopullinen:" + lopullinen)
    lopullinen
  }

  /*
   * this take the feel from the line.
   * check size of the line just in case.
   * and return "feeling"-verb, and the whole feeling 
   * what is reason that this is so long!
   */
  def feel = {
    val buf2 = bufferiSecond
    var line = Buffer[String]()

    line =  m.piste(buf2)

    var palauta = ""
    if (line.size == 1) {
      palauta = line(0)
    }
    if (line.size == 2) {
      if (line(0) == "very" || line(0) == "really" || line(0) == "so" ||
        line(0) == "pretty" || line(0) == "little") {
        palauta = line(0) + " " + line(1)
      }
    }
    if (line.size == 3) {
      if (line(1) == "am") {
        palauta = line(2)
      } else if (line(1) == "feel") {
        palauta = line(2)
      }
    }
    if (line.size == 4) {
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
      }
    }
    if (line.size == 5) {
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
      }
    }
    if (line.size == 6) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so")) {
        palauta = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      }
    }
    if (line.size == 7) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && (line(3) == "very" || line(3) == "really" ||
        line(3) == "so")) {
        palauta = line(2) + " " + line(3) + " " + line(4)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(2) + " " + line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      }
    }

    if (buf2(buf2.length - 1).contains("?")) {
      palauta = t.kysymykset(18) //+ t.kysymykset(2)
    }
    feelBuffer += palauta
    //println(palauta + "on palauta")
    palauta
  }

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

  /*val lineReader = new BufferedReader(input)

    try {

      // Read the file header and the save date from the first line.
      // You can use this variable for reading all the section headers.
      var currentLine = lineReader.readLine()

      val headerParts = currentLine.split(" ")
      
*/
}