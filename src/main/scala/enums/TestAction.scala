package main.scala.enums

object TestAction extends Enumeration {
    type TestAction = Value
    val Reset, UpdateAddress, Default = Value
}