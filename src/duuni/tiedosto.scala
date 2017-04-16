package duuni

import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader
import duuni._

import scala.collection.mutable.Buffer

class tiedosto {
  //val kysymykset = io.Source.fromFile("tekoaly.txt").getLines.toList
  //val reader = new FileReader("tekoaly.txt")

  var kysymykset = Buffer[String]()
  val fileName = "tekoaly.txt"
  try {

    for (line <- Source.fromFile(fileName).getLines()) {
      //println(line)   NÄÄ VOI MYÖHEMMIN AUTTAA
      kysymykset += line
     // println(kysymykset)   
    }
 /* } catch {
    case ex: Exception => println("öööö")*/

  }


}
  



