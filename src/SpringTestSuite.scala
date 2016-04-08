import args.PacketMessageType


object SpringTestSuite extends App {
  println("Spring DVS Online Test Suite")

  var ft = new ForgeTest(new PacketMessageType(enums.MessageType.GsnArea));
  
  println(ft)
  
}