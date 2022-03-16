fun main() {
    var swordJuggling: Int? = null;
    var isJugglingProficient = (1..3).shuffled().last() == 3

    if (isJugglingProficient) {
        swordJuggling = 2;
    }

    try {
        proficiencyCheck(swordJuggling)
        swordJuggling = swordJuggling!!.plus(1)
    } catch (e: IllegalStateException) {
        println(e);
    }


    println("${swordJuggling}개의 칼로 저글링합니다.")
}

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw UnskilledSwordJugglerException()
    checkNotNull(swordsJuggling) { "플레이어가 저글링 할 수 없음" };
}

class UnskilledSwordJugglerException() : IllegalStateException("플레이어가 저글링 할 수 없음")