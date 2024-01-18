class AccessorShop(private var realService : ShopDatabase, var role : Role) : ServiceInterface {
    var logger = Logger()

    fun checkAccess(role : Role) : Boolean {
        if (role == Role.Owner) {
            return true
        }
        return false
    }

    override fun getElement(id: Int) : String {
        logger.writeMessageGet(id)
        return realService.getElement(id)
    }

    override fun addElement(name: String) {
        if (checkAccess(role)) {
            logger.writeMessageAdd(name, true)
            realService.addElement(name)
        } else {
            logger.writeMessageAdd(name, false)
        }
    }

    override fun removeElement(name: String) {
        if (checkAccess(role)) {
            realService.removeElement(name)
        } else {
            logger.writeMessageRemove(name, false)
        }
    }
}