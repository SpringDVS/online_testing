package args

import enums.NodeRegister
class PacketHttpService(hostres: String) extends ForgeArgument {
  def this() = this("")
  
  def toArgument() : String = hostres match {
    case "" => ""
    case _ => "--http " + hostres
    
  }
}
