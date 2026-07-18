package riscv.components

import chisel3._
import chisel3.util._



import riscv.isa.

class BranchUnit extends Module {
  val io = IO(new Bundle() {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val branch = Input(Bool)

  })
}