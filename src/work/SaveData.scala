package work
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


object SaveData {

 
  private var date: Date = new Date()  //päivämäärä alkuun
  private val fileName = "File.txt"
  private var old = Source.fromFile(fileName).getLines().mkString(" \n")  //ladataan vanhat tekstit tekstitiedostosta
  private val pw = new PrintWriter(fileName)
  pw.write(old)  //lisätään ensiksi vanhat keskustelut takaisin ennen kun uusia päälle
  pw.write(date.toString() + "\n")  //päivämäärä
  pw.write("Doctor: Hello, What´s your name?" + "\n")

  def saving = {
    for (i <- 0 until Turn.turnCount) {  //turnCount on luku paljonko keskusteluita on ollut

      pw.write(KotipsykiatriText.commands(i) + "\n")  //käyttäjän laittamat tekstit
      if (i == Turn.turnCount - 1) {
        pw.close()  
      } else {
        pw.write(KotipsykiatriText.saving(i) + "\n")  //psykiatrin laittamat tekstit
      }
    }
    pw.close()
  }
}