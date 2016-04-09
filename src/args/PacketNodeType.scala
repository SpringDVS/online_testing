package args

import enums.NodeType

class PacketNodeType(nodeType: enums.NodeType.Value) extends ForgeArgument {
    
  def this() = this(NodeType.Default)
  
  override def toArgument() : String = nodeType match {
    case NodeType.Org => "--node-type org"
    case NodeType.Root => "--node-type root"
    case _ => ""
  }
}