package dojo;

@FunctionalInterface
interface FunctionThatThrows<T, K extends Throwable> {
    T apply() throws K;
}
