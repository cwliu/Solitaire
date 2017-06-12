fun main(args: Array<String>): Unit {
    GameModel.resetGame()
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}
