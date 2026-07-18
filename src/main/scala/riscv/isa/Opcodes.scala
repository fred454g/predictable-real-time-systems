package riscv.isa

import chisel3._

object Opcodes {
  val BEQ = 0.U(3.W) // Branch Equal
  val BNE = 1.U(3.W) // Branch Not Equal
  val BLT = 2.U(3.W) // Branch Less Than
  val BGE = 3.U(3.W) // Branch Greater Than Or Equal
  val BLTU = 4.U(3.W) // Branch Less Than Unsigned
  val BGEU = 5.U(3.W) // Branch Greater Than Or Equal Unsigned
}