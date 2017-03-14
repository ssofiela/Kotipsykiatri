package duuni
import Gui._

class Kysymykset {
  
 /* def vastauksia = {
   private var ok =  Buffer[String]()
  }*/
  
  def alku(p : alkuja) = p.aloitus
  
  def kysymys1() = {
     val a = new alkuja
     val v = new vastaukset
    println(a.eka + v.nimi)
    }
  
}
