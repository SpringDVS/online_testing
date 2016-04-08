import args.PacketMessageType

class ForgeTest(pMsgType: PacketMessageType) {
  var mType = pMsgType
  
  override def toString() : String = "--unit-test " + 
     mType.toArgument()
}