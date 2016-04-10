package main.scala.enums

object TestResult extends Enumeration {
  type TestResult = Value
  val Pass,Autopass,Fail = Value
}