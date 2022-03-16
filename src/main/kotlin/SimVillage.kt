const val PLAYER_NAME = "HARU URARA";

fun main() {
//    runSimulation(PLAYER_NAME, ::printConstructionCost) { playerName, numBuildings ->
//        val currentYear = 2019;
//        println("${numBuildings}채의 건물의 추가됨")
//        "SimVillage 방문을 환영합니다. ${playerName}! (copyright $currentYear)"
//    }
    runSimulation();
    runSimulation();

//    runSimulation(PLAYER_NAME, greetingFunction)
}


//private inline fun runSimulation(playerName: String, costPrinter: (Int) -> Unit, greetingFunction: (String, Int) -> String) {
//    val numberBuildings = (1..3).shuffled().last();
//    costPrinter(numberBuildings);
//    println(greetingFunction(playerName, numberBuildings))
//}
private fun runSimulation() {
    val greetingFunction = configureGreetingFunction();
    println(greetingFunction(PLAYER_NAME));
    println(greetingFunction(PLAYER_NAME));
}

private fun printConstructionCost(numBuildings: Int) {
    val cost = 500;
    println("건축 비용: ${cost * numBuildings}");
}

private fun configureGreetingFunction(): (String) -> String {
    val structureType = "병원";
    var numBuildings = 5;
    return {
        playerName: String ->
            val currentYear = 2019;
            numBuildings += 1;
            println("$numBuildings 채의 ${structureType}이 추가됨");
            "SimVillage 방문을 환영합니다. ${playerName}! (copyright $currentYear)"
    }
}