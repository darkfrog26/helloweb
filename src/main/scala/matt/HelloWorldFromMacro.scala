package matt

import java.io.File

/**
 * @author Matt Hicks <matt@outr.com>
 */
trait HelloWorldFromMacro extends HTML {
  def head: Head
  def body: Body

  def heading: H1

  // @bySelector(".item")   // Allows arbitrary HTML selectors to be used
  def items: List[Ul]
}

object HelloWorldFromMacro extends StaticHTMLSupport {
  def create() = fromHTML[HelloWorldFromMacro](new File("hello_world.html"))
}

trait StaticHTMLSupport {
  protected def fromHTML[T <: HTMLTag](file: File) = {} // macro Macros.fromHTML
}