import java.io.File

fun main() {

    val menuFile = File("menu-file.txt").apply {
        setReadable(true);
        setWritable(true)
        setExecutable(false)
    };

    val firstIteemSquared = listOf(1,2,3).first().let {
        it * it
    }


    print(formatGreeting("Haru Urara"));

}

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "오랜만입니다, $it. 테이블이 준비되어 있으니 들어오시죠"
    } ?: "저희 술집에 오신것을 환영합니다. 곧 자리를 마련해 드리겠습니다."
}