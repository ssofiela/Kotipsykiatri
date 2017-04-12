package duuni

//import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader

class vastaukset {
  println("uusi vastaukset")
  var kaikki = Buffer[String]()
  //val inputs = readLine("Message: ")
  //kaikki += inputs
  //println(kaikki)

  /*def findAnswer(input: Reader) = {
    val input = readLine("prompt> ")
    
  }*/

  def bufferKaikki = { // tätä pitää jokaisen kysymyksen jölkeen kysyy kerran
    val r = readLine("Message: ")
    kaikki += r
    println("kaikki: " + kaikki)
    //    kaikki
  }

  def bufferiFirst = {
    bufferKaikki
    val inputti = kaikki(0).split(" ")
    //kaikki += inputti(0)    //kypä lisäs
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size)
    vastaukset
  }

  def bufferiSecond = { // sit kun kaikki bufferiin saadaan kaikki inputit 0 paikalle ykköset!!!
    bufferKaikki
    val inputti = kaikki(1).split(" ")
    //kaikki += inputti(0)
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size + "tää on tokaan")
    vastaukset
  }

  def bufferiThird: String = {
    println("tulin kolmos bufferiin")
    bufferKaikki
    var vastaukset = kaikki(2)
    vastaukset
  }

  /* def bufferiJoo = {
    val inputti = inputs.split(" ")
    var vastaukset = Buffer[String]()
    var kaikkiVastaukset = Buffer[String]()
    kaikkiVastaukset += inputti(0)
    kaikkiVastaukset*/
  //}
  /*def bufferiEkalle = { //tokalle miten saada toka
    var vastaukset = Buffer[String]()
    for (i <- 0 until bufferiJoo(0).size) {
      vastaukset += bufferiJoo(i)
    }
    vastaukset
  }*/
  /*def bufferiTokalle = { //tokalle miten saada toka
    var vastaukset = Buffer[String]()
    for (i <- 0 until bufferiSecond(1).size) {
      vastaukset += bufferiSecond(i)
    }
    vastaukset
  }*/
  def bufferiKolmas = { //tokalle miten saada toka
    bufferKaikki
    val inputti = kaikki(2).split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    println(vastaukset, "toka")
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

  def nimi = {
    //val nimi = bufferiFirst(0)
    var nimi = "anonyme"

    val buf1 = this.bufferiFirst // lisää kaikkiin buf1

    if (buf1.size == 1) {
      if (kaikki(0) == "Hello" || kaikki(0) == "Hi" || kaikki(0) == "Hey" || kaikki(0) == "hello") {
        nimi = "anonyme"
      } else {
        //    	println("ennen")
        nimi = kaikki(0) //this.bufferiFirst(0)
      }
      //      println("jälkeen")
      //println("nimiän on tietenkin(?): " + nimi0)
      // kun se on is sanan jälkeen esim my name is "name"... tai it is "name" or it's "name".
    } else if (buf1(2) == "is") {
      nimi = buf1(3)

    } else if (buf1(1) == "is") {
      nimi = buf1(2)

    } else if (buf1(3) == "is") {
      nimi = buf1(4)

    } else if (buf1(4) == "is") {
      nimi = buf1(5)

    } else if (buf1(1) == "am") {
      nimi = buf1(2)

      /*} else if (buf1(2) == "am") { //tää ei vielä toimi
      nimi = buf1(3)*/

      /*} else if (buf1(0) == "Its") { //TÄÄ EI TOIMI
      nimi = buf1(1)
      
    } else if (buf1(0) == "it´s") { //TÄÄ EI TOIMI
      nimi = buf1(1)*/

    }
    nimi
  }

  /*def nimiJatko = {
    var nimi = "Noname"

    val buf2 = this.bufferiSecond // lisää kaikkiin buf1

    if (buf2.size == 1) {
      nimi = kaikki(1) //this.bufferiFirst(0)
      //println("nimiän on tietenkin(?): " + nimi0)
      // kun se on is sanan jälkeen esim my name is "name"... tai it is "name" or it's "name".
    } else if (buf2(2) == "is") {
      nimi = buf2(3)

    } else if (buf2(1) == "is") {
      nimi = buf2(2)

    } else if (buf2(3) == "is") {
      nimi = buf2(4)

    } else if (buf2(4) == "is") {
      nimi = buf2(5)

    } else if (buf2(1) == "am") {
      nimi = buf2(2)
    }
  }*/

  def kolmas = {
    var bufferi = bufferiThird.split(" ")
    var kokoLause = Buffer[String]()
    if (bufferi.isEmpty) {
      kokoLause += "you did not answer to me"
    } else {
      for (kaikkiSanat <- bufferi) {
        kaikkiSanat.toLowerCase()
        if (kaikkiSanat == "i") {
          kokoLause += "you"
        } else if (kaikkiSanat == "we") {
          kokoLause += "you" // jatka samanlailla kaikki tekijät läpi
        } else {
          kokoLause += kaikkiSanat
        }
      }
       
    }
    kokoLause.toString().drop(1)
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

  def feel = { // howareyou ja feel metodi yhdistä
    val buf2 = bufferiSecond
    var palauta = "nofeel"
    println("olen päässyt feel metodiin")
    if (buf2.size == 1) { // jos saa toimiin oikein niin vaihda ykköseen
      palauta = buf2(0) // ihan fine mut lisää vaihtoehtoja
    } else if (buf2(1) == "am") {
      palauta = buf2(2)
    } else if (buf2(3) == "am") {
      palauta = buf2(4)
    } else if (buf2(2) == "am") {
      palauta = buf2(3)
    }
    /* var lyhyt = this.bufferKaikki(0).split(" ")
    //for (i <- 0 until bufferiKolmas.length) {
    if (lyhyt(2)== "feel") {
      lyhyt(3)*/ //Toinen kysymys feilas tän takii!!!!!
    //}
    //}
    palauta
  }

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