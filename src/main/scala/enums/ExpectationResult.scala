package enums

object ExpectationResult extends Enumeration {
  type ExpectationType = Value
  val Response,FailDeserialise,Fail,None = Value
}