import kotlin.math.pow

fun main(args: Array<String>) {
    val name = "마드리길";
    var healthPoints = 13;
    val isBlessed = true;
    val isImmortal = false;
    val karma = (Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt();

//    println(Math.pow((110 - healthPoints) / 100.0))
    // check aura
    println(Math.random());
    println((Math.random().pow(1.01) * 20).toInt())
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal;
    val auraColor = whatIsUsersAuraColor(auraVisible, karma);

    val healthStatus = when (healthPoints) {
        100 -> "최상의 상태임!"
        in 90..99 -> "약간의 찰과상만 있음"
        in 75..89 -> if (isBlessed) "경미한 상처가 있지만 빨리 치유되고 있음" else "경미한 상처만 있음"
        in 15..74 -> "많이 다친 것 같음"
        else -> "최악의 상태임."
    }


//    println("(Aura; ${auraColor}s)" + " (Blessed: ${if (isBlessed) "YES" else "NO"})")
//    println("$name $healthStatus")

    val stringFormat = "(HP: $healthPoints)(Aura: $auraColor) -> $name $healthStatus"

//    if (auraVisible) println("Aura color: $auraColor")
    print(stringFormat)
}

//private fun whatIsUsersAuraColor(auraVisible: Boolean , karma: Int) = when (karma) {
//    in 6..10 -> "orange"
//    in 11..15 -> "Purple"
//    in 16..20 -> "Green"
//    else -> "Red"
//}

private fun whatIsUsersAuraColor(auraVisible: Boolean, karma: Int) = if (auraVisible) {
    when (karma) {
        in 6..10 -> "Orange"
        in 11..15 -> "Purple"
        in 16..20 -> "Green"
        else -> "Red"
    }
} else {
    "None"
}