package riscv.isa

import chisel3._

object ALUOps {
  val ADD  = 0.U(4.W)
  val SUB  = 1.U(4.W)
  val AND  = 2.U(4.W)
  val OR   = 3.U(4.W)
  val XOR  = 4.U(4.W)
  val EQ   = 5.U(4.W)
  val LTU  = 6.U(4.W)
  val LTS  = 7.U(4.W)
  val SLL  = 8.U(4.W)
  val SRL  = 9.U(4.W)
  val SRA  = 10.U(4.W)
}