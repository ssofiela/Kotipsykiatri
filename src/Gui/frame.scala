package Gui

import scala.swing._
import scala.swing.event._
import duuni._


/** The singleton object `RandomTextApp` represents the Random Text application.
  * The object serves as a possible entry point for the game, and can be run to  
  * start up a graphical user interface. 
  *
  * The application provides end user access to the functionality provided by the 
  * class [[o1.randomtext.RandomTextGenerator]]. There is a text field for providing 
  * a data source for random text generation, and a text area for displaying the 
  * text produced. A button is available that the user can click to indicate that 
  * they wish to generate a new batch of nonsense.
  *
  * '''NOTE TO STUDENTS: This class is discussed in further detail in Chapter 11.2
  * of the course materials.''' */
object frame extends SimpleSwingApplication {

 private val game = new Kysymykset
  // Components: 
  
  val prompt = new Label("Message:")
  val sourceField = new TextField("write here", 50)
  val randomizeButton = new Button("send")
  
  val outputArea = new TextArea

//  val outputArea = new TextArea("Random stuff will appear here.", 30, 85)
  outputArea.editable = false
  outputArea.lineWrap = true
  

  
  // Layout: 
  
  val topRow = new FlowPanel
  topRow.contents += prompt
  topRow.contents += sourceField
  topRow.contents += randomizeButton

  val wholeLayout = new BoxPanel(Orientation.Vertical)
  wholeLayout.contents += topRow
  //wholeLayout.contents += outputArea
  
  val window = new MainFrame
  window.title = "Kotipsykiatri"
  window.resizable = false
  window.contents = wholeLayout
  
  def top = this.window
  
  //val random = new RandomTextGenerator(9)
  
  this.listenTo(randomizeButton)
  this.reactions += {
  case clickEvent: ButtonClicked =>
    
   
    //outputArea.text = random.randomize(sourceField.text)
    //outputArea.wordWrap = true
  }
  
}


