package riscv.components

import riscv.isa.ALUOps
import chisel3._
import chisel3.util.{is, switch}

class ALU extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val op = Input(UInt(4.W))
    val y = Output(UInt(32.W))
  })
  io.y := 0.U

  val shamt = io.b(4,0)

  switch(io.op){
    is(ALUOps.ADD) {io.y := io.a + io.b} //add
    is(ALUOps.SUB) {io.y := io.a - io.b} //sub
    is(ALUOps.AND) {io.y := io.a & io.b} //AND
    is(ALUOps.OR) {io.y := io.a | io.b} //OR
    is(ALUOps.XOR) {io.y := io.a ^ io.b} //XOR
    is(ALUOps.SLT) {io.y := (io.a.asSInt < io.b.asSInt).asUInt} //set less than Signed
    is(ALUOps.SLTU) {io.y := (io.a < io.b).asUInt} //set less than unsigned
    is(ALUOps.SLL) {io.y := io.a << shamt} //Shift left logical
    is(ALUOps.SRL) {io.y := io.a >> shamt} //Shift right logical
    is(ALUOps.SRA) {io.y := (io.a.asSInt >> shamt).asUInt} //Shift right arithmetic
    is(ALUOps.PASS_B) {io.y := io.b}
  }
}