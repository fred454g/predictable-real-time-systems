package riscv.components

import chisel3._
import chisel3.util._
import riscv.isa.BranchOps

class BranchUnit extends Module {
  val io = IO(new Bundle() {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val branch = Input(Bool())
    val funct3 = Input(UInt(3.W))

    val takeBranch = Output(Bool())
  })

  io.takeBranch := false.B
  when(io.branch){
    switch(io.funct3){
      is(BranchOps.BEQ) {io.takeBranch := io.a === io.b}
      is(BranchOps.BNE) {io.takeBranch := io.a =/= io.b}
      is(BranchOps.BLT) {io.takeBranch := io.a.asSInt < io.b.asSInt}
      is(BranchOps.BGE) {io.takeBranch := io.a.asSInt >= io.b.asSInt}
      is(BranchOps.BLTU) {io.takeBranch := (io.a < io.b)}
      is(BranchOps.BGEU) {io.takeBranch := (io.a >= io.b)}
    }
  }
}