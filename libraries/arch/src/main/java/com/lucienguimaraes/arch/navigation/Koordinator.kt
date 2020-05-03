package com.lucienguimaraes.arch.navigation

import java.util.*
import kotlin.reflect.KClass

abstract class Koordinator<C>(protected val component: C) {

    private val childrenStack: Deque<Koordinator<*>> = ArrayDeque()

    abstract fun start()

    abstract fun onRelease()

    fun backPressed(): Boolean {
        val activeChildBack = childrenStack.peek()?.backPressed() ?: false
        if (!activeChildBack)
            return ((this is BackPressedListener) && onBackPressed())
        return activeChildBack
    }

    protected fun release() {
        childrenStack.forEach { it.release() }
        childrenStack.clear()
        onRelease()
    }


    protected fun attachCoordinator(coordinator: Koordinator<*>) {
        childrenStack.push(coordinator)
    }

    protected fun detachCoordinator(coordinator: KClass<out Koordinator<*>>) {
        val coordinatorInstance = findFromKClass(coordinator)
        coordinatorInstance?.let {
            it.release()
            childrenStack.removeFirstOccurrence(it)
        }
    }

    fun <T : Koordinator<*>> findChildCoordinator(type: KClass<T>): T =
        findFromKClass(type)
            ?: throw IllegalStateException("Required coordinator is not a child of this coordinator")

    fun <T : Koordinator<*>> isCoordinatorAttached(type: KClass<T>): Boolean =
        findFromKClass(type) != null

    @Suppress("UNCHECKED_CAST")
    private fun <T : Koordinator<*>> findFromKClass(type: KClass<T>): T? {
        return childrenStack.find { it::class == type } as T?
    }

    fun attachTo(coordinator: Koordinator<*>) {
        coordinator.attachCoordinator(this)
    }
}


interface BackPressedListener {
    fun onBackPressed(): Boolean
}
