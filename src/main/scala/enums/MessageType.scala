package enums

object MessageType extends Enumeration {
    type MessageType = Value
    val GsnArea, GsnTypeRequest, GsnNodeInfo, 
      GsnRegistration, GsnNodeStatus, GsnStateUpdate,
      GsnResolution,
      GtnGeosubNodes, GtnRegistration,
      Undefined, UnitTest, Default = Value
}
