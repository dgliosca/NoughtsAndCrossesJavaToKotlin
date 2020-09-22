package dojo

import java.io.IOException

@FunctionalInterface
interface FunctionThatThrows<out T> {
    @Throws(IOException::class)
    fun apply(): T
}
