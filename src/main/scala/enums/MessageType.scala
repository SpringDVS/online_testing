package enums

object MessageType extends Enumeration {
    type MessageType = Value
    val GsnArea, GsnTypeRequest, GsnNodeInfo, 
      GsnRegistration, GsnNodeStatus, GsnStateUpdate,
      Undefined, UnitTest, Default = Value
}