class GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf();
    val foundationPiles = arrayOf(
            FoundationPile(clubs),
            FoundationPile(diamonds),
            FoundationPile(hearts),
            FoundationPile(spades))

    var tableauPile = Array(7, {TableauPile()})
}
