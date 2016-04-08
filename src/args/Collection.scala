package args
import enums._

class Collection(map:Map[String,String]) {
  var msgType = new PacketMessageType()
  var msgTarget = new PacketMessageTarget()
  var nodeType = new PacketNodeType()
  var nodeState = new PacketNodeState()
  var nodeService = new PacketNodeService()
  var nodeRegister = new PacketNodeRegister()
  var textContent = new PacketTextContent()
  
  map.foreach {
    p => p._1 match {
      case "MessageType" => {
        try { 
          msgType = new PacketMessageType(MessageType.withName(p._2)) 
        } catch { case _ : Throwable => }
      }
      
      case "MessageTarget" => {
        msgTarget = new PacketMessageTarget(p._2) 
      }
      
      case "NodeType" => {
        try { 
          nodeType = new PacketNodeType(NodeType.withName(p._2)) 
        } catch { case _ : Throwable => }
      }

      case "NodeState" => {
        try { 
          nodeState = new PacketNodeState(NodeState.withName(p._2)) 
        } catch { case _ : Throwable => }
      }
      
      case "NodeService" => {
        try { 
          nodeService = new PacketNodeService(NodeService.withName(p._2)) 
        } catch { case _ : Throwable => }
      }
      
      case "NodeRegister" => {
        try { 
          nodeRegister = new PacketNodeRegister(NodeRegister.withName(p._2)) 
        } catch { case _ : Throwable => }
      }

      case "TextContent" => {
        textContent = new PacketTextContent(p._2) 
      }
      case _ => { }
    }
  }
  
}