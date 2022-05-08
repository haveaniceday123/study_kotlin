package com.bignerdranch.nyethack

import java.io.File

class Player(_name: String, var healthPoints: Int = 100, val isBlessed: Boolean, private val isImmortal: Boolean) {

  // player name
  var name = _name
    get() = "${field.capitalize()} of $hometown"
    private set(value) {
      field = value.trim()
    }

  val hometown by lazy { selectHometown() }



  constructor(name: String): this(name, isBlessed = true, isImmortal = false) {
    if (name.lowercase() === "kar") {
      healthPoints = 40
    }
  }

  init {
    require(healthPoints > 0) { "healthPoints is bigger than 0"}
    require(name.isNotBlank()) { "player must have name"}
  }

  // player's skill: FIREBALL
  fun castFireball(numFireballs: Int = 2) {
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
  }

  // Type of player's current buff
  fun auraColor(): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal;
    val auraColor = if (auraVisible) "GREEN" else "NONE";
    return auraColor
  }

  // get player's current status string
  fun formatHealthStatus() = when (healthPoints) {
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

  private fun selectHometown() = File("data/towns.txt")
    .readText()
    .split("\r\n")
    .shuffled()
    .first();
}