package work

import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader
import scala.collection.mutable.Buffer
import duuni._

class FileReader {
  /*
 * ask on bufferi johon kerätään tekstitiedoston tekstipohjat.
 */
  var ask = Buffer[String]()
  private val fileName = "Comments.txt"
  
  try {
    for (line <- Source.fromFile(fileName).getLines()) {
      ask += line
    }
  } catch {
    case ex: Exception => println("FileNotFound")
  }
}
  



