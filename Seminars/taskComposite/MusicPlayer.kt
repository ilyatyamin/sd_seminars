package taskComposite

class MusicPlayer(var everySong: SongComponent) {
    fun add(element : SongComponent) {
        everySong.add(element)
    }

    fun remove(element : SongComponent) {
        everySong.remove(element)
    }

    fun getSongList() {
        everySong.playAll()
    }
}