package riscv

import chisel3._
import chisel3.util.{is, switch}


/*
TODO:
ADD 32 bit
SUB 32 bit
AND 32 bit
OR 32 bit
XOR 32 bit
NOT 32 bit
SLL 32 bit
SRL 32 bit
EQ 32 bit
LT unsigned 32 bit
LT signed 32 bit
 */
class ALU extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val op = Input(UInt(4.W))
    val y = Output(UInt(8.W))
  })
  io.y := 0.U

  //Mux
  switch(io.op){
    is(0.U) {io.y := io.a + io.b} //plus
    is(1.U) {io.y := io.a - io.b} //minus
    is(2.U) {io.y := io.a & io.b} //AND
    is(3.U) {io.y := io.a | io.b} //OR
    is(4.U) {io.y := io.a ^ io.b} //XOR
    is(5.U) {io.y := ~io.a} //not a
    is(6.U) {io.y := io.a << 1} //Shift left
    is(7.U) {io.y := io.a >> 1} //Shift right
  }
}