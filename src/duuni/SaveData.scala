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

object SaveData {

  private var date: Date = new Date()
  private val fileName = "File.txt"
  private var old = Source.fromFile(fileName).getLines().mkString(" \n")
  private val pw = new PrintWriter(fileName)
  pw.write(old)
  pw.write(date.toString() + "\n")
  pw.write("Doctor: Hello, What´s your name?" + "\n")

  def saving = {
    println("turnCount" + Turn.turnCount)
    println("toon koko:" + KotipsykiatriText.saving.size)
    for (i <- 0 until Turn.turnCount) {
      println("tallenna kansiossa")

      pw.write(KotipsykiatriText.commands(i) + "\n")
      if (i == Turn.turnCount - 1) {
        println("vikaaa")
      } else {
        pw.write(KotipsykiatriText.saving(i) + "\n")
      }
    }
    pw.close()
  }
}