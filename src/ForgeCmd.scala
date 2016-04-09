import scala.sys.process._
import enums.ExpectationResult

object ForgeCmd {
  def run(unit: ForgeTest) = {
    println("Test: "+unit.name())
    val cmd = "/home/cfg/Scripts/springforge " + unit
    val output = cmd.!!
    
    check(output.trim() , unit.expectation())
  }
  
  def check(output: String, expect: ForgeExpectation) : Boolean = {
    output.substring(0, 2) match {
      case "!!" => {
            println("FAIL: `" + output.substring(3) + "`")
            return false
      }
      
      case _ => { }
    }
    
    val v = output.substring(3)
    val step1 = v.split("\\|",2)
    
    expect.result match {
      case ExpectationResult.Response => step1.apply(0) match {
        case "Response" => { }
        case _ => { 
          println("FAIL: wanted `response` got `" + step1.apply(0) + "`")
          return false
        }
      }
    }
    
    val step2 = step1.apply(1).split(":",2)
    val eresult = expect.result
    try {
      if(enums.Frame.withName(step2.apply(0)) != expect.frame){ 
          println("FAIL: wanted `"+expect.frame+"` got `" + step2.apply(0) + "`")
          return false
        }
    } catch {
      case _ : Throwable => {return false }
    }
    
    if(expect.content.length() > 0 &&
      expect.content != step2.apply(1)) {
      println("FAIL: wanted `"+expect.content+"` got `" + step2.apply(1) + "`")
      return false
    }
    
    
    
    println("PASS")
    return true
  }
}