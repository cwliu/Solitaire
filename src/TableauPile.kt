class TableauPile(var cards: MutableList<Card>) {
    init {
        cards.last().faceUp = true
    }

    fun addCard(newCards: MutableList<Card>): Boolean {
        if(cards.size > 0 ){
            if (newCards.first().value == cards.last().value - 1
                    && suitCheck(newCards.last(), cards.last())
                    ) {
                cards.addAll(newCards)
                return true
            }
        }else if (newCards.first().value == 12){
            cards.addAll(newCards)
            return true
        }
        return false
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        return (redSuits.contains(c1.suit) && blackSuits.contains(c2.suit))
                || (blackSuits.contains(c1.suit) && redSuits.contains(c2.suit))
    }
}