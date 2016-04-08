package args

import enums.MessageType

class PacketMessageType(msgType: enums.MessageType.MessageType) extends ForgeArgument {
  
  var ptype : enums.MessageType.MessageType = msgType
  
  override def toArgument() : String = this.ptype match {
      case MessageType.GsnArea => "--msg-type gsn_area"
      case MessageType.GsnTypeRequest => "--msg-type gsn_type_request"
      case _ => ""
    }

}