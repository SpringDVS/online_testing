import args._
import scala.io.Source
import main.scala.enums.TestResult


object SpringTestSuite extends App {
    println("Spring DVS Online Test Suite")
    var testBuild = Source.fromFile("units.stu").mkString
    val rx = """(?:test|runner)\s*\(\s*([a-zA-Z0-9\s:;,\.{}])*\)""".r
    var passed = 0
    var failed = 0
    
    rx.findAllMatchIn(testBuild).foreach { 
      
      test => {
        try {
          var unit = TestConstructor.build(test.toString());
          ForgeCmd.run(unit) match {
            case TestResult.Pass => passed = passed + 1
            case TestResult.Fail => failed = failed + 1
            case TestResult.Autopass => { }
          }
        } catch {
          case e : Throwable => {
            System.err.println(e.getMessage())
            failed = failed + 1
          }
        }
      }
      
    }
    
    
    failed match {
      case 0 => println("\033[1;32mPassed "+passed+" test(s)\n----\033[0m")
      case _ => println("\n\033[1;32mPassed "+passed+" test(s)\033[0m\n\033[1;31mFailed "+failed+" test(s)\n----\033[0m")
    }
    
}