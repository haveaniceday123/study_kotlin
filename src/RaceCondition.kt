class Weapon(val name: String?)

class Player {
  var weapon: Weapon? = Weapon("Ebony Kris")

  fun printWeaponName() {
    if (weapon != null) {
//      weapon = Weapon(null);
      println(weapon?.name);

    }
  }
}

fun main() {
  Player().printWeaponName()
}