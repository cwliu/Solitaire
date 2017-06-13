import org.junit.Test

class GameTest {

    @Test
    fun kingInFirstFoundationPile() {
        // arrange
        var numGames = 0
        val maxGames = 10000

        // act
        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauTab(index, tableauPile.cards.lastIndex)
                }

                if (GameModel.foundationPiles[0].cards.size == 13) {
                    // assert
                    GameModel.debugPrint()
                    println("# Game: $numGames")
                    assert(numGames < maxGames)
                    break
                }
            }



        }
    }
}