import java.io.InputStream

fun toInputStream(input: Any) : InputStream = input.toString().byteInputStream()

fun<A, B, C> cartesianBy(fst : Iterable<A>,
                         snd : Iterable<B>,
                         productFunc : (A, B) -> C ) : Iterable<C> {
    return fst.flatMap { x -> snd.map { y -> productFunc(x, y) } }
}

fun<A, B> cartesianProduct(fst : Iterable<A>, snd : Iterable<B>)
        = cartesianBy(fst, snd) { x, y -> x to y }

