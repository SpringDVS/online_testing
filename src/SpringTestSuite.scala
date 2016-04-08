import args._



object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")
  
  var testBuild = 
    """
test {

  name: Test 100,
  
  forge {
    MessageType: GsnArea
  },
  
  expects {
    Response:FrameNetwork
  }
} 
"""
  
  var ft = TestConstructor.build(testBuild);
  
  println(ft)
  
}