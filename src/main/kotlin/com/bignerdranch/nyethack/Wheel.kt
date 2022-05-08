package com.bignerdranch.nyethack

class Wheel {
  lateinit var alignment: String;

  fun initAlignment() {
    alignment = "Good";
  }

  fun printAlignment() {
    if(::alignment.isInitialized) println(alignment);
  }


}