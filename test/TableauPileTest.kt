import junit.framework.Assert.assertEquals
import org.junit.Test

class TableauPileTest {

    @Test
    fun addCards() {
        // arrange
        val tableauPile = TableauPile(mutableListOf(Card(12, spades)))
        val cards = mutableListOf(Card(11, hearts))

        // act
        tableauPile.addCards(cards)

        // assert
        assertEquals(2, tableauPile.cards.size)
    }

    @Test
    fun removeCards() {
        // arrange

        // act

        // assert
    }
}