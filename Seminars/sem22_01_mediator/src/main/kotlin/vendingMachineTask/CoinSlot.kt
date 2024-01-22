package vendingMachineTask

class CoinSlot (private val mediator : MediatorInterface) {
    public fun insertCoin(value: Int) {
        mediator.notify(Senders.CoinSlot, value)
    }
}