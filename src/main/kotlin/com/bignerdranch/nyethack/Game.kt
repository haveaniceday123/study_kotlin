package com.bignerdranch.nyethack

fun main(args: Array<String>) {


  val player = Player("kar");
  player.castFireball()

  var currentRoom: Room =  TownSquare();
  println(currentRoom.description())
  println(currentRoom.load())
  println(currentRoom)

  printPlayerStatus(player)

  performCombat();
  performCombat("Haru Urara")
  performCombat("Haru Urara", true)
}

private fun printPlayerStatus(
  player: Player
) {
  println("(Aura: ${player.auraColor()} " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
  println("${player.name} ${player.formatHealthStatus()}")

}

private fun performCombat() = println("적군이 없다.");

private fun performCombat(enemyName: String) = println("{$enemyName}과 전투를 시작함");

private fun performCombat(enemyName: String, isBlessed: Boolean) =
  if (isBlessed) println("{$enemyName}과 전투를 시작함. 축복을 받음")
  else println("{$enemyName}과 전투를 시작함")