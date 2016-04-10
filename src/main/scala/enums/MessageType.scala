package enums

object MessageType extends Enumeration {
    type MessageType = Value
    val GsnArea, GsnTypeRequest, GsnNodeInfo, Undefined, Default = Value
}