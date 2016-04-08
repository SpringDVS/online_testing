package args

import enums.MessageType

class PacketMessageType(msgType: MessageType.MessageType) extends ForgeArgument {
  
  def this() = this(enums.MessageType.Default)
  
  override def toArgument() : String = msgType match {
      case MessageType.GsnArea => "--msg-type gsn_area"
      case MessageType.GsnTypeRequest => "--msg-type gsn_type_request"
      case MessageType.Undefined => "--msg-type gsn_undefined"
      case _ => ""
    }

}