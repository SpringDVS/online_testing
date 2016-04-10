package args

class PacketMessageTarget(target: String) extends ForgeArgument {
  
  def this() = this("")
  
  def toArgument() : String = target match {
    case "" => ""
    case _ => "--msg-target " + target
  }
}