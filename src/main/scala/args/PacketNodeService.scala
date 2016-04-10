package args
import enums.NodeService;
class PacketNodeService(nodeService: NodeService.Value) extends ForgeArgument {
  
  def this() = this(NodeService.Default)
  
  def toArgument : String = nodeService match {
    case NodeService.Dvsp => "--node-service dvsp"
    case NodeService.Http => "--node-service http"
    case _ => ""
  }
  
}