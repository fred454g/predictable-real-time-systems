package riscv.memory

import chisel3._

class DataMemory(val wordCapacity: Int = 1024) extends Module {
  val io = IO(new Bundle() {
    val address = Input(UInt(32.W))
    val writeData = Input(UInt(32.W))

    val memWrite = Input(Bool())
    val memRead = Input(Bool())

    val readData = Output(UInt(32.W))
  })

  val wordAddress = io.address(31, 2) //byte index -> words index

  val mem = SyncReadMem(wordCapacity, UInt(32.W))

  io.readData := mem.read(wordAddress, io.memRead)

  when(io.memWrite){
    mem.write(wordAddress, io.writeData)
  }
}