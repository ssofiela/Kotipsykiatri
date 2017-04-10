package duuni

//import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader

class vastaukset {
  var kaikki = Buffer[String]()
  //val inputs = readLine("Message: ")
  //kaikki += inputs
  //println(kaikki)

  /*def findAnswer(input: Reader) = {
    val input = readLine("prompt> ")
    
  }*/

  def bufferKaikki: Buffer[String] = {
    val r = readLine("Message: ")
    kaikki += r
    println(kaikki)
    kaikki
  }

  def bufferiFirst = {

    val inputti = bufferKaikki(0).split(" ")
    kaikki += inputti(0)
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size)
    vastaukset
  }

  def bufferiSecond = { // sit kun kaikki bufferiin saadaan kaikki inputit 0 paikalle ykköset!!!
    val inputti = bufferKaikki(0).split(" ")
    kaikki += inputti(0)
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    println("Vastaukset: " + vastaukset + " ja  vastaukset.size: " + vastaukset.size + "tää on tokaan")
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
    val inputti = bufferKaikki(2).split(" ")
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
    println("jee")

    val buf1 = this.bufferiFirst

    if (buf1.size == 1) {
      val nimi0 = kaikki(0) //this.bufferiFirst(0)
      println("nimiän on tietenkin(?): " + nimi0)
      nimi0 // kun se on is sanan jälkeen esim my name is "name"... tai it is "name" or it's "name".
    } else if (buf1(2) == "is") {
      val nimi1 = buf1(3)
      nimi1
    } else if (bufferiFirst(1) == "is") {
      val nimi2 = bufferiFirst(2)
      nimi2
      /*} else if (bufferiEkalle(1) == "am") {
      val nimi3 = bufferiFirst(2)
      nimi3
    } else if (bufferiFirst(0) == "It's") { //TÄÄ EI TOIMI
      val nimi4 = bufferiFirst(1)
      nimi4
    } else if (bufferiFirst(0) == "it's") { //TÄÄ EI TOIMI
      val nimi5 = bufferiFirst(1)
      nimi5*/

    }

  }
  //nimi muuttuu aina uuden inputin mukana!! miten saada pysymän tona?

  def howAreYou = {
    if (bufferiSecond.size == 1) {
      this.bufferiSecond(0)
    } else if (bufferiSecond(1) == "am") {
      bufferiSecond(2)
    } else {
      bufferiSecond(0) //this is NOT wörk reason i dont know
    }
  }

  def kolmoseen = {

    var kokoLause = Buffer[String]()
    // var vastaukset = Buffer[String](inputs2)

    for (kaikkiSanat <- this.bufferiFirst) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you" // jatka samanlailla kaikki tekijät läpi
      } else {
        kokoLause += kaikkiSanat
      }

    }
    for (joo <- kokoLause) {
      joo
    }

  }

  def feel = {
    if (bufferiKolmas.size == 1) {
      this.bufferiKolmas
    }
    //for (i <- 0 until bufferiKolmas.length) {
    if (bufferiKolmas(2) == "feel") {
      bufferiKolmas(3)
    }
    //}

  }

  def huutaa(): Boolean = { // pitäs tehä kaikille noille buffereille ??? miten tää oli
    var jou = this.bufferiKolmas
    var jou2 = this.bufferiKolmas
    var jou4 = ""
    for (jou3 <- 0 until bufferiKolmas.size) {
      jou4 = bufferiKolmas(jou3).toUpperCase()
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
}


/*val lineReader = new BufferedReader(input)

    try {

      // Read the file header and the save date from the first line.
      // You can use this variable for reading all the section headers.
      var currentLine = lineReader.readLine()

      val headerParts = currentLine.split(" ")
      

    }*/