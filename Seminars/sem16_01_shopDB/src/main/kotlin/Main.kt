fun main(args: Array<String>) {
    var shopDatabase = ShopDatabase()
    var accessorShop = AccessorShop(shopDatabase, Role.Owner)

    accessorShop.addElement("123")
}