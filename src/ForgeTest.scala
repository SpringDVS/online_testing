

class ForgeTest(msgType: Int) {
  var mType: Int = msgType
  
  override def toString() : String = "Packet.msg_type:" + mType;
}