package enums

object NodeState extends Enumeration {
    type NodeState = Value
    val Enabled, Disabled, Unresponsive, Default = Value
}