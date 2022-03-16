import kotlin.math.roundToInt

const val TAVERN_NAME = "Tavernyl's Folly";

var playerGold = 10;
var playerSilver = 10;

fun main() {

//    placeOrder();
    placeOrder("elixir,Shirley's Temple,5.91");
//    println(Integer.toBinaryString(42));
    println(Integer.toBinaryString(42.inv()))
}


fun performPurchase(price: Double) {
    displayBalance();

    val totalPurse = playerGold + (playerSilver / 100.0);

    println("Amount in wallet : Gold $totalPurse");
    println("Buy alchohol with $price Gold");

    val remainingBalance = totalPurse - price;
    println("Player's remainin balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt();
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt();

    playerGold = remainingGold;
    playerSilver = remainingSilver;

    displayBalance();
}

private fun displayBalance() {
    println("Player's wallet balance: (Gold: ${playerGold}개, Silver: ${playerSilver}개)")
}




private fun placeOrder() {
    val indexofApostrophe = TAVERN_NAME.indexOf('\'');
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe);
    println("마드리갈은 ${tavernMaster}에게 주문한다.");
}

private fun placeOrder(menuData: String) {
    placeOrder();

    val (type, name, price) = menuData.split(',');


    val message = "마드리갈은 금화 $${price}로 ${name}(${type})을 구입한다."

    println(message);

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄한다: ${toDragonSpeak("와, ${name}진짜 좋구나")}"
    } else {
        "마드리갈이 말한다: 감사합니다. $name"
    }

    println(phrase)
    println(toDragonSpeak("DRAGON'S BREATHE: IT'S GOT WHAT ADVENTURES CRAVE"))
}


private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[AEIOUaeiou]")) {string ->
    when (string.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        "A" -> "4"
        "E" -> "3"
        "I" -> "1"
        "O" -> "0"
        "U" -> "|_|"
        else -> string.value
    }
}

