import args._

class ForgeTest(name: String, collection: args.Collection, expectation: ForgeExpectation) {
  def expectation() : ForgeExpectation = expectation
  def name() : String = name
  
  override def toString() : String = 
     "--unit-test" + 
     " " + collection.msgType.toArgument() +
     " " + collection.msgTarget.toArgument() +
     " " + collection.nodeType.toArgument() +
     " " + collection.nodeState.toArgument() +
     " " + collection.nodeService.toArgument() +
     " " + collection.nodeRegister.toArgument() +
     " " + collection.testAction.toArgument() +
     " " + collection.textContent.toArgument()
}