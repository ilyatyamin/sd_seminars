package vendingMachineTask

class BuyCoffeeButton(private var mediator : MediatorInterface) : BuyerButton {

    override fun buy() {
        mediator.notify(Senders.CoffeeButton, 2)
    }
}