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
    if(!v.WhatIsYourName.isEmpty()) {
      println(v.WhatIsYourName + name + "." + t.kysymykset(2) + "?")
    } else if (name.isEmpty()) {
      println(t.kysymykset(15))
    } else {
      println(t.kysymykset(1) + name + "." + t.kysymykset(2) + "?")
      //    println("ekakysymys kysymykset luokasta")
    }
  }

  def kysymys2() = {
var feel = v.feel
    val r = scala.util.Random
    if(feel.isEmpty()){
      println(t.kysymykset(16))
    } else if(feel == t.kysymykset(17) + t.kysymykset(2)){
      println(t.kysymykset(17) + t.kysymykset(2) +"?")
    } else if(feel.isEmpty()){
      println(t.kysymykset(16))
    } else {
    println(t.kysymykset(3) + "." + t.kysymykset(4) + feel + "?")
    }
  }
  def kysymys3() {
    var kolmas = v.kolmas
    if (kolmas.isEmpty()) {
      println(t.kysymykset(5) + t.kysymykset(18))
    } else {
      println(t.kysymykset(5) + kolmas + "?") // VÄLIIN LISÄTÄÄN VIKAKOLMOSEEN KUN TOIMII
    }
  }
  
  def kysymys4() { //nimeä voi käyttää nimiBufferin avulla!
    var feeling = v.feeling
    if (feeling.isEmpty()) {
      println(t.kysymykset(6) + v.nameBuffer(0) + ". " + v.neloseen)
    } else {
      println(t.kysymykset(6) + v.nameBuffer(0) + ". " + t.kysymykset(7) + feeling)
    }
  }
  
  def kysymys5() { // alkuun joku val feel = v.feel
  
    //tähän ifit
     var feel = v.vitonen
    if (feel == "fine" || feel == "good" || feel == "great" || feel == "awesome") { //... jatka kaikkia mahdollisia ilosia
      println(t.kysymykset(9) + v.feel + ".")
    } else if (feel == "bad" || feel == "awfull") { // jatka kaikki mahdolliset huonot
      println(t.kysymykset(10) + v.feel + ".")
    } else {
      println(t.kysymykset(11) + v.feel + ".")
    }
  }
  
  def lopetus = {    // miks tulostaa myös jonkun kysymykset????
    println("goodbye")
  }
  
  
   def loppunut(): Boolean = { // lopetus silloin kuin toinen laittanut sanan bye or thank you or thanks!!!
   
      if(v.all.contains("bye") ||v.all.contains("goodbye")){
        return true
      }
    
    false
    
  }
  
}

//ja siitä jos laittaa ? niin vastaa et mä oon se joka kysyy kysykset... ja uudestaan
