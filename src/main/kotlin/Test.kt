

import java.io.File
import kotlin.text.count;

fun main() {

  val menuFile = File("menu-file.txt").apply {
    setReadable(true);
    setWritable(true)
    setExecutable(false)
  };

  val firstIteemSquared = listOf(1,2,3).first().let {
    it * it
  }

  val hi:CharSequence = "hi";

//  hi.run(::count);

  hi.count()

  println(formatGreeting("Haru Urara"));

  "Polarcubis"
    .run(::nameIsLong)
    .run(::playerCreateMessage)
    .run(::println);


  val string: String = "MAD"


  string.run { count() { it -> it == 'A'} }.run(::addPlusOne)
//  string.run { print(count()); print(split('s')) }
//string.run(::anyFunctino)


}

private fun addPlusOne(number: Int) {
  print(number.plus(1));
}

private fun anyFunctino(a: String) {
  print(a.count());
  print(a.split('s'));
}

fun countString(string: String):Int {
  return string.count();
}

fun formatGreeting(vipGuest: String?): String {
  return vipGuest?.let {
    "오랜만입니다, $it. 테이블이 준비되어 있으니 들어오시죠"
  } ?: "저희 술집에 오신것을 환영합니다. 곧 자리를 마련해 드리겠습니다."
}

fun nameIsLong(name: String) = name.length >= 20;

fun playerCreateMessage(nameTooLong: Boolean):String {
  return if (nameTooLong) {
    "Name is too long. Please choose another name"
  } else {
    "Welcome, adventurer"
  }
}

