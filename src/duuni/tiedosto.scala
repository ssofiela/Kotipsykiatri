package duuni

import scala.io.Source
import java.io.IOException
import java.io.Reader
import java.io.FileReader
import duuni._

import scala.collection.mutable.Buffer

class tiedosto {
  //val kysymykset = io.Source.fromFile("tekoaly.txt").getLines.toList
  //val reader = new FileReader("tekoaly.txt")

  var kysymykset = Buffer[String]()
  val fileName = "tekoaly.txt"
  try {

    for (line <- Source.fromFile(fileName).getLines()) {
      //println(line)   NÄÄ VOI MYÖHEMMIN AUTTAA
      kysymykset += line
     // println(kysymykset)   
    }
 /* } catch {
    case ex: Exception => println("öööö")*/

  }

  /*

  def loadGame(input: Reader) = {

    /**
     * This is the game object this method will fill with data. The object
     * is returned when the END chunk is reached.
     */

    // Use these variables for reading all of the file header, date and chunk headers.
    // HINT: Check the helper methods in the end of this class. See an example few
    // lines below for reading the header and date.
    //var aloitus = new Array[String](26)
    //var kysymys1 = new Array[String](8)
    //var kysymys2 = new Array[String](10)
    var chunkHeader = new Array[Char](0)
    //var comment = new Array[Char](54)
    //var kokonaan = new Array[Char](100)
    //var playerss = new Array[Char](17)
    //var chunk = Helpers.extractChunkSize(chunkHeader)

    try {

      var chunkteksti = new Array[Char](0)

      // Read the file header and the save date
      //Helpers.readFully(aloitus, input);
      //Helpers.readFully(kysymys1, input);

      //Helpers.readFully(kysymys2, input);
      // Helpers.readFully(chunkHeader, input);
      // Helpers.readFully(comment, input);
      //Helpers.readFully(nappulat, input);

      // Process the data we just read.
      // NOTE: To test the line below you must test the class once with a broken header.
      /*if (aloitus.mkString.startsWith("aloitus=")) {
        
      }
        throw new tiedosto("Unknown file type");
      */

      //while ( != "END") {
        println("ei tää loppu ny")
        /*if (Helpers.extractChunkName(chunkHeader) != "eka") {
          chunkteksti = new Array[String](Helpers.extractChunkSize(chunkHeader))
          Helpers.readFully(chunkteksti, input)
          println(chunkteksti.mkString)
          println("moi")
           Helpers.readFully(chunkHeader, input)*/
        /*} else {
          pelaajako()
          Helpers.readFully(chunkHeader, input)
        }*/
          
  for(line <- Source.fromFile(fileName).getLines()){
        if (line == "Doctor: Hello, What is your name") {
          kysymykset += line
        } else {
          println("ei löydy helloo")
        }
  }
    }
  }
}
  
        

      /*  if (Helpers.extractChunkName(chunkHeader) == "Doctor: Nice to meet you ") {
          chunkteksti = new Array[Char](Helpers.extractChunkSize(chunkHeader))
       //   Helpers.readFully(chunkteksti, input)
        } else {
          println("ei löydy nice to meet you")
        }

      }*/
  //  }

    /*   def aloitus = {
      
    
      if (Helpers.extractChunkName(aloitus) == "aloitus=") {
          aloitus = new Array[Char](Helpers.extractChunkSize(chunkHeader))
          Helpers.readFully(aloitus, input)

          val nimikoko = chunkteksti(1).asDigit
          val nimi = chunkteksti.mkString.drop(2).take(nimikoko)
      }
    }*/
  //}
//}

/*object Helpers {

    /**
     * Given a chunk header (an array of 5 chars) will return the size of this
     * chunks data.
     *
     * @param chunkHeader a chunk header to process
     * @return the size of this chunks data
     */
    //def extractChunkSize(chunkHeader: Array[Char]): Int = {

      // Subtracting the ascii value of the character 0 from
      // a character containing a number will return the
      // number itself.
      10 * (chunkHeader(3) - '0') + (chunkHeader(4) - '0')
    }

    /**
     * Given a chunk header (an array of 5 chars) will return the name of this
     * chunk as a 3-letter String.
     *
     * @param chunkHeader a chunk header to process
     * @return the name of this chunk
     */
    def extractChunkName(chunkHeader: Array[Char]): String = {
      chunkHeader.take(3).mkString
    }

    /**
     * The read-method of the Reader class will occasionally read only part of
     * the characters that were requested. This method will repeatedly call read
     * to completely fill the given buffer. The size of the buffer tells the
     * algorithm how many bytes should be read.
     *
     * @param result the result of the reading will be stored in this array
     * @param input a character stream to read from
     * @throws IOException
     * @throws CorruptedChessFileException if end of file is reached before
     *    buffer is filled
     */
    def readFully(result: Array[Char], input: Reader) = {
      var cursor = 0
      while (cursor != result.length) {
        var numCharactersRead = input.read(result, cursor, result.length - cursor)

        // If the file end is reached before the buffer is filled
        // an exception is thrown.
        if (numCharactersRead == -1) {
          throw new CorruptedChessFileException("Unexpected end of file.")
        }
        cursor += numCharactersRead
      }*/
    //}*/
}
  




      /* header = new Array[Char](8)
    var date = new Array[Char](8)
    var chunkHeader = new Array[Char](5)*/