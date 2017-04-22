package duuni
import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader
import java.io._
import duuni._
import Gui._
import scala.collection.mutable.Buffer

class tallenna {
  var buffer = Buffer[String]()
  //var a = new alkuja
  val fileName = "kansio.txt"
  val pw = new PrintWriter(fileName)
  pw.write("Doctor: Hello, What´s your name?" + "\n")

  var eka = ("Doctor: Hello, What´s your name?" + "\n")
  buffer += eka
  def oo = {

    try {
      pw.write(KotipsykiatriGui.tee.last)
      var toka = KotipsykiatriGui.tee.last + "\n"
      buffer += toka
      println("bufferi on:" + buffer)
      pw.close()
    } catch {

      case e: IOException =>
        val chessExc = println("Reading the chess data failed.")
        println("mitä tiedostoon(oo):" + KotipsykiatriGui.tee)

    }

  }
  def aa = {

    try {

      pw.write(KotipsykiatriGui.too.last)
      var kolmas = KotipsykiatriGui.too.last + "\n"
      buffer += kolmas
      // println("bufferi on:" + buffer)
      pw.close()
      //  println("mitä tiedostoon2 (aa):" + KotipsykiatriGui.too)

    }
  }
}