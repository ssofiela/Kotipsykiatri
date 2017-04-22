package duuni

import Gui._
import scala.collection.mutable.Buffer

class muutokset {
  //var v = new vastaukset

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

  def question(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()

    if (b(b.length - 1).contains("?")) {
      val length2 = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, length2 - 1)
      //println(line)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
    }
    line
  }
  def exclamation(b: Buffer[String]): Buffer[String] = {
    var line = Buffer[String]()

    if (b(b.length - 1).contains("!")) {
      val length2 = b(b.length - 1).length
      for (u <- 0 until b.size - 1) {
        line += b(u)
      }
      line += b(b.size - 1).substring(0, length2 - 1)
      //println(line)
    } else {
      for (i <- 0 until b.size) {
        line += b(i)
      }
    }
    line
  }

  
       /* for(i <- 0 until kaikkiSanat.size){
          if(kaikkiSanat(i)== "you"){
            if(i == kaikkiSanat.size-1){
              println("tästä tulee me")
              kokoLause += "me"
            } else {
              println("tässä tulee i")
              kokoLause += "i"
            }
          }
          println("ei löydy")
        }*/
       
        
    

  def change(b: Buffer[String]) = {
    var sanat = this.question(b)
    println("sanat:" + sanat)
    var wholeLine = Buffer[String]()
    for (kaikkiSanat <- sanat) {
     var words = kaikkiSanat.toLowerCase()
      if (words == "you") {
        wholeLine += "i"
      } else if (words == "You") {
         if("you" == words.last){
          wholeLine += "me"
       } else {
         wholeLine += "i"
       }
        
      } else if (words == "i") {
        wholeLine += "you"
      } else if (words == "I") {
        wholeLine += "you"
      } else if (words == "we") {
        wholeLine += "you"
      } else if (words == "are") {
        wholeLine += "am"
      } else if (words == "am") {
        wholeLine += "are"
        } else if (words == "me") {
        wholeLine += "you"
      } else if (words == "your") {
        wholeLine += "my"
      } else if (words == "my") {
        wholeLine += "your"
      } else if (words == "Yours") {
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
      } else if (words == "there") {
        wholeLine += "here"
      } else {
        wholeLine += words
      }

    }
    wholeLine.mkString(" ")
  }

  def yes(b: Buffer[String]): String = { //jos vastaa vain yes tai no!
    var vastaus = Buffer[String]()
    var t = this.point(b)
    t = this.exclamation(t)
    for (i <- 0 until t.size) {
      var s=t(i).toLowerCase()
      if (s == "yes" || s == "sure"  || s == "yep" || s == "yeah"|| s == "ofc") { //  if(i == "yes" || i == "sure" || i == "yep" || i == "yeah") {
        vastaus += "Doctor: Good to know!"
      } else if (s == "no" || s == "No" || s == "nope" || s == "Nope") { // } else if(i == "no" || i == "nope" || i == "not"){
        vastaus += "Doctor: I get it wrong then! "
      }
    }
    vastaus.mkString(" ")
  }

  def yess(b: Buffer[String]): Boolean = {
    var joo = true
   var t = this.point(b)
   t = this.exclamation(t)
 
   
   println("t:" +t)
    //var vastaus = Buffer[String]()
    for (i <- 0 until t.size) {
    var s = t(i).toLowerCase()
    println("s:" +s)
      if (s == "yes" || s == "Yes" || s == "Yep" || s == "Yeah" || s == "yep" || s == "yeah" || s == "ofc" || s == "Ofc") {
        return joo
        // vastaus += "Good to know!"
      } else if (s == "no" || s == "No" || s == "nope" || s == "Nope") {
        return joo
        //vastaus += "I get it wrong then! "
      } else {
        joo = false
      }
    }
   println("yess boolean on:" + joo)
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
    var oja = this.exclamation(b)

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