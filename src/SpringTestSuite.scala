import args._



object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")
 
  var testBuild = 
    """
test (

  name: Test 0x1,
  
  forge {
    MessageType: GsnArea,
  },
  
  expects {
    Result: Response,
    Frame: FrameNetwork,
  }
),

test (

  name: Test 0x2,
  
  forge {
    MessageType: GsnArea,
  },
  
  expects {
    Result: Response,
    Frame: FrameNetwork,
  }
)
"""
  val rx = """test\s*\(\s*([a-zA-Z0-9\s:,\.{}])*\)""".r
  
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