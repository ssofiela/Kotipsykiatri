package duuni
import Gui._

class Kysymykset {
  val a = new alkuja
  val v = new vastaukset
  val t = new tiedosto

  /* def vastauksia = {
   private var ok =  Buffer[String]()
  }*/
  // def kaikki() {

  def alku() =t.kysymykset(0) //a.aloitus
  /* def ennenEkaa = {
    val a = new alkuja
    println(a.haha)
  }*/

  def kysymys1() = {
    var name = v.name
    //jos teet tolla tavalla laita alkuun val nimi= v.nimi...s
    if (name.isEmpty()) {
      println("Tell me something!" + t.kysymykset(2))
    } else {
      println(t.kysymykset(1) + name + "." + t.kysymykset(2) + "?")
      //    println("ekakysymys kysymykset luokasta")
    }
  }

  def kysymys2() = {
var feel = v.feel
    val r = scala.util.Random
    if(feel.isEmpty()){
      println("Doctor: Could you tell me your feel beter?")
    } else {
    println(t.kysymykset(3) + "." + t.kysymykset(4) + feel + "?")
    }
  }
  def kysymys3() {
    var kolmas = v.kolmas
    if (kolmas.isEmpty()) {
      println("I understand that you don´t feel anything. But tell me why?")
    } else {
      println(t.kysymykset(5) + kolmas + "?") // VÄLIIN LISÄTÄÄN VIKAKOLMOSEEN KUN TOIMII
    }
  }
  
  def kysymys4() { //nimeä voi käyttää nimiBufferin avulla!
    var feeling = v.feeling
    if (feeling.isEmpty()) {
      println(t.kysymykset(6) + v.nameBuffer(0) + ". " + feeling)
    } else {
      println(t.kysymykset(6) + v.nameBuffer(0) + ". " + t.kysymykset(7) + feeling)
    }
  }
  
  /*def kysymys5() { // alkuun joku val feel = v.feel
    println(a.viidesHappy + v.vitonen)
    //tähän ifit
    /* var feel = v.vitonen
    if (feel == "fine" || feel == "good" || feel == "great" || feel == "awesome") { //... jatka kaikkia mahdollisia ilosia
      println(a.viidesHappy + v.feel + ".")
    } else if (feel == "bad" || feel == "awfull") { // jatka kaikki mahdolliset huonot
      println(a.viidenUnhappy + v.feel + ".")
    } else {
      println(a.viidesElse + v.feel + ".")
    }
  }*/
  }*/
}

//ja siitä jos laittaa ? niin vastaa et mä oon se joka kysyy kysykset... ja uudestaan
