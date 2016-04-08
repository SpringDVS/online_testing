import args._



object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")
 
  var testBuild = 
    """
test {

  name: Test 100,
  
  forge {
    MessageType: GsnArea,
    MessageTarget: 127.0.0.1:55301,
    NodeType: Org,
    NodeState: Enabled,
    NodeService: Http,
    NodeRegister: True,
    TextContent: hello,world,foobar;,
  },
  
  expects {
    Response:FrameNetwork,
  }
} 
"""
  
  var ft = TestConstructor.build(testBuild);
  
  println(ft)
  
}