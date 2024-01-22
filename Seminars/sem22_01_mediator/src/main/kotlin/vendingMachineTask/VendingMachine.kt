package vendingMachineTask

class VendingMachine(private var coinsState : CoinsState) : MediatorInterface {
    override fun notify(sender: Senders, number: Int) {
        when (sender) {
            Senders.CoffeeButton -> {
                if (coinsState.hasEnoughCoins(number))
                    println("Preparing coffee...")
                else
                    println("Not enough to buy coffee...")
            }

            Senders.TeaButton -> {
                if (coinsState.hasEnoughCoins(number))
                    println("Preparing tea...")
                else
                    println("Not enough to buy tea...")
            }

            Senders.CoinSlot -> {
                println("Customer tries to insert coint...")
                coinsState.insertCoin(number)
                println("Coin has been accepted...")
            }

            Senders.ReturnCoin -> {
                if (coinsState.hasEnoughCoins(1))
                    println("Returning all coins...")
                else
                    println("Machine has no coins to return...")
            }
        }
    }

}