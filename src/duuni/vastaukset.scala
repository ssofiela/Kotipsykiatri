package duuni

//import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader


class vastaukset {
  val inputs = readLine("Message: ")
  def findAnswer(input: Reader) = {
    val input = readLine("prompt> ")
    var kaikki = Buffer[String](input)
    kaikki
  }

  def bufferiFirst = {
    val inputti = inputs.split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    vastaukset
  }
  def bufferiSecond = {
    val inputti = inputs.split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    vastaukset
  }
def bufferi = {
    val inputti = inputs.split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
    vastaukset
  }

def bufferi3 = {
    
    val inputti = inputs.split(" ")
    var vastaukset = Buffer[String]()
    for (i <- 0 until inputti.size) {
      vastaukset += inputti(i)
    }
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
    var nimi = bufferiFirst(0)
    if (bufferiFirst.size == 1) {
      nimi = this.bufferiFirst(0)
      // kun se on is sanan jälkeen esim my name is "name"... tai it is "name" or it's "name".
    } else if (bufferiFirst(2) == "is") {
      nimi = bufferiFirst(3)
    } else if (bufferiFirst(1) == "is") {
      nimi = bufferiFirst(2)
      } else if (bufferiFirst(1) == "am") {
      nimi = bufferiFirst(2)
      } else if (bufferiFirst(0) == "It's") {    //TÄÄ EI TOIMI
      nimi = bufferiFirst(1)
      } else if (bufferiFirst(0) == "it's") {    //TÄÄ EI TOIMI
      nimi = bufferiFirst(1)

    
    }
    nimi
  }
  //nimi muuttuu aina uuden inputin mukana!! miten saada pysymän tona?
  
  def howAreYou = {
    if (bufferiSecond.size == 1) {
      this.bufferiSecond(0)
    } else if (bufferiSecond(1) == "am") {
      bufferiSecond(2)
    } else {
      bufferiSecond(0)    //this is NOT wörk reason i dont know
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
  for(joo <- kokoLause) {
    joo
  }

  }

  def feel = {
    if (bufferi.size == 1) {
      this.bufferi
    }
    for (i <- 0 until bufferi.length) {
      if (bufferi(i) == "feel") {
        bufferi(i + 1)
      }
    }

  }



  def huutaa(): Boolean ={
    var jou = this.bufferi
    var jou2 = this.bufferi
    var jou4 = ""
    for(jou3 <- 0 until bufferi.size){
       jou4 = bufferi(jou3).toUpperCase()
    }
    if(jou == jou4){
      true
    }else{
      false
    }
  }
  
  def huutoon()= {
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