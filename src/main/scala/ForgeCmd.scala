import scala.sys.process._
import enums.ExpectationResult

object ForgeCmd {
  def run(unit: ForgeTest) : Boolean = {
    println("Test: \033[1;35m"+unit.name()+"\033[0m")
    
    val cmd = "/home/cfg/Scripts/springforge " + unit
    val output = cmd.!!
    
    return check(output.trim() , unit.expectation())
  }
  
  def check(output: String, expect: ForgeExpectation) : Boolean = {
    output.substring(0, 2) match {
      case "!!" => {
            println("\033[0;31mFAIL\033[0;m: `" + output.substring(3) + "`")
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
          println("\033[0;31mFAIL\033[0;m: wanted `response` got `" + step1.apply(0) + "`")
          return false
        }
      }
      case ExpectationResult.None => { println("\033[0;32mAUTOPASS\033[0;m"); return true }
    }
    
    val step2 = step1.apply(1).split(":",2)
    
    if(expect.frame != enums.Frame.None) { 
      try {
        if(enums.Frame.withName(step2.apply(0)) != expect.frame){ 
            println("\033[0;31mFAIL\033[0;m: wanted `"+expect.frame+"` got `" + step2.apply(0) + "`")
            return false
          }
      } catch {
        case _ : Throwable => {return false }
      }
    }
    
    if(expect.content.length() > 0 &&
      expect.content != step2.apply(1)) {
      println("\033[0;31mFAIL\033[0;m: wanted `"+expect.content+"` got `" + step2.apply(1) + "`")
      return false
    }
    
    
    
    println("\033[0;32mPASS\033[0;m")
    return true
  }
}