package ir.mehdiyari.ctmp

import ir.mehdiyari.annotations.HelloWorldAnnotation

@HelloWorldAnnotation
data class Person(
    val name: String,
    val age: Int
)