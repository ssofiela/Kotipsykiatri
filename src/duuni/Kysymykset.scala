package duuni
import Gui._

class Kysymykset {
  
  val a = new alkuja
  val v = new vastaukset
  val t = new tiedosto

 
  def alku() = t.kysymykset(0) //a.aloitus

  
  def question1() = {
    var name = v.name
    if (!v.WhatIsYourName.isEmpty()) {
      println(v.WhatIsYourName + name + "." + t.kysymykset(2) + "?")
    } else if (name.isEmpty()) {
      println(t.kysymykset(15))
    } else {
      println(t.kysymykset(1) + name + "." + t.kysymykset(2) + "?")
      //    println("ekakysymys kysymykset luokasta")
    }
  }
  

  def question2() = {
    var feel = v.feel
    val r = scala.util.Random
    if (feel.isEmpty()) {
      println(t.kysymykset(16))
    } else if (feel == t.kysymykset(18) + t.kysymykset(2)) {
      println(t.kysymykset(18) + t.kysymykset(2) + "?")

    } else {
      println(t.kysymykset(3) + "." + t.kysymykset(4) + feel + "?")
    }
  }
  
  
  def question3() = {
    var kolmas = v.kolmas
    if (kolmas.isEmpty()) {
      println(t.kysymykset(5) + t.kysymykset(18))
    } else {
      println(t.kysymykset(5) + kolmas + "?") 
    }
  }

  
  def question4() = { //nimeä voi käyttää nimiBufferin avulla!
    var neloseen = v.neloseen
    if (v.feelBuffer.isEmpty) {
      if (neloseen.isEmpty()) {
        println(t.kysymykset(21))
      } else {
        println(t.kysymykset(6) + v.nameBuffer(0) + ". " + neloseen)
      }
    } else {
      println(t.kysymykset(6) + v.nameBuffer(0) + ". " + t.kysymykset(7) + " " + v.feelBuffer.last + "?")
    }
  }

  
  def question5() = { // alkuun joku val feel = v.feel
  var feelBuffer = v.feel
  println("feel on:" + feelBuffer)
    //var vitonen = v.vitonen
    
    if (v.feelBuffer.contains("fine") || v.feelBuffer.contains("good") || v.feelBuffer.contains("great") || v.feelBuffer.contains("awesome")) { //... jatka kaikkia mahdollisia ilosia
      println( " " + t.kysymykset(9) + v.feel + ".")// + vitonen)
    } else if (v.feelBuffer.contains("bad") ||v.feelBuffer.contains("fine") || v.feelBuffer.contains("okey")) { // jatka kaikki mahdolliset huonot
      println(" " + t.kysymykset(10) + feelBuffer + t.kysymykset(11) + ".")// + vitonen)
    } else {
      println(t.kysymykset(12))//+ vitonen)
    }
  }
  
  
  def question6() = {
   var kutonen = v.kutonen
   println(kutonen)
  }

  
  def End = { // miks tulostaa myös jonkun kysymykset????
    println("goodbye")
  }

  
  def Ending(): Boolean = { // lopetus silloin kuin toinen laittanut sanan bye or thank you or thanks!!!

    if (v.all.contains("bye") || v.all.contains("goodbye")) {
      return true
    }

    false

  }

}


