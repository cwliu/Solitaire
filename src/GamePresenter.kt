object GamePresenter {
    var view: GameView? = null

    fun setGameView(gameView: GameView){
        view = gameView
    }

    fun onDeckTap(){
        GameModel.onDeckTap()
        view?.update()
    }

    fun onWateTap(){
        GameModel.onWasteTap()
        view?.update()
    }

    fun onFoundationTab(foundationIndex: Int){
        GameModel.onFoundationTab(foundationIndex)
        view?.update()
    }

    fun onTableauTab(tableauIndex: Int, cardIndex: Int) {
        GameModel.onTableauTab(tableauIndex, cardIndex)
        view?.update()
    }
}
