package riscv.components

import chisel3._


class  RegisterFile extends Module {

  val io = IO(new Bundle {
    val rs1Addr = Input(UInt(5.W))
    val rs2Addr = Input(UInt(5.W))

    val rs1Data = Output(UInt(32.W))
    val rs2Data = Output(UInt(32.W))

    val rdAddr = Input(UInt(5.W))
    val writeData = Input(UInt(32.W))
    val regWrite = Input(Bool())
  })


  val registers = RegInit(VecInit(Seq.fill(32)(0.U(32.W))))

  io.rs1Data := Mux(io.rs1Addr === 0.U, 0.U, registers(io.rs1Addr))
  io.rs2Data := Mux(io.rs2Addr === 0.U, 0.U, registers(io.rs2Addr))

  when(io.regWrite && io.rdAddr =/= 0.U){
    registers(io.rdAddr) := io.writeData
  }
}
