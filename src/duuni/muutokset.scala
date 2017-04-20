

package duuni
import Gui._
import scala.collection.mutable.Buffer

class muutokset {

  def piste(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()

    if (b(b.length - 1).contains(".")) {
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

  def kyssari(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()

    if (b(b.length - 1).contains("?")) {
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
  def huutari(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()

    if (b(b.length - 1).contains("!")) {
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
      } else if (kaikkiSanat == "me") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you"
      } else if (kaikkiSanat == "We") {
        kokoLause += "you"
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "are") {
        kokoLause += "am"
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
      } else if (kaikkiSanat == "you") {
        if (kokoLause.contains("i")) {
          kokoLause += "me"
        } else {
          kokoLause += "i"
        }
      } else {
        kokoLause += kaikkiSanat
      }
    }

    kokoLause.mkString(" ")
  }

  def muutoksetReverse(b: Buffer[String]) = {
    var sanat = this.kyssari(b)
    println("sanat:" + sanat)
    var kokoLause = Buffer[String]()
    for (kaikkiSanat <- sanat) {
      kaikkiSanat.toLowerCase()
      if (kaikkiSanat == "you") {
        kokoLause += "i"
      } else if (kaikkiSanat == "You") {
        kokoLause += "i"
      } else if (kaikkiSanat == "i") {
        kokoLause += "you"
      } else if (kaikkiSanat == "I") {
        kokoLause += "you"
      } else if (kaikkiSanat == "we") {
        kokoLause += "you"
      } else if (kaikkiSanat == "are") {
        kokoLause += "am"
      } else if (kaikkiSanat == "am") {
        kokoLause += "are"
      } else if (kaikkiSanat == "your") {
        kokoLause += "my"
      } else if (kaikkiSanat == "my") {
        kokoLause += "your"
      } else if (kaikkiSanat == "Yours") {
        kokoLause += "mine"
      } else if (kaikkiSanat == "mine") {
        kokoLause += "yours"
      } else if (kaikkiSanat == "were") {
        kokoLause += "was"
      } else if (kaikkiSanat == "were") {
        kokoLause += "was"
      } else if (kaikkiSanat == "a") {
        kokoLause += "the"
      } else if (kaikkiSanat == "here") {
        kokoLause += "there"
      } else if (kaikkiSanat == "there") {
        kokoLause += "here"
      } else {
        kokoLause += kaikkiSanat
      }

    }
    kokoLause.mkString(" ")
  }

  def yes(b: Buffer[String]): String = { //jos vastaa vain yes tai no!
    var vastaus = Buffer[String]()
    for (i <- b) {
      i.toLowerCase()
      if (i == "yes") { //  if(i == "yes" || i == "sure" || i == "yep" || i == "yeah") {
        vastaus += "Doctor: Good to know!"
      } else if (i == "no") { // } else if(i == "no" || i == "nope" || i == "not"){
        vastaus += "Doctor: I get it wrong then! "
      }
    }
    vastaus.mkString(" ")
  }

  def yess(b: Buffer[String]): Boolean = {
    var joo = true
    //var vastaus = Buffer[String]()
    for (i <- b) {
      i.toLowerCase()
      if (i == "yes" || i == "sure" || i == "yep" || i == "yeah") {
        joo = true
        // vastaus += "Good to know!"
      } else if (i == "no" || i == "nope" || i == "not") {
        joo = true
        //vastaus += "I get it wrong then! "
      } else {
        joo = false
      }
    }
    joo
  }

  def ?(b: Buffer[String]): String = {
    var vastaus = Buffer[String]()
    for (i <- b) {
      i.toLowerCase()
      if (i == "?") { //  if(i == "yes" || i == "sure" || i == "yep" || i == "yeah") {
        vastaus += "Doctor: I am just asking the questions here!"

      }
    }
    vastaus.mkString(" ")
  }

  def ??(b: Buffer[String]): Boolean = {
    var joo = true

    if (b(b.length - 1).contains("?")) {
      joo = true
    } else {
      joo = false
    }
    joo
  }

  def !!(b: Buffer[String]): Boolean = {
    var joo = true

    if (b(b.length - 1).contains("!")) {
      joo = true
    } else {
      joo = false
    }
    joo
  }

  def !(b: Buffer[String]): String = {
    var vastaus = Buffer[String]()
    var oja = this.huutari(b)

    vastaus += "Do you have reason that you use exclamation mark?"

    vastaus.mkString(" ")
  }

  //var vastaus = Buffer[String]()
  /*for (i <- b) {
      i.toLowerCase()
      if (i == "?") {
       joo = true
       
      } else {
        joo =false
      }
    }
   joo
  }*/

}