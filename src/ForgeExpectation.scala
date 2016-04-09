import enums.ExpectationResult
import enums.Frame



class ForgeExpectation(map: Map[String,String]) {
  var result : ExpectationResult.Value = ExpectationResult.None
  var frame : Frame.Value = Frame.None
  var content : String = ""
  
  
  map.foreach {
    t => t._1 match {
      
      case "Result" => try {
        result = ExpectationResult.withName(t._2)
      } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown ExpectationType enum `" + t._2 + "`") }

      case "Frame" => try {
        frame = Frame.withName(t._2)
      } catch { case _ : Throwable => throw new IllegalArgumentException("Exception: unknown Frame enum `" + t._2 + "`") }

      case "Content" => content = t._2
      
      case _ => throw new IllegalArgumentException("Exception: unknown Expectation selector `"+t._1+"` (enum `" + t._2 + "`)")
   }
      
  }
      
}