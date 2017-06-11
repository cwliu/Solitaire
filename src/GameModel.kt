class GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf();
    val foundationPiles = arrayOf(
            FoundationPile(clubs),
            FoundationPile(diamonds),
            FoundationPile(hearts),
            FoundationPile(spades))

    var tableauPiles = Array(7, {TableauPile()})

    fun resetGame(){
        wastePile.clear()
        foundationPiles.forEach { it.reset() }
        deck.reset()
        tableauPiles.forEachIndexed { i, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(i + 1, {deck.drawCard()}).toMutableList()

            tableauPiles[i] = TableauPile(cardsInPile)
        }
    }
}
