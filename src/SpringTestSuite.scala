import args._
import scala.io.Source


object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")
  var testBuild = Source.fromFile("units.stu").mkString
  val rx = """test\s*\(\s*([a-zA-Z0-9\s:;,\.{}])*\)""".r
  
  rx.findAllMatchIn(testBuild).foreach { 
    
    test => {
      try {
        var unit = TestConstructor.build(test.toString());
        ForgeCmd.run(unit)
      } catch {
        case e : Throwable => System.err.println(e.getMessage())
      }
    }
    
  }
    
}