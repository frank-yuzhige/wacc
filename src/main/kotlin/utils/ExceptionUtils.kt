package utils

import java.lang.Exception
import kotlin.reflect.KClass

class Catcher<A>(val value: A) {

}

inline fun<reified T, reified E: Exception> Catcher<T>.catchError(clazz: KClass<E>, errorHandler: (E) -> Nothing): Catcher<T> {
    return try {
        this
    } catch (e: Exception) {
        if (e is E) {
            errorHandler(e)
        } else {
            throw e
        }
    }
}

//inline infix fun<T, reified E: Exception> T.appendError(postfix: String): T = this catchError (error)