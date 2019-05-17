package com.example.unidirectionalstateflow.domain


abstract class UseCase {
    abstract fun processAction(action: Action)

}