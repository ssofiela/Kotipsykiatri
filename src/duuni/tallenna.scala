package duuni
import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader
import java.io._
import duuni._
import Gui._
import scala.collection.mutable.Buffer
import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat 
import java.text.SimpleDateFormat 



object tallenna {
  
  var date: Date = new Date()
	

		


  val fileName = "kansio.txt"
  val pw = new PrintWriter(fileName)
  pw.write(date.toString() + "\n")
  pw.write("Doctor: Hello, What´s your name?" + "\n")

 
  def oo = {
println("turnCount"+alkuja.turnCount)
println("toon koko:" + KotipsykiatriGui.too.size)
    for (i <- 0 until alkuja.turnCount) {
      println("tallenna kansiossa")
      pw.write(KotipsykiatriGui.bufferiin(i) +"\n")
      if(i == alkuja.turnCount-1){
        println("vikaaa")
      }else{
      pw.write(KotipsykiatriGui.too(i) +"\n")
      }
    }
    pw.close()

    //    println("mitä tiedostoon(oo):" + KotipsykiatriGui.tee)

  }

}