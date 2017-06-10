class Deck {

    val cards = Array(52, { Card(it % 13, getSuit(it)) })

    private fun getSuit(i: Int): String = when (i / 13) {
        0 -> "Clubs"
        1 -> "Diamonds"
        2 -> "Hearts"
        else -> "Spades"
    }
}
