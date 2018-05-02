package homework.l2

//import homework.l2.ListHomework.SquareAndSum

import scala.annotation.tailrec

/**
  * В этом домашнем задании вам нужно написать так называёмую функцию свёртки (fold).
  * Что она должна делать:
  * Берёт startValue и первый элемент списка, и передаёт их в качестве аргументов в функцию f.
  * Затем берёт результат выполения функции следующий элемент списка, и передаёт их в качестве аргументов в функцию f.
  * И так далее для всех элементов списка.
  * Если список был пуст, то просто возвращается startValue.
  *
  * Саму свёртку нужно сделать при помощи хвостовой рекурсии зная, что:
  * 1) list.head - возвращает первый элемент из списка
  * 2) list.tail - возвращает список без первого элемента, то есть хвост списка
  * 3) Nil - это пустой список
  * 4) Если список состоит из одного элемента, то tail вернёт Nil
  */

object ListFunctions extends App{


  def fold[A, B](startValue: B,
                 list: List[A])(f: (B, A) => B): B = {
    @tailrec
    def func(acc: B, list: List[A]): B =
      list match {
        case Nil => acc
        case x :: xs => func(f(acc, x), xs)
    }
    func(startValue, list)
  }





}
