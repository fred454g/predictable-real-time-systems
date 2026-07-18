package riscv.components

import chisel3._
import chisel3.util._

class ProgramCounter extends Module {
  val io = IO(new Bundle() {
    val stall = Input(Bool())
    val pcJmp = Input(Bool())
    val branchAddress = Input(UInt(32.W))

    val pc = Output(UInt(32.W))
  })

  val pcRegister = RegInit(0.U(32.W))

  val pcNew = pcRegister + 4.U
  val targetPC = Mux(io.pcJmp, io.branchAddress, pcNew)

  pcRegister := Mux(io.stall, pcRegister, targetPC)

  io.pc := pcRegister

}
