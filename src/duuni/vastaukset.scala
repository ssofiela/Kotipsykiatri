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
  var t = new tiedosto
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

  def bufferiKolmas = { //tokalle miten saada toka
    bufferKaikki
    val inputti = all(2).split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    //println(vastaukset, "toka")
    vastaukset
  }

  /*var vastaukse = Buffer[String](input)
    vastaukse = vastaukse.splitAt()// tähän bufferiin tulisi vastaus kokonaan!!
    var vastaukset = Buffer[String]()
  for(i <- 0 until vastaukse.size){
    vastaukset += vastaukse(i)
    
  }
    vastaukset*/

  /*for (i <- vastaukse) {
      vastaukset += i
    }
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

  def name = {
    var nameIs = "anonyme"
    val buf1 = this.bufferiFirst
    var line = Buffer[String]()

    if (buf1(buf1.length - 1).contains(".")) { //poistetaan loppupiste
      val pituus = buf1(buf1.length - 1).length
      for (u <- 0 until buf1.size - 1) {
        line += buf1(u)
      }
      line += buf1(buf1.size - 1).substring(0, pituus - 1)
      //println(line)
    } else {
      for (i <- 0 until buf1.size) {
        line += buf1(i)
      }
    }

    if (line.size == 1) {
      if (all(0) == "Hello" || all(0) == "Hi" || all(0) == "Hey" || all(0) == "hello") {
        // tämä katsoo, että jos on vaan tervehdys, niin sitä ei katsota nimeksi
        nameIs = "anonyme"
      } else {
        nameIs = all(0) //muuten vain yksi sana mielletään nimeksi
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
      }

    } else if (line.size == 5) {
      if (line(1) == "am") {
        nameIs = line(2)
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
    var bufferi = bufferiThird.split(" ")
    var sana = Buffer[String]() // tähän sana ilman pistettä

    if (bufferi(bufferi.length - 1).contains(".")) {
      val pituus = bufferi(bufferi.length - 1).length
      for (u <- 0 until bufferi.size - 1) {
        sana += bufferi(u)
      }
      sana += bufferi(bufferi.size - 1).substring(0, pituus - 1)
      println(sana)
    } else {
      for (i <- 0 until bufferi.size) {
        sana += bufferi(i)
      }
    }

    var kokoLause = Buffer[String]()
    for (kaikkiSanat <- sana) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you" // jatka samanlailla kaikki tekijät läpi
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "was") {
        kokoLause += "were"
      } else {
        kokoLause += kaikkiSanat
      }

    }

    kokoLause.mkString(" ")

  }

  def neloseen = {
    var bufferi = bufferiFour.split(" ")
    var sana = Buffer[String]() // tähän sana ilman pistettä

    if (bufferi(bufferi.length - 1).contains(".")) {
      val pituus = bufferi(bufferi.length - 1).length
      for (u <- 0 until bufferi.size - 1) {
        sana += bufferi(u)
      }
      sana += bufferi(bufferi.size - 1).substring(0, pituus - 1)
      println(sana)
    } else {
      for (i <- 0 until bufferi.size) {
        sana += bufferi(i)
      }
    }

    var kokoLause = Buffer[String]()
    for (kaikkiSanat <- sana) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you" // jatka samanlailla kaikki tekijät läpi
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "was") {
        kokoLause += "were"
      } else {
        kokoLause += kaikkiSanat
      }

    }

    kokoLause.mkString(" ")

  }

  /*def vikaKolmoseen = { // eli perjaattees kolmanteen tohtorin kessäriin
    var kokoLause = Buffer[String]()
    if (this.kaikki(1).size == 0) {
      kokoLause += "You should answer longer!"
    } else {

      var pienemmiksi = this.kaikki(1).split(" ")
      for (kaikkiSanat <- pienemmiksi) {
        kaikkiSanat.toLowerCase()
        if (kaikkiSanat == "i") {
          kokoLause += "you"
        } else if (kaikkiSanat == "we") {
          kokoLause += "you" // jatka samanlailla kaikki tekijät läpi
        } else {
          kokoLause += kaikkiSanat
        }
        kokoLause.tail
      }
    }
  }*/

  /* def howAreYou = {
    if (bufferiSecond.size == 1) {
      this.bufferiSecond(0)
    } else if (bufferiSecond(1) == "am") {
      bufferiSecond(2)
    } else {
      bufferiSecond(0) //this is NOT wörk reason i dont know
    }
  }*/

  def vitonen = {
    var buf2 = bufferiSecond
    var vitone = ""
    for (i <- 0 until buf2.size) {
      if (buf2(i) == "fine") {
        vitone = buf2(i)
      }
    }
    vitone
  }

  def feeling = {
    var buf2 = bufferiSecond //tähän kans muutokset i -> you...
    var line = Buffer[String]()

    if (buf2(buf2.length - 1).contains(".")) {
      val pituus = buf2(buf2.length - 1).length
      for (u <- 0 until buf2.size - 1) {
        line += buf2(u)
      }
      line += buf2(buf2.size - 1).substring(0, pituus - 1)
      //println(line)
    } else {
      for (i <- 0 until buf2.size) {
        line += buf2(i)
      }
    }

    var lopullinen = ""
    if (line.size == 1) { //toimii
      lopullinen = "you are " + all(1)
    } else if (line.size > 1) {
      lopullinen = all(1)
    } else {
      lopullinen = "I can help you beter if you answer that are you fine?"
    }

    // println("lopullinen:" + lopullinen)
    lopullinen
  }

  def feel = { // tähän lissä i am feeling well... i am fine... now i am fine... yms.
    val buf2 = bufferiSecond // ekana kaikista lyhyimmät ja ehdoks pituuksii ettei tuu erroreita
    var line = Buffer[String]()

    if (buf2(buf2.length - 1).contains(".")) { //poistaa loppupisteen jos sellainen on
      val pituus = buf2(buf2.length - 1).length
      for (u <- 0 until buf2.size - 1) {
        line += buf2(u)
      }
      line += buf2(buf2.size - 1).substring(0, pituus - 1)
      // println(line)
    } else {
      for (i <- 0 until buf2.size) {
        line += buf2(i)
      }
    }

    var palauta = ""
    //println("olen päässyt feel metodiin")
    if (line.size == 1) {
      palauta = line(0) // ihan fine mut lisää vaihtoehtoja
    }
    if (line.size == 2) {
      if (line(0) == "very") {
        palauta = line(0) + " " + line(1)
      }
    }
    if (line.size == 3) {
      if (line(1) == "am") {
        palauta = line(2)
      }
    }
    if (line.size == 4) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(3)
      } else if (line(1) == "am") {
        palauta = line(2)
      } else if (line(2) == "am") {
        palauta = line(3)
      } else if (line(1) == "am" && line(2) == "feeling") {
        palauta = line(3)
      }
    }
    if (line.size == 5) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && line(3) == "very") {
        palauta = line(3) + " " + line(4)
      } else if (line(1) == "am") {
        palauta = line(2)
      } else if (line(2) == "am") {
        palauta = line(3)
      } else if (line(3) == "am" && line(4) == "feeling") {
        palauta = line(4)
      }
    }
    if (line.size == 6) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && line(3) == "very") {
        palauta = line(3) + " " + line(4)
      } else if (line(1) == "am") {
        palauta = line(2)
      }
    }
    if (line.size == 7) {
      if (line(1) == "am" && line(2) == "very") {
        palauta = line(3)
      } else if (line(1) == "am" && line(2) == "feeling" && line(3) == "very") {
        palauta = line(3) + " " + line(4)
      } else if (line(1) == "am") {
        palauta = line(2)
      }
    }

    if (buf2(buf2.length - 1).contains("?")) {
      palauta = t.kysymykset(17) + t.kysymykset(2)
    }

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