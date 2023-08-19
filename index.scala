trait PersonModel:
  val name: String
  val age: Int
  val document: BigInt

trait ManagerPerson:
  def createPerson(person: PersonModel): Unit

  def viewPersons(): Unit

class ManagerArrayPerson() extends ManagerPerson:
  private var people: Vector[PersonModel] = Vector[PersonModel]()

  def createPerson(person: PersonModel): Unit =
    people = people :+ person

  def viewPersons(): Unit =
    people.foreach((element) => println(s"Name:  ${element.name} --- Age: ${element.age}"))

class Client(val managerPerson: ManagerPerson):

  def executeCreatePerson(personModel: PersonModel): Unit =
    managerPerson.createPerson(personModel)

  def executeViewPerson(): Unit =
    managerPerson.viewPersons()

@main def main(): Unit =
  val managerPerson: Client = new Client(new ManagerArrayPerson)
  val luis = new PersonModel:
    override val name: String = "Josh"
    override val age: Int = 26
    override val document: BigInt = 1144200150
  val natalia = new PersonModel:
    override val name: String = "Sahn"
    override val age: Int = 28
    override val document: BigInt = 432200150
  managerPerson.executeCreatePerson(luis)
  managerPerson.executeCreatePerson(natalia)

  managerPerson.executeViewPerson()
