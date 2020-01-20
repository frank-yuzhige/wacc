package Parser

abstract class WithErr<E, T> {

    companion object {
        fun<E, T> join(e : WithErr<E, WithErr<E, T>>): WithErr<E, T> = e.bind { it }
    }

    abstract fun<K> bind(f : (T) -> WithErr<E, K>) : WithErr<E, K>
    abstract fun isErr() : Boolean
    abstract fun catchErr(action: (E) -> Unit) : Unit
    abstract fun orElse(that : WithErr<E, T>) : WithErr<E, T>

    fun<K> fmap(f : (T) -> K) = join(this.bind { Parser.WithErr.Just<E, WithErr<E, K>>(Parser.WithErr.Just(f(it))) })
    fun<K> thenGet(value : K) = fmap { value }
    fun<K> ap(fab : WithErr<E, (T) -> K>) : WithErr<E, K> {
        return fab.bind { f ->
            this.bind { s ->
                Just<E, K>(f(s))
            }
        }
    }

    data class Err<E, T>(val error: E): WithErr<E, T>() {
        override fun orElse(that: WithErr<E, T>): WithErr<E, T> = that
        override fun catchErr(action: (E) -> Unit) = action(error)
        override fun isErr(): Boolean = true
        override fun <K> bind(f: (T) -> WithErr<E, K>): WithErr<E, K> = Err(error)
    }

    data class Just<E, T>(val value: T): WithErr<E, T>() {
        override fun orElse(that: WithErr<E, T>): WithErr<E, T> = this
        override fun catchErr(action: (E) -> Unit) = Unit
        override fun isErr(): Boolean = false
        override fun <K> bind(f: (T) -> WithErr<E, K>): WithErr<E, K> = f(value)
    }
}