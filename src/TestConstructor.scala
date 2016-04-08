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
    
    val forge = extractForge(testline)
    val kvp = extractKeyValue(forge)
    return new ForgeTest(new args.Collection(kvp))
  }
  
  def extractName(source: String) : String = {
    
    val rx = """name:\s*([a-zA-Z0-9\s]*),""".r

    rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
    }    
    return ""
  }
  
  def extractForge(source: String) : String = {
     val rx = """forge\s*\{([a-zA-Z0-9\s:,;\.]*)\}""".r
     
     rx.findAllIn(source).matchData foreach {
      m => {
        return m.group(1)
      }
     }    
    return ""
  }

  def extractExpects(source: String) : String = {
     val rx = """expects\s*\{\s*([a-zA-Z0-9\s:,\.]*)\}""".r
     
     rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
     }    
    return ""
  }
  
  def extractKeyValue(source: String) : Map[String,String] = {
    
    val rx = """([\:a-zA-z0-9]+)\s*\:\s*([:a-zA-Z0-9,;\.]+),+""".r

    return rx.findAllIn(source).matchData.map { 
      t => t.groupCount match {
            case 2 => t.group(1) -> t.group(2)
            case _ => t.group(1) -> ""
        }
 
     } toMap
   
  }
}