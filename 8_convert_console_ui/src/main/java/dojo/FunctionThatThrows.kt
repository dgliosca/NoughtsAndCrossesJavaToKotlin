package dojo

import java.io.IOException

@FunctionalInterface
internal interface FunctionThatThrows<out T> {
    @Throws(IOException::class)
    fun apply(): T
}
