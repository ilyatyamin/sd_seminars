class ShopDatabase : ServiceInterface {
    var goods = mutableListOf<String>()

    override fun getElement(id: Int) : String {
        return goods[id]
    }

    override fun addElement(name: String) {
        goods.add(name)
    }

    override fun removeElement(name: String) {
        if (goods.contains(name)) {
            goods.remove(name)
        } else {
            throw Exception("no element with this name")
        }
    }

}