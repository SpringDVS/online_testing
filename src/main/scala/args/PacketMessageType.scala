package args

import enums.MessageType

class PacketMessageType(msgType: MessageType.Value) extends ForgeArgument {
  
  def this() = this(enums.MessageType.Default)
  
  override def toArgument() : String = msgType match {
      case MessageType.GsnArea => "--msg-type gsn_area"
      case MessageType.GsnRegistration => "--msg-type gsn_registration"
      case MessageType.GsnTypeRequest => "--msg-type gsn_type_request"
      case MessageType.GsnNodeInfo => "--msg-type gsn_node_info"
      case MessageType.GsnStateUpdate => "--msg-type gsn_state_update"
      case MessageType.GsnNodeStatus => "--msg-type gsn_node_status"
      case MessageType.UnitTest => "--msg-type gsn_unit_test"
      case MessageType.Undefined => "--msg-type gsn_undefined"
      
      case _ => ""
    }

}