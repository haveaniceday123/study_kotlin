package com.bignerdranch.nyethack

class Player3(_name: String, val health: Int) {
  val race = "DWARF"
  var town = "Bavaria"
  val name = _name;
  val alignment: String
  private var age = 0

  init {
    println("initializing player")
    alignment = "GOOD"
  }

  constructor(_name: String): this(_name, 100) {
    town = "The Shire";
  }

}

fun main() {
  Player3("Madrigal")
}