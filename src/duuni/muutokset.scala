

package duuni
import Gui._
import scala.collection.mutable.Buffer

class muutokset {

  
  def piste(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()
  
    if(b(b.length - 1).contains(".")) {
      val pituus = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, pituus - 1)
      //println(line)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
  }
    line
  }
  
   def !(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()
  
    if(b(b.length - 1).contains("!")) {
      val pituus = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, pituus - 1)
      //println(line)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
  }
    line
  }
  
  def muutokset(b: Buffer[String]) = {
  var kokoLause = Buffer[String]()
    for (kaikkiSanat <- b) {
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

  

}