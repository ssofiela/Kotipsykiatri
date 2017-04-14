package duuni
import Gui._

class Kysymykset {
  val a = new alkuja
    val v = new vastaukset

  /* def vastauksia = {
   private var ok =  Buffer[String]()
  }*/
  // def kaikki() {

  def alku(p: alkuja) = p.aloitus
  /* def ennenEkaa = {
    val a = new alkuja
    println(a.haha)
  }*/

  def kysymys1() = {
        //jos teet tolla tavalla laita alkuun val nimi= v.nimi...s
    //if(v.nimi.isEmpty()) {
     //println("Could you tell me your name again?")
    //} else {
    println(a.eka + v.nimi + "." + a.eka1)
//    println("ekakysymys kysymykset luokasta")
   //}
  }
  def kysymys1Jatko() = {
   
    println(a.eka + v.nimi + "." + a.eka1)
    
  }
  def kysymys2() = {
    
    val r = scala.util.Random
    /*if(v.feel.isEmpty()){
      println("Doctor: Could you tell me your feel beter?")
    } else {*/
    println(a.toka + a.tokanJälkeenPiste + a.toka1 + v.feel + "?")
    //}
  }
  def kysymys3() {
    
    println(a.kolmas + v.kolmas + "?") // VÄLIIN LISÄTÄÄN VIKAKOLMOSEEN KUN TOIMII
  }
  def kysymys4() {  //nimeä voi käyttää nimiBufferin avulla!
    
    println(a.neljäs + v.nimiBuffer(0) + ". " + a.neljäs2 + v.feeling)
  }
  def kysymys5() {// alkuun joku val feel = v.feel
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
  }
}

//ja siitä jos laittaa ? niin vastaa et mä oon se joka kysyy kysykset... ja uudestaan
