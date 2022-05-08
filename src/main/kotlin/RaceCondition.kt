class Weapon(val name: String?)

class PlayerTest {
  var weapon: Weapon? = Weapon("Ebony Kris")

  fun printWeaponName() {
    if (weapon != null) {
//      weapon = Weapon(null);
      println(weapon?.name);

    }
  }
}

fun main() {
  PlayerTest().printWeaponName()
}