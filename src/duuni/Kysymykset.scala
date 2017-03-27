package duuni
import Gui._

class Kysymykset {
  
 /* def vastauksia = {
   private var ok =  Buffer[String]()
  }*/
 // def kaikki() {
  
  def alku(p : alkuja) = p.aloitus
  
  def kysymys1() = {
     val a = new alkuja
     val v = new vastaukset
    println(a.eka + v.nimi + "?")
    }
  def kysymys2()= {
    val a = new alkuja
    val v = new vastaukset
    val r = scala.util.Random
    println(a.toka  + a.tokanJälkeenPiste + a.toka1 + v.howAreYou + "?")
  }
  def kysymys3() {
    val a = new alkuja
     val v = new vastaukset
   println(a.kolmas + v.kolmoseen + a.kolmas2)
  }
  def kysymys4(){
    println("neljäs")
  }
  //}
}
