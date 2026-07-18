package riscv.components

import chisel3._

object OPS {
  val BEQ = 0.U(3.W)
  val BNE = 1.U(3.W)
  val BLT = 2.U(3.W)
  val BGE = 3.U(3.W)
  val BLTU = 4.U(3.W)
  val BGEU = 5.U(3.W)
  val JAL = 6.U(3.W)
  val JALR = 7.U(3.W)
}