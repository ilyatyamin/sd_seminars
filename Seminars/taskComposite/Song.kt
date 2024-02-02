package taskComposite


class Song(var songName: String, var bandName: String, var releaseYear: Int) : SongComponent {
    override fun displaySongInfo() {
        println("$songName was recorded by $bandName in $releaseYear")
    }

    override fun add(component: SongComponent) {
        println("error")
    }

    override fun remove(component: SongComponent) {
        println("error")
    }

    override fun playAll() {
        println(" --> name = $songName. bandName = $bandName. release = $releaseYear")
    }

}