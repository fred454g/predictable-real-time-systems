package riscv.isa

import chisel3._

object ALUOps {
  val ADD  = 0.U(4.W)
  val SUB  = 1.U(4.W)
  val AND  = 2.U(4.W)
  val OR   = 3.U(4.W)
  val XOR  = 4.U(4.W)
  val SLT = 5.U(4.W) //set less than
  val SLTU  = 6.U(4.W) //set less than unsigned
  val SLL  = 7.U(4.W) //shift left logical
  val SRL  = 8.U(4.W) //shift right logical
  val SRA  = 9.U(4.W) //shift right arithmethic
  val PASS_B = 10.U(4.W)
}