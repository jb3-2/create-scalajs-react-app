package ch.netzwerg.example.counter

import diode.{Action, ActionHandler, ModelRW}

case object Increment extends Action

case object Decrement extends Action

class CounterHandler[M](modelRW: ModelRW[M, CounterModel]) extends ActionHandler(modelRW) {

  override def handle = {
    case Increment => updated(value.copy(counter = value.counter + 1))
    case Decrement => updated(value.copy(counter = value.counter - 1))
  }

}
