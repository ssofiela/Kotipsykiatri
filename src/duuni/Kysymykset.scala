package duuni
import Gui._

class Kysymykset {

  val a = new alkuja
  val v = new vastaukset
  val t = new tiedosto
  
/*
 * this is always the same.
 */
  def alku() = t.kysymykset(0) 

  /*
   * this use the name method and ask a feeling.
   * if user ask doctor´s name, this answer and ask the feeling also.
   */
  def question1() = {
    var name = v.name
    if (!v.WhatIsYourName.isEmpty()) {
      println(v.WhatIsYourName + name + "." + t.kysymykset(2) + "?")
    } else if (name.isEmpty()) {
      println(t.kysymykset(15))
    } else {
      println(t.kysymykset(1) + name + "." + t.kysymykset(2) + "?")
    
    }
  }

  /*
   * the meaning is get closer the problem which user have or have not.
   * this use feel method and check that what if it is empty.
   */
  def question2() = {
    var feel = v.feel
    if (feel.isEmpty()) {
      println(t.kysymykset(16))
    } else if (feel == t.kysymykset(18) + t.kysymykset(2)) {
      println(t.kysymykset(18) + t.kysymykset(2) + "?")

    } else {
      println(t.kysymykset(3) + "." + t.kysymykset(4) + feel + "?")
    }
  }
  
/*
 * this use just input what user wrote and use "kolmas" -mothod wicth just make a sentence better.
 */
  def question3() = {
    var kolmas = v.kolmas
    if (kolmas.isEmpty) {
      println(t.kysymykset(5) + t.kysymykset(18))
    } else {
      println(t.kysymykset(5) + kolmas + "?")
    }
  }
  /*this wants to ask the feeling again and use the nameBuffer also.
   * Check if feelBuffer is empty, it use what the new input was. 
   * And check also if the the new input is empty then the question is something else.
   */

  def question4() = { 
    var neloseen = v.neloseen
    if (v.feelBuffer.isEmpty) {
      if (neloseen.isEmpty) {
        println(t.kysymykset(21))
      } else {
        println(t.kysymykset(6) + v.nameBuffer(0) + ". " + neloseen)
      }
    } else {
      println(t.kysymykset(6) + v.nameBuffer(0) + ". " + t.kysymykset(7) + " " + v.feelBuffer.last + "?")
    }
  }
  /*this metodi use the method feel and its depends what is the question5().
   * if feel is good the begin is "I am happy to hear that you are"...
   * and if the feel is bad is like "I hope you have better day tomorrow"...
   */

  def question5() = {   
    var vitonen = v.vitonen

   var palauta = t.kysymykset(23) + " "+ v.nameBuffer(0) + ". " + t.kysymykset(26) + vitonen + "."

    for (i <- v.feelBuffer(0).split(" ")) {
      if (i == "fine" || i == "good" || i == "well" || i == "graet" || i == "awesome" || i =="grateful" ||
          i == "happy" || i == "proud") {
        palauta = (t.kysymykset(9) + " " + v.feelBuffer(0) + ". " + t.kysymykset(26) + vitonen + ".")

      } else if (i == "bad" || i == "okey" || i == "angry" || i == "shy" || i == "mad" || i == "disapponted") {
        palauta = (" " + t.kysymykset(10) + v.feelBuffer(0) + " " + t.kysymykset(11) + ". " + t.kysymykset(26) + vitonen + ".")

      }
    }
    println(palauta)
  }
  def question6() = {
    var kutonen = v.kutonen
    println(t.kysymykset(12))
  }

    

  def question7() = {
    var kutonen = v.kutonen
    
    println(kutonen)
  }
  
  def question8() ={
    var kasi = v.kasi
    //println("pääsenkö ees tänne")
   // println(kasi)
    println(t.kysymykset(24) + kasi + ". "+t.kysymykset(25)) //+ kasi + t.kysymykset(27))
  }

  def End = { // miks tulostaa myös jonkun kysymykset???? 
    println("goodbye")
  }

  /*
   * Boolean method.
   * check when user wants to stop this discuss.
   */
  def Ending(): Boolean = { 

    if (v.all.contains("bye") || v.all.contains("goodbye")) {
      return true
    }

    false

  }

}


