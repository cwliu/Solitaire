class GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
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

    fun onDeckTap(){
        if (deck.cardsInDeck.isNotEmpty()){
            val card = deck.drawCard()
            card.faceUp = true
            wastePile.add(card)
        }else{
            deck.cardsInDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun onWasteTap(){
        if(wastePile.isNotEmpty()){
            val card = wastePile.last()
            if(playCard(card)){
                wastePile.remove(card)
            }
        }
    }

    private fun playCard(card: Card): Boolean {
        foundationPiles.forEach {
            if (it.addCard(card)){
                return true
            }
        }
        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))){
                return true
            }
        }
        return false
    }
}
