import args._

class ForgeTest(name: String, net: String, collection: args.Collection, expectation: ForgeExpectation) {
  def expectation() : ForgeExpectation = expectation
  def name() : String = name
  def network() : String = net
  
  override def toString() : String = 
     "--unit-test" + 
     " " + collection.msgType.toArgument() +
     " " + collection.msgTarget.toArgument() +
     " " + collection.nodeType.toArgument() +
     " " + collection.nodeState.toArgument() +
     " " + collection.nodeService.toArgument() +
     " " + collection.nodeRegister.toArgument() +
     " " + collection.testAction.toArgument() +
     " " + collection.httpService.toArgument() +
     " " + collection.textContent.toArgument()
}