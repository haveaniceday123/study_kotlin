fun testFunction(s: String):Boolean {
  print("test function!")
  return true;
};

fun printWelcomeText(): Unit {
  println("*** Welcome to Taernyl's Folly ***".count())
  println("*** Welcome to Taernyl's Folly ***");
}

fun whatIndexIsLogest(list: List<String>):Int {
  var count:Int = 0;

  list.forEach {
    val (_, name, price) = it.split(",")
    if (name.count() > count) count = name.count();
  }

  return count;
}

fun toUpperCase(s: String):String {
  val splitList =  s.split(" ");
  val result = splitList.map { it.substring(0, 1).toUpperCase() + it.substring(1 until it.count()) }

  return result.joinToString(" ")
}

fun printMenuOrdered(list: List<String>):Unit {
  val longestMenu = whatIndexIsLogest(list);

  list.forEach {
    val (_, name, price) = it.split(",");
    var star = "";
    var count = 34 - name.count() - price.count();

    toUpperCase(name);

    while (count > 0) {
      star += ".";
      count--;
    }
    println("${toUpperCase(name)}$star$price");
  }


}