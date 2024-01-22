package vendingMachineTask

class BuyTeaButton(private val mediator : MediatorInterface) : BuyerButton {

    override fun buy() {
        mediator.notify(Senders.TeaButton, 1)
    }
}