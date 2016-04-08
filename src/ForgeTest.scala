import args._

class ForgeTest(
                  msgType: PacketMessageType,
                  msgTarget: PacketMessageTarget,
                  nodeType: PacketNodeType, 
                  nodeState: PacketNodeState,
                  nodeService: PacketNodeService,
                  nodeRegister: PacketNodeRegister,
                  textContent: PacketTextContent
               ) {
  
  override def toString() : String = 
     "--unit-test" + 
     " " + msgType.toArgument() +
     " " + msgTarget.toArgument() +
     " " + nodeType.toArgument() +
     " " + nodeState.toArgument() +
     " " + nodeService.toArgument() +
     " " + nodeRegister.toArgument() +
     " " + textContent.toArgument()
}