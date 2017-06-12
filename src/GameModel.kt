object GameModel {
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

    fun playCard(card: Card): Boolean {
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

    fun playCards(cards: MutableList<Card>): Boolean {
        if (cards.size == 1) {
            return playCard(cards.first())
        } else {
            tableauPiles.forEach {
                if (it.addCards(cards)) {
                    return true
                }
            }
        }
        return false
    }
    
    fun onFoundationTab(foundationIndex: Int){
        val foundationPile = foundationPiles[foundationIndex]
        if(foundationPile.cards.size > 0){
            var card = foundationPile.cards.last()
            if(playCard(card)){
                foundationPile.removeCard(card)
            }
        }
    }

    fun onTableauTab(tableauIndex: Int, cardIndex: Int) {
        val tableauPile = tableauPiles[tableauIndex]
        if (tableauPile.cards.size > 0) {
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if (playCards(cards)) {
                tableauPile.removeCards(cardIndex)
            }
        }
    }

    fun debugPrint(){
        println(deck.cardsInDeck.last())
    }
}
