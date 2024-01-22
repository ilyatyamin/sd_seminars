package vendingMachineTask


class ReturnCoinButton(private var mediator : MediatorInterface) {
    public fun returnCoins() {
        mediator.notify(Senders.ReturnCoin, 0)
    }

}