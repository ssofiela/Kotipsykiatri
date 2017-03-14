package duuni

import java.io.BufferedReader
import java.io.Reader
import scala.io.StdIn.readLine
import scala.collection.mutable.Buffer

class vastaukset {

  def findAnswer(input: Reader) = {
    val input = readLine("prompt> ")
    var kaikki = Buffer[String](input)
    kaikki
  }

  def bufferi = {
    var vastaukse = Buffer[String]() // tähän bufferiin tulisi vastaus kokonaan!!
    var vastaukset = Buffer[String]()
    for (i <- vastaukse) {
      vastaukset += i
    }
    vastaukset
  }

  def nimi = {
    if (bufferi.size == 1) {
      this.bufferi
      // kun se on is sanan jälkeen
    } else if (bufferi(1) == "heter") {
      bufferi(2)
    } else if (bufferi(2) == "is") {
      bufferi(3)
    } else {
      None
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

  
  
  
  
  
}


/*val lineReader = new BufferedReader(input)

    try {

      // Read the file header and the save date from the first line.
      // You can use this variable for reading all the section headers.
      var currentLine = lineReader.readLine()

      val headerParts = currentLine.split(" ")
      

    }*/