import enums._
import args._

object TestConstructor {
  def build(source: String, global_addr: String) : ForgeTest = {
    
    val name = extractName(source)
    val net = extractNetwork(source)
    val forge = extractForge(source)
    val kvp = extractKeyValue(forge)
    
    val kvp_final = kvp.contains("MessageTarget") match {
      case false => kvp + ("MessageTarget" -> global_addr)
      case true => kvp
    }
    
    
    val expects = extractExpects(source)
    val exp = extractKeyValue(expects)
    try {
      return new ForgeTest(name, net, new args.Collection(kvp_final), new ForgeExpectation(exp))
    } catch {
      case e : Throwable => throw new IllegalArgumentException("Failed to construct `"+name+"`-\n\t" + e.getMessage())
    }
  }
  
  def extractName(source: String) : String = {
    
    val rx = """name:\s*([a-zA-Z0-9\s]*),""".r

    rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
    }    
    return ""
  }
  
  def extractNetwork(source: String) : String = {
    
    val rx = """network:\s*([a-zA-Z0-9\s]*),""".r

    rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
    }    
    return "local"
  }
  
  def extractForge(source: String) : String = {
     val rx = """forge\s*\{([a-zA-Z0-9\s:,/;\.]*)\}""".r
     
     rx.findAllIn(source).matchData foreach {
      m => {
        return m.group(1)
      }
     }    
    return ""
  }

  def extractExpects(source: String) : String = {
     val rx = """expects\s*\{\s*([a-zA-Z0-9\s:;/,\.]*)\}""".r
     
     rx.findAllIn(source).matchData foreach {
      m => return m.group(1)
     }    
    return ""
  }
  
  def extractKeyValue(source: String) : Map[String,String] = {
    
    val rx = """([\:a-zA-z0-9]+)\s*\:\s*([:a-zA-Z0-9,/;\.]+),+""".r

    return rx.findAllIn(source).matchData.map { 
      t => t.groupCount match {
            case 2 => t.group(1) -> t.group(2)
            case _ => t.group(1) -> ""
        }
 
     } toMap
   
  }
}