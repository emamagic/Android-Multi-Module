package com.emamagic.domain.base

abstract class UseCase<out R> {
    /**
     * Build the use case to be executed.
     *
     * @return result [R] of the use case.
     */
    protected abstract suspend fun buildUseCase() : R

    /**
     * Execute the use case.
     *
     * Called by client of the use case.
     *
     * @return [R] result of executing this use case
     */
    suspend fun execute(): R = buildUseCase()

}