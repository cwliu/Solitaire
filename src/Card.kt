val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"
var redSuits = arrayOf(diamonds, hearts)
var blackSuits = arrayOf(clubs, spades)

class Card (val value: Int, val suit: String, var faceUp: Boolean = false){

}
