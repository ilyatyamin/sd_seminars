package taskComposite


fun main(args: Array<String>) {

    val industrialMusic: SongComponent =
        SongGroup("Industrial", "is a style of experimental music that draws on transgressive and provocative themes")

    val heavyMetalMusic: SongComponent = SongGroup(
        "\nHeavy Metal",
        "is a genre of rock that developed in the late 1960s, largely in the UK and in the US"
    )

    val dubstepMusic: SongComponent =
        SongGroup("\nDubstep", "is a genre of electronic dance music that originated in South London, England")

    // TODO: Create a SongComponent, that will hold
    //  all the categories and individual songs

    val everySong: SongComponent = SongGroup("Song List", "Every Song Available")

    everySong.add(heavyMetalMusic)

    heavyMetalMusic.add(Song("War Pigs", "Black Sabath", 1970))
    heavyMetalMusic.add(Song("Ace of Spades", "Motorhead", 1980))


    // TODO: Fill the MusicPlayer class with necessary code

    val crazyLarry = MusicPlayer(everySong)

    crazyLarry.getSongList()
}