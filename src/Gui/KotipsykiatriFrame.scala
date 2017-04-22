package Gui

import scala.swing._
import scala.swing.event._
import javax.swing.UIManager
import scala.io.StdIn._
import duuni._
import scala.collection.mutable.Buffer
import scala.io.StdIn.readLine

////////////////// NOTE TO STUDENTS //////////////////////////
// For the purposes of our course, it's not necessary    
// that you understand or even look at the code in this file.
//////////////////////////////////////////////////////////////

/**
 * The singleton object `GUI` represents a GUI-based version of the
 * game application. The object serves as a possible entry point for the game, and can
 * be run to start up a user interface that operates in a separate window. The GUI reads
 * its input from a text field and displays information about the game world in uneditable
 * text areas.
 *
 * '''NOTE TO STUDENTS: In this course, you don't need to understand how this object works
 * or can be used, apart from the fact that you can use this file to start the program.'''
 *
 * @see [[TextUI]]
 */
object KotipsykiatriFrame extends SimpleSwingApplication {

  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)

  def top = new MainFrame {

    // Access to the internal logic of the application: 

    // private val game = new Kysymykset
    private val A = new alkuja
    private val V = new vastaukset
    private val T = new tiedosto
    var gameOn = true

    var currentCommand = ""
    var bufferiin = Buffer[String]() // nyt tääl on kaikki
    // Components: 

    val locationInfo = new TextArea(5, 40) { // oli 7, 80
      editable = false
      wordWrap = true
      lineWrap = true
    }
    val turnOutput = new TextArea(5, 40) { // oli 7, 10
      editable = false
      wordWrap = true
      lineWrap = true
    }
    val input = new TextField(40) { // oli 40
      minimumSize = preferredSize
    }
    this.listenTo(input.keys)
    val turnCounter = new Label

    // Events: 

    this.reactions += {
      case keyEvent: KeyPressed =>
        if (keyEvent.source == this.input && keyEvent.key == Key.Enter && gameOn) {
          this.updateInfo()

        }
        val command = this.input.text.trim

      //	  this.run()

      // this.input.text = "help help"
      //}

    }

    // Layout: 

    this.contents = new GridBagPanel {
      import scala.swing.GridBagPanel.Anchor._
      import scala.swing.GridBagPanel.Fill
      layout += new Label() -> new Constraints(0, 0, 1, 1, 0, 1, NorthWest.id, Fill.None.id, new Insets(8, 5, 5, 5), 0, 0)
      layout += new Label("Message:") -> new Constraints(0, 1, 1, 1, 0, 0, NorthWest.id, Fill.None.id, new Insets(8, 5, 5, 5), 0, 0)
      //layout += new Label("Events:") -> new Constraints(0, 2, 1, 1, 0, 0, NorthWest.id, Fill.None.id, new Insets(8, 5, 5, 5), 0, 0)
      layout += turnCounter -> new Constraints(0, 3, 2, 1, 0, 0, NorthWest.id, Fill.None.id, new Insets(8, 5, 5, 5), 0, 0)
      layout += locationInfo -> new Constraints(1, 0, 1, 1, 1, 1, NorthWest.id, Fill.Both.id, new Insets(5, 5, 5, 5), 0, 0)
      layout += input -> new Constraints(1, 1, 1, 1, 1, 0, NorthWest.id, Fill.None.id, new Insets(5, 5, 5, 5), 0, 0)
      layout += turnOutput -> new Constraints(1, 2, 1, 1, 1, 1, SouthWest.id, Fill.Both.id, new Insets(5, 5, 5, 5), 0, 0)
    }

    // Menu:

    this.menuBar = new MenuBar {
      contents += new Menu("Program") {
        val quitAction = Action("Quit") { dispose() }
        contents += new MenuItem(quitAction)
      }
    }

    // Set up the initial state of the GUI:

    //this.title = game.title
    //    this.updateInfo("Doctor: good morning")
    // this.location = new Point(50, 50)
    //this.minimumSize = new Dimension(200, 200) // 200, 200
    //this.pack()
    //this.input.requestFocusInWindow()

    def updateInfo() = {
      
    	this.locationInfo.text += "Doctor: Hello, What´s your name?"
      while (loppunut2(currentCommand)) {
       
        val newCommand = readLine("Message: ")
        currentCommand = newCommand
        //println("bufferiin:" + bufferiin)

        if (currentCommand.length > 0) {
          bufferiin += newCommand
          this.locationInfo.text += newCommand
          println("newCommand locationissa" + newCommand)
          //        tee += currentCommand
          //        tl.oo
          val turnReport = A.playTurn(currentCommand)
          //         too += turnReport
          //        tl.aa
          this.locationInfo.text += turnReport
        } else {

          this.locationInfo.text += "Pls say something!"

        }
      }
      val r = scala.util.Random
      r.nextInt(2)
      if (r == 1) {
        this.locationInfo.text += "Doctor:" + T.ask(24) + V.name + " " + T.ask(25) //(games.lopetus1) // voi laittaa randomilla valisemaan mikä lopetus
      } else {
        this.locationInfo.text += "Doctor: " + T.ask(26) + V.name + " " + T.ask(25)
      }
    }
    /* } else {
        this.turnOutput.text += "jou" + "\n\n" + "täähän loppu"//this.game.goodbyeMessage
      }
      this.locationInfo.text += "TURHAA?"
      this.turnCounter.text += "Turns played: " + games.playTurn(currentCommand)*/

    //  var tee = Buffer[String]()
    //  var too=  Buffer[String]()

    /* while (loppunut2(currentCommand)) {
        val newCommand = readLine("Message: ")
        currentCommand = newCommand
        println("bufferiin:" + bufferiin)
        //Tarkasta, että käyttäjä kirjoitti jotain
        if (currentCommand.length > 0) {
          bufferiin += newCommand //tässä koska silloin tyhjiä ei lisätä bufferiin
          //        tee += currentCommand
          //        tl.oo
          val turnReport = A.playTurn(currentCommand)
          //         too += turnReport
          //        tl.aa
          println(turnReport)
        } else {

          println("Pls say something!")

        }
      }*/

  }
  def loppunut2(s: String): Boolean = { //TOIMIIIIII
    var splitted = s.split(" ")
    for (i <- splitted) {
      if (i == "bye" || i == "goodbye") {
        return false
      }
    }
    true
  }
}

  

