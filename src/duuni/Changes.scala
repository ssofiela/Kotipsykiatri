package duuni

import Gui._
import scala.collection.mutable.Buffer

class Changes {

  /*
 * katsoo löytyykö viimeisenä piste. jos löytyy se otetaa pois.
 */
  def point(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()
    if (b(b.length - 1).contains(".")) {
      val length2 = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, length2 - 1)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
    }
    line
  }
  /*
 * jos käyttäjä on kysynyt kysymyksen, tällä otetaan lopun kysymysmerkki pois.
 */
  def question(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()
    if (b(b.length - 1).contains("?")) {
      val length2 = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, length2 - 1)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
    }
    line
  }

  /*
   * jos käyttäjä on käyttänyt huutomerkkiä, tällä otetaan se pois.
   */
  def exclamation(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()
    if (b(b.length - 1).contains("!")) {
      val length2 = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, length2 - 1)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
    }
    line
  }

  
  /*
 * tällä metodilla muutetaan tekijät oikeiksi esimerkiksi "I am" -> "You are".
 */
  def change(b: Buffer[String]): String = {
    var sanat = this.question(b)
    println("sanat:" + sanat)
    var wholeLine = Buffer[String]()
    for (kaikkiSanat <- sanat) {
      var words = kaikkiSanat.toLowerCase()
      if (words == "you") { //tää ei vaihtanu
        println("d" + words + sanat.last)
        if (words == sanat.last) { //jos vikana "you" -> "me" else "I"
          wholeLine += "me"
        } else {
          wholeLine += "I"
        }
      } else if (words == "i") {
        wholeLine += "you"
      } else if (words == "I") {
        wholeLine += "you"
      } else if (words == "we") {
        wholeLine += "you"
      } else if (words == "are") {
        if (wholeLine.contains("you")) { //jos käyttäjä sanoo "we are" -> "you are"
          wholeLine += "are"
        } else {
          wholeLine += "am"
        }
      } else if (words == "am") {
        wholeLine += "are"
      } else if (words == "me") {
        wholeLine += "you"
      } else if (words == "your") {
        wholeLine += "my"
      } else if (words == "my") {
        wholeLine += "your"
      } else if (words == "My") {
        wholeLine += "Your"
      } else if (words == "yours") {
        wholeLine += "mine"
      } else if (words == "mine") {
        wholeLine += "yours"
      } else if (words == "were") {
        wholeLine += "was"
      } else if (words == "were") {
        wholeLine += "was"
      } else if (words == "a") {
        wholeLine += "the"
      } else if (words == "here") {
        wholeLine += "there"
      } else {
        wholeLine += words
      }
    }
    wholeLine.mkString(" ")
  }

  /*
   * tämä metodi poistaa lopun pisteen/huutomerkin, jos sellainen on,
   * ja sitten  palauttaa Stringin sen mukaan onko yes vau no.
   */
  def yes(b: Buffer[String]): String = { //jos vastaa vain yes tai no!
    var vastaus = Buffer[String]()
    var t = this.point(b)
    t = this.exclamation(t)
    for (i <- 0 until t.size) {
      var s = t(i).toLowerCase()
      if (s == "yes" || s == "sure" || s == "yep" || s == "yeah" || s == "ofc") {
        vastaus += "Doctor: Good to know!"
      } else if (s == "no" || s == "No" || s == "nope" || s == "Nope") {
        vastaus += "Doctor: I get it wrong then! "
      }
    }
    vastaus.mkString(" ")
  }

  def imp(b: Buffer[String]): String = {
    var buf = this.question(b)
    println("sanat:" + buf)
    var wholeLine = Buffer[String]()
    for (allTheWords <- buf) {
      var words = allTheWords.toLowerCase()
      if (words == "are") { 
        wholeLine += "were"
      } else if (words == "am") {
        wholeLine += "was"
      } else if (words == "see") {
        wholeLine += "saw"
      } else if (words == "go") {
        wholeLine += "went"
      } else if (words == "do") {
        wholeLine += "did"
      } else if (words == "sleep") {
        wholeLine += "slept"
      } else if (words == "is") {
        wholeLine += "was"
      } else if (words == "feel") {
        wholeLine += "felt"
      } else {
        wholeLine += words
      }
    }
    println("mks: " + wholeLine.mkString(" "))
    wholeLine.mkString(" ")
  }

  def pre(b: Buffer[String]): String = {
    var buf = this.question(b)
    println("sanat:" + buf)
    var wholeLine = Buffer[String]()
    for (allTheWords <- buf) {
      var words = allTheWords.toLowerCase()
      if (words == "were") { //tää ei vaihtanu
        wholeLine += "are"
      } else if (words == "was") {
        wholeLine += "am"
      } else if (words == "saw") {
        wholeLine += "see"
      } else if (words == "went") {
        wholeLine += "go"
      } else if (words == "did") {
        wholeLine += "do"
      } else if (words == "slept") {
        wholeLine += "sleep"
      } else if (words == "was") {
        wholeLine += "is"
      } else if (words == "felt") {
        wholeLine += "feel"
      } else {
        wholeLine += words
      }
    }
    println("mks: " + wholeLine.mkString(" "))
    wholeLine.mkString(" ")
  }

  /*
   * yes -metodin boolean. Ottaa pois pisteen/huutomerkin jos sellainen on.
   * Pienentää lowerCase() metodilla ja jos löytyy jokin noista sanoista return true ja muuten false
   */
  def yess(b: Buffer[String]): Boolean = {
    var joo = true
    var t = this.point(b)
    t = this.exclamation(t)
    for (i <- 0 until t.size) {
      var s = t(i).toLowerCase()
      println("s:" + s)
      if (s == "yes" || s == "Yes" || s == "Yep" || s == "Yeah" || s == "yep" || s == "yeah" || s == "ofc" || s == "Ofc") {
        return joo
      } else if (s == "no" || s == "No" || s == "nope" || s == "Nope") {
        return joo
      } else {
        joo = false
      }
    }
    joo
  }

  /*
   * tällä metodilla katsotaan, onko käyttäjän laittama inputti kysymys.
   * jos viimeisenä on kysymysmerkki, silloin se on kysymys.
   */
  def ??(b: Buffer[String]): Boolean = {
    var joo = true
    if (b(b.length - 1).contains("?")) {
      joo = true
    } else {
      joo = false
    }
    joo
  }

  /*
   * Tällä metodilla katsotaan, onko käyttäjän laittama inputissa huutomerkki.
   * Jos siinä on, metodi palauttaa true ja muuten false.
   */
  def !!(b: Buffer[String]): Boolean = {
    var joo = true
    if (b(b.length - 1).contains("!")) {
      joo = true
    } else {
      joo = false
    }
    joo
  }
  /*
 * kun !! -metodi on true, tätä metodia kutsutaan.
 * ja tämä metodi palauttaa Stringin ilman huutomerkkiä.
 */
  def !(b: Buffer[String]): String = {
    var vastaus = Buffer[String]()
    var without = this.exclamation(b)
    vastaus += "Why do you yell at me?"
    vastaus.mkString(" ")
  }

}