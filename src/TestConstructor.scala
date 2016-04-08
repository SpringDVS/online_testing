import enums._
import args._

object TestConstructor {
  def build(testline: String) : ForgeTest = {
    
    // Set everything to default
    val msgType = MessageType.Default
    val msgTarget = ""
    val nodeType = NodeType.Default
    val nodeState = NodeState.Default
    val nodeService = NodeService.Default
    val nodeRegister = NodeRegister.Default
    val textContent = ""
    
    println(extractName(testline))
    println(extractForge(testline))
    println(extractExpects(testline))
    
    return new ForgeTest(
                new PacketMessageType(msgType),
                new PacketMessageTarget(msgTarget),
                new PacketNodeType(nodeType),
                new PacketNodeState(nodeState),
                new PacketNodeService(nodeService),
                new PacketNodeRegister(nodeRegister),
                new PacketTextContent(textContent)
              )
  }
  
  def extractName(source: String) : String = {
    
    val rx = """name:\s*([a-zA-z0-9\s]*),""".r

    rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
    }    
    return ""
  }
  
  def extractForge(source: String) : String = {
     val rx = """forge\s*\{\s*([a-zA-z0-9\s:]*)\}""".r
     
     rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
     }    
    return ""
  }

  def extractExpects(source: String) : String = {
     val rx = """expects\s*\{\s*([a-zA-z0-9\s:]*)\}""".r
     
     rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
     }    
    return ""
  }
}