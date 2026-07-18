package riscv.memory

import chisel3._
import chisel3.util._

class InstructionMemory(val wordCapacity: Int = 1024) extends Module {
  val io = IO(new Bundle() {
    val pc = Input(UInt(32.W))
    val instruction = Output(UInt(32.W))
  })


  val wordAddrress = io.pc(31, 2) //needed as Block RAM is word addressed and core is byte addressed

  val mem = SyncReadMem(wordCapacity, UInt(32.W))

  io.instruction := mem.read(wordAddrress)
}