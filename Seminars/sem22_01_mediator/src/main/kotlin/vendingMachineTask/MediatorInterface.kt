package vendingMachineTask

interface MediatorInterface {
    fun notify(sender : Senders, number : Int)
}