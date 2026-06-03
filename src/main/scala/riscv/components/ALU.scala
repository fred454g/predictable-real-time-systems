package riscv.components

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

  //Mux
  switch(io.op){
    is(0.U) {io.y := io.a + io.b} //plus
    is(1.U) {io.y := io.a - io.b} //sub, no overflow handling atm TODO:
    is(2.U) {io.y := io.a & io.b} //AND
    is(3.U) {io.y := io.a | io.b} //OR
    is(4.U) {io.y := io.a ^ io.b} //XOR
    is(5.U) {io.y := ~io.a} //not a
    is(6.U) {io.y := io.a << 1} //Shift left
    is(7.U) {io.y := io.a >> 1} //Shift right
    is(8.U) {io.y := io.a === io.b} // eq
    is(9.U) {io.y := io.a < io.b} //lt
    is(10.U) {io.y := (io.a.asSInt < io.b.asSInt).asUInt} //ltSigned
  }
}