

object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")

  val pmt = new PacketMessageType(enums.MessageType.GsnArea);
  
  println(pmt.toArgument())
  
}