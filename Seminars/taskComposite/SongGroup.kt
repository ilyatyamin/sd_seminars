package taskComposite


class SongGroup(val groupName: String, val groupDescription: String) : SongComponent {
    var songComponents: MutableList<SongComponent> = mutableListOf<SongComponent>();
    override fun add(component: SongComponent) {
        songComponents.add(component)
    }

    override fun remove(component: SongComponent) {
        songComponents.remove(component)
    }

    override fun playAll() {
        println("group = $groupName. description = $groupDescription.")
        println("components in it: ")
        for (song in songComponents) {
            song.playAll()
        }
    }

    override fun displaySongInfo() {
        for (song in songComponents) {
            song.displaySongInfo()
        }
    }
}