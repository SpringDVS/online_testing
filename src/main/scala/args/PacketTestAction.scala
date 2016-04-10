package main.scala.args
import main.scala.enums.TestAction
import args.ForgeArgument

class PacketTestAction(action: TestAction.Value) extends ForgeArgument {
  def this() = this(TestAction.Default)
  
  override def toArgument() : String = action match {
    case TestAction.Reset => "--test-action reset"
    case _ => ""
  }
}