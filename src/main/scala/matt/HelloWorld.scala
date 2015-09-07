package matt

import java.io.File

/**
 * @author Matt Hicks <matt@outr.com>
 */
class HelloWorld extends HTML {
  val head = children.add(new Head)
  val body = children.add(new Body)

  val heading = body.children.add(new H1)
  heading.content := "Hello, World!"
}

trait HTMLTag

trait Container[Child <: HTMLTag] {
  object children {
    def add[T <: Child](child: T): T = {}
  }
}

class HTML extends Container[HTMLChild]

trait HTMLChild extends HTMLTag

class Head extends HTMLChild with Container[HeadChild]

class Body extends HTMLChild with Container[BodyChild]

trait HeadChild extends HTMLTag

trait BodyChild extends HTMLTag

class H1 extends BodyChild {
  val content = new Prop[String]
}

class Ul extends BodyChild

class Prop[T] {
  private var value: T = _

  def :=(value: T) = this.value = value
}