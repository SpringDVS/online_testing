import args._



object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")
 
  var testBuild = 
    """
test {

  name: Test 100,
  
  forge {
    MessageType: GsnArea,
  },
  
  expects {
    Result: Response,
    Frame: FrameNetwork,
    Content: randomstuff,
  }
} 
"""
  try {
    var unit = TestConstructor.build(testBuild);
    
    ForgeCmd.run(unit)
  } catch {
    case e : Throwable => System.err.println(e.getMessage())
  }
  
 
  
}