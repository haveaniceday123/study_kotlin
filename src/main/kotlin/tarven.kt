import java.io.File

const val TAVERN_NAME = "Tavernyl's Folly";


//val com.bignerdranch.nyethack.getPatronList: List<String> = listOf("Eli", "Mordoc", "Sophie");
val patronList: MutableList<String> = mutableListOf("Eli", "Mordoc", "Sophie");
val uniquePatrons = mutableSetOf<String>();
val readOnlyPatronList: List<String> = patronList.toList();
//val com.bignerdranch.nyethack.getPatronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5);
val patronGold = mutableMapOf<String, Double>()
val lastName = listOf("Ironfoot", "Fernworth",  "Baggins");


val menuList = File("data/tavern-menu-item.txt")
  .readText()
  .split("\r\n")

fun main() {



  (0..9).forEach { _ ->
    val first = patronList.shuffled().first();
    val last = lastName.shuffled().first();
    val name = "$first $last";
    uniquePatrons += name;
  }
  
  uniquePatrons.forEach {
    patronGold[it] = 1.0;
  }

  var orderCount = 0;
  while (orderCount <= 9) {
      if (uniquePatrons.size == 0) return;

    placeOrder(
      uniquePatrons.shuffled().first(),
      menuList.shuffled().first()
    );
    orderCount++;
  }
//
//
//
//  if (com.bignerdranch.nyethack.getPatronList.contains("Eli")) {
//    println("술집 주인이 말한다: Eli는 안쪽 방에서 카드하고 있어요")
//  } else {
//    println("술집 주인이 말한다: Eli는 여기 없어요");
//  }
//
//  if (com.bignerdranch.nyethack.getPatronList.containsAll(listOf("Sophie", "Mordoc"))) {
//    println("술집 주인이 말한다, 네, 모두 있어요")
//  } else {
//    println("술집 주인이 말한다: 아니요, 나간사람도 있어요");
//  }


  displayPatronBalances();

}

fun calculateChange(price: Double, fullPrice: Double): Double  = fullPrice - price;

fun haveEnoughMoney(price: Double): Boolean = price > 0;

// remove from uniquePatron
fun removeUniquePatron(patronName: String) =  uniquePatrons.remove(patronName);

// remove from com.bignerdranch.nyethack.getPatronGold
fun removePatronGold(patronName: String) = patronGold.remove(patronName)

// remove patron from NyetHack
fun removePatron(patronName: String) {
  println("${patronName}은 돈이 없네요. 나가주세요");
  removeUniquePatron(patronName);
  removePatronGold(patronName);
}

// change patrons balance
fun changePatronBalance(patronName: String, balance: Double) {
  patronGold[patronName] = balance;
}



// customer buys
fun performPurchase(price: Double, patronName: String) {
  val totalPurse = patronGold.getValue(patronName); //patron's balance
  val estimateBalance = calculateChange(price, totalPurse);

  if (haveEnoughMoney(estimateBalance))
    changePatronBalance(patronName, estimateBalance)
  else {
    println("예상 잔액 $${estimateBalance}")
    removePatron(patronName);
  }

}



private fun sayBartenderYouDontHaveEnoughMoney() {
  println("Bartender You Don't have enough moeny. Check your balance");
}

private fun placeOrder(patronName: String) {
  val indexofApostrophe = TAVERN_NAME.indexOf('\'');
  val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe);
//  println("${patronName}은 ${tavernMaster}에게 주문한다.");
}

private fun placeOrder(patronName: String, menuData: String) {
  placeOrder(patronName);

  val (type, name, price) = menuData.split(',');
  val message = "${patronName}은 금화 $${price}로 ${name}(${type})을 구입한다."

  println(message);
  performPurchase(price.toDouble(), patronName)

  val phrase = if (name == "Dragon's Breath") {
    "${patronName}이 감탄한다: ${toDragonSpeak("와, ${name}진짜 좋구나")}"
  } else {
    "${patronName}이 말한다: 감사합니다. $name"
  }

//  println(phrase)
//  println(toDragonSpeak("DRAGON'S BREATHE: IT'S GOT WHAT ADVENTURES CRAVE"))
}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[AEIOUaeiou]")) { string ->
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

private fun batenderSays(setenceToSay: String): Unit = println("바텐더가 말합니다: $setenceToSay");

private fun displayPatronBalances() {
  patronGold.forEach { (patron, balance) ->
    println("$patron, balance: ${"%.2f".format(balance)}")
  }
}

