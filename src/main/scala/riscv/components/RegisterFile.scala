package riscv.components

import chisel3._


class  RegisterFile extends Module {

  val io = IO(new Bundle {
    val rs1 = Input(UInt(5.W))
    val rs2 = Input(UInt(5.W))
    val rd = Input(UInt(5.W))


  })


  RegInit(VecInit(Seq.fill(32)(0.U(32.W))))

}
