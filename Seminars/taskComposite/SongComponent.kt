package taskComposite

interface SongComponent {
    fun displaySongInfo()
    fun add(component: SongComponent)
    fun remove(component: SongComponent)
    fun playAll()
}