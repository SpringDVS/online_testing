package enums

object MessageType extends Enumeration {
    type MessageType = Value
    val GsnArea, GsnTypeRequest, GsnNodeInfo, Undefined, UnitTest, Default = Value
}