package duuni

import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader

import duuni._

import scala.collection.mutable.Buffer
class tiedosto {
	//var v = new vastaukset
	//var m = new muutokset
  //val kysymykset = io.Source.fromFile("tekoaly.txt").getLines.toList
  //val reader = new FileReader("tekoaly.txt")

  var kysymykset = Buffer[String]()
  val fileName = "tekoaly.txt"
  try {

    for (line <- Source.fromFile(fileName).getLines()) {
      kysymykset += line
      /*kysy
  
      def kysy = {
       var joo = v.bufferKaikki
       println("moi onpa mukava päivä")
        println(line + m.muutokset(m.piste(joo)))
      }*/
    }
  } catch {
    case ex: Exception => println("FileNotFound")

  }


}
  



