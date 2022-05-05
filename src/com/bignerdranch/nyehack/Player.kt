package com.bignerdranch.nyehack

class Player {

  // player name
  var name = "madrigal"
    get() = field.capitalize()
    private set(value) {
      field = value.trim()
    }

  // player HP
  var healthPoints = 29;

  // player buff status
  val isBlessed = true;

  // is player dangerous?
  private val isImmortal = false;

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


}