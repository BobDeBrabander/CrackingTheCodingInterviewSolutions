package mydatastructures

import java.lang.IllegalStateException
import java.lang.IndexOutOfBoundsException

class MySinglyLinkedList <T: Any?>{
    var head: Node<T>? = null
    var tail: Node<T>? = null
    private var size : Int = 0

    constructor()
    constructor(values: Collection<T>){
        addAll(values)
    }

    class Node<T>(var value: T?){
        var next: Node<T>? = null
    }


    fun add(value: T) = linkLast(value)
    fun addAll(values: Collection<T>) {
        values.forEach{ add(it) }
    }


    private fun linkLast(value: T){
        val newNode = Node(value)
        tail?.next = newNode
        tail = newNode
        if (head == null) head = newNode
        size++
    }

    fun getSize() = size

    fun isEmpty() = size == 0
    fun isNotEmpty() = !isEmpty()

    fun getNodeAt(index: Int) : Node<T>{
        if (index !in 0 until size){
            throw IndexOutOfBoundsException("Index $index not in 0 until $size")
        } else {
            var curNode = head
            repeat(index){ curNode = curNode?.next }
            return curNode ?: throw IllegalStateException("Expected non-null node was null")
        }
    }

    fun toList(): List<T>{
        if (size == 0) return listOf()
        val resultList = mutableListOf<T>()
        var curNode = head
        do {
            curNode?.value?.run { resultList.add(this) }
            curNode = curNode?.next
        } while(curNode != null)
        return resultList.toList()
    }
}