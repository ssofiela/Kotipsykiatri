package Gui

import scala.swing._
import scala.swing.event._
import javax.swing.UIManager
import scala.io.StdIn._
import duuni._

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
    private val games = new alkuja
    private val vastaus = new vastaukset
    var gameOn = true

    // Components: 

    val locationInfo = new TextArea(5, 40) { // oli 7, 80
     // editable = false
      //wordWrap = true
      //lineWrap = true
    }
    val turnOutput = new TextArea(5, 40) { // oli 7, 10
     // editable = false
      //wordWrap = true
      //lineWrap = true
    }
    val input = new TextField(40) { // oli 40
      minimumSize = preferredSize
    }
    this.listenTo(input.keys)
    val turnCounter = new Label

    // Events: 

    this.reactions += {
      case keyEvent: KeyPressed =>
        //if (keyEvent.source == this.input && keyEvent.key == Key.Enter && !game.loppunut()) {
         // val command = this.input.text.trim
          if (gameOn) {
            println("jee oon reaktioissa")
            this.input.text = ""
            this.updateInfo()
            this.run()
          //}
        }
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
    //this.updateInfo(this.game.welcomeMessage)
    // this.location = new Point(50, 50)
    //this.minimumSize = new Dimension(200, 200) // 200, 200
    //this.pack()
    //this.input.requestFocusInWindow()

    def run() = {
    /*  println("tuli runniin")
      println(game.alku())
      if (game.Ending()) {
        game.End
      } else {
        game.question1()
      }
      if (game.Ending()) {
        game.End
      } else {*/
      //  game.question2()
        //println("Toinen kysymys kysytty hurraa :D")
    //  }
    /*  if (game.loppunut()) {
        game.lopetus
      } else {
        game.kysymys3()
      }
      if (game.loppunut()) {
        game.lopetus
      } else {
        game.kysymys4()
      }
*/
    }

    def updateInfo() = {
      println("updateInfo")
     /* if (!this.game.loppunut()) {
        if (game.loppunut()) {
          game.lopetus
        } else {
          game.kysymys1()
        }
        if (game.loppunut()) {
          game.lopetus
        } else {
          game.kysymys2()
          //println("Toinen kysymys kysytty hurraa :D")
        }
        if (game.loppunut()) {
          game.lopetus
        } else {
          game.kysymys3()
        }
        if (game.loppunut()) {
          game.lopetus
        } else {
          game.kysymys4()
        }*/

        //this.turnOutput.text = info
     // } else {
        println("tää loppuu nyt tän mukaan")
     // }
      //this.turnOutput.text = info + "\n\n" + this.game.goodbyeMessage
      //}
      //this.locationInfo.text = this.player.location.fullDescription
      //this.turnCounter.text = "Turns played: " + this.game.turnCount
    }

  }

}  
  

