package Parser

import Parser.WithErr.*

fun<A, B, C> Pair<A, B>.uncurry(f: (A, B) -> C): C {
    return f(first, second)
}


class ParserC<S, E, T>(val parse: (S) -> WithErr<E, Pair<S, T>>) {

    companion object {
        fun<S, E, T> join(e : ParserC<S, E, ParserC<S, E, T>>): ParserC<S, E, T> = e.bind { it }
        fun<S, E, T> pure(value : T) : ParserC<S, E, T> = ParserC { Just(Pair(it, value)) }
    }
    fun<K> fmap(f : (T) -> K) = join(this.bind { pure<S, E, ParserC<S, E, K>>(pure(f(it))) })
    fun<K> fGet(value : K) = fmap { value }
    fun<K> ap(fab : ParserC<S, E, (T) -> K>) : ParserC<S, E, K> {
        return fab.bind { f ->
            this.bind { s ->
                Parser.ParserC.pure<S, E, K>(f(s))
            }
        }
    }

    fun<K> bind(f : ((T) -> ParserC<S, E, K>)): ParserC<S, E, K> = ParserC { input ->
        parse(input).bind { res -> f(res.second).parse(res.first) }
    }

    fun<K> seq(next : ParserC<S, E, K>) : ParserC<S, E, K> = bind { next }

    fun<K> orElse(that : ParserC<S, E, T>): ParserC<S, E, T> = ParserC { input ->
        this.parse(input).orElse(that.parse(input))
    }

}


