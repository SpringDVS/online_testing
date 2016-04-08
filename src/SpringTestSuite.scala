import args._



object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")
  
  var ft = new ForgeTest(
                new PacketMessageType(enums.MessageType.GsnTypeRequest),
                new PacketMessageTarget("127.0.0.1:55301"),
                new PacketNodeType(enums.NodeType.Org),
                new PacketNodeState(enums.NodeState.Enabled),
                new PacketNodeService(enums.NodeService.Http),
                new PacketNodeRegister(enums.NodeRegister.True),
                new PacketTextContent("foobar")
              );
  
  println(ft)
  
}