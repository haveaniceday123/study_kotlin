package com.bignerdranch.nyethack

class Player3(_name: String) {
  val name: String = _name;
  val playerName: String = initPlayerName();


  private fun initPlayerName() = name;

}

fun main() {
  println(Player3("Madrigal").playerName)

}