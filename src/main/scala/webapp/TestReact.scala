package webapp

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import org.scalajs.jquery.jQuery
import scala.scalajs.js.annotation.JSExportTopLevel

object TestReact extends JSApp {
  def setupUI(): Unit = {
    jQuery("""<button type="button">Click me!</button>""")
      .click(addClickedMessage _)
      .appendTo(jQuery("body"))
    jQuery("body").append("<p>Hello World</p>")
  }


  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }
  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def main(): Unit = {
    jQuery(() => setupUI())
  }
}

