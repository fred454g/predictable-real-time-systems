package riscv.isa

import chisel3._

object ImmediateGeneratorOps {
  // R-Type
  val OP_ALU    = 51.U(7.W)  // 7'b0110011

  // I-Type
  val OP_LOAD   = 3.U(7.W)   // 7'b0000011
  val OP_ALUI   = 19.U(7.W)  // 7'b0010011
  val OP_JALR   = 103.U(7.W) // 7'b1100111

  // S-Type
  val OP_STORE  = 35.U(7.W)  // 7'b0100011

  // B-Type
  val OP_BRANCH = 99.U(7.W)  // 7'b1100011

  // U-Type
  val OP_LUI    = 55.U(7.W)  // 7'b0110111
  val OP_AUIPC  = 23.U(7.W)  // 7'b0010011

  // J-Type
  val OP_JAL    = 111.U(7.W) // 7'b1101111
}