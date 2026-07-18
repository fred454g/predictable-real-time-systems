package riscv.components

import chisel3._
import chisel3.util._
import riscv.isa.Opcodes

class BranchUnit extends Module {
  val io = IO(new Bundle() {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val branch = Input(Bool())
    val funct3 = Input(UInt(3.W))

    val takeBranch = Output(Bool())
  })

  io.branch := false.B

  switch(io.funct3){
    is(Opcodes.BEQ) {io.takeBranch := io.a === io.b}
    is(Opcodes.BNE) {io.takeBranch := io.a =/= io.b}
    is(Opcodes.BLT) {io.takeBranch := io.a.asSInt < io.b.asSInt}
    is(Opcodes.BGE) {io.takeBranch := io.a.asSInt >= io.b.asSInt}
    is(Opcodes.BLTU) {io.takeBranch := (io.a < io.b)}
    is(Opcodes.BGEU) {io.takeBranch := (io.a >= io.b).asUInt}
  }
}