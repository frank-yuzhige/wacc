package utils

import parser.exceptions.ParseException
import java.lang.Exception
import kotlin.reflect.KClass

inline fun<reified T, reified E: Exception> T.catchError(clazz: KClass<E>, errorHandler: (E) -> Nothing): T {
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

inline infix fun<reified T> T.appendParseError(postfix: String): T {
    return this.catchError(ParseException::class) { err -> throw ParseException(err.message + "\n$postfix")}
}

//inline infix fun<T, reified E: Exception> T.appendError(postfix: String): T = this catchError (error)