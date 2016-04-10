package args
import enums.NodeRegister
class PacketNodeRegister(nodeRegister: NodeRegister.Value) extends ForgeArgument {
  def this() = this(NodeRegister.Default)
  
  def toArgument() : String = nodeRegister match {
    case NodeRegister.True => "--node-register true"
    case NodeRegister.False => "--node-register false"
    case _ => ""
  }
}
