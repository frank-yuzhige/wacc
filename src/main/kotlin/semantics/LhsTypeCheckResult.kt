package semantics

import exceptions.SemanticException

sealed class LhsTypeCheckResult<T> {

    data class Success<T>(val result: T) : LhsTypeCheckResult<T>()
    data class Failure<T>(val errors: List<SemanticException>): LhsTypeCheckResult<T>()

}