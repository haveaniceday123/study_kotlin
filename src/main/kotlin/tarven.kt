const val TAVERN_NAME = "Tavernyl's Folly";
fun main() {
//    placeOrder();
    placeOrder("elixir,Shirley's Temple,4.12");
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



    val phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄한다: ${toDragonSpeak("와, ${name}진짜 좋구나")}"
    } else {
        "마드리갈이 말한다: 감사합니다. $name"
    }

    println(phrase)
}


private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")) {string ->
    println(string.value)
    when (string.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> string.value
    }
}

