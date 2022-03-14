fun main(args: Array<String>) {
    val name = "마드리길";
    var healthPoints = 29;
    val isBlessed = true;
    val isImmortal = false;

    // check aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)


    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball();
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura; ${auraColor}s)" + " (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal;
    val auraColor = if (auraVisible) "GREEN" else "NONE";
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
    100 -> "최상의 상태임"
    in 90..99 -> "약간의 찰과상만 있음"
    in 75..99 -> if (isBlessed) {
        "경미한 상처가 있지만 빨리 치유되고 있음"
    } else {
        "경미한 상처만 있음"
    }
    in 15..75 -> "많이 다친 것 같음."
    else -> "최악의 상태임!"
}


private fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
