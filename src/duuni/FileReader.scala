package duuni

import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader

import duuni._

import scala.collection.mutable.Buffer
class FileReader {

  var ask = Buffer[String]()
  private val fileName = "tekoaly.txt"
  try {

    for (line <- Source.fromFile(fileName).getLines()) {
      ask += line

    }
  } catch {
    case ex: Exception => println("FileNotFound")

  }

}
  



