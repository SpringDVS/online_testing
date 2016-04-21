package args
import enums._
import main.scala.args.PacketTestAction

class Collection(map:Map[String,String]) {
  var msgType = new PacketMessageType()
  var msgTarget = new PacketMessageTarget()
  var nodeType = new PacketNodeType()
  var nodeState = new PacketNodeState()
  var nodeService = new PacketNodeService()
  var nodeRegister = new PacketNodeRegister()
  var textContent = new PacketTextContent()
  var testAction = new PacketTestAction()
  var httpService = new PacketHttpService()
  
  map.foreach {
    p => p._1 match {
      case "MessageType" => {
        try { 
          msgType = new PacketMessageType(MessageType.withName(p._2)) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown MessageType enum `" + p._2 + "`") }
      }
      
      case "MessageTarget" => {
        msgTarget = new PacketMessageTarget(p._2) 
      }
      
      case "NodeType" => {
        try { 
          nodeType = new PacketNodeType(NodeType.withName(p._2)) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown NodeType enum `" + p._2 + "`") }
      }

      case "NodeState" => {
        try { 
          nodeState = new PacketNodeState(NodeState.withName(p._2)) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown NodeState enum `" + p._2 + "`") }
      }
      
      case "NodeService" => {
        try { 
          nodeService = new PacketNodeService(NodeService.withName(p._2)) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown NodeService enum `" + p._2 + "`") }
      }
      
      case "NodeRegister" => {
        try { 
          nodeRegister = new PacketNodeRegister(NodeRegister.withName(p._2)) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown NodeRegister enum `" + p._2 + "`") }
      }

       case "TestAction" => {
        try { 
          testAction = new PacketTestAction(main.scala.enums.TestAction.withName(p._2)) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown TestAction enum `" + p._2 + "`") }
      }

      case "Http" => {
        try { 
          httpService = new PacketHttpService(p._2) 
        } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown TestAction enum `" + p._2 + "`") }
      }

      case "TextContent" => {
        textContent = new PacketTextContent(p._2) 
      }
      case _ => { throw new IllegalArgumentException("Exception: unknown Argument Selector `"+p._1+"` (with enum `" + p._2 + "`)") }
    }
  }
  
}