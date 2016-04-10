package args
import enums.NodeState
class PacketNodeState(nodeState: NodeState.Value) extends ForgeArgument {
  
  def this() = this(NodeState.Default)
  
  def toArgument() : String = nodeState match {
    case NodeState.Enabled => "--node-state enabled"
    case NodeState.Disabled => "--node-state disabled"
    case NodeState.Unresponsive => "--node-state unresponsive"
    case _ => ""
  }
  
}