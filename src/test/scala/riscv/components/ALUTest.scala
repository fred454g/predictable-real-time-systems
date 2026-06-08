package riscv.components

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import riscv.isa.ALUOps

class ALUTest extends AnyFlatSpec with ChiselScalatestTester {
  "ALU" should "perform addition of 2 numbers corectly" in {
    test(new ALU) { dut =>
      dut.io.a.poke(5.U)
      dut.io.b.poke(3.U)
      dut.io.op.poke(ALUOps.ADD)
      dut.io.y.expect(8.U)
    }
  }

  it should "subtract 2 numbers correctly" in {
    test(new ALU) { dut =>
      dut.io.a.poke(4.U)
      dut.io.b.poke(3.U)
      dut.io.op.poke(ALUOps.SUB)
      dut.io.y.expect(1.U)
    }
  }

  it should "return AND of 2 numbers" in {
    test(new ALU) { dut =>
      dut.io.a.poke("b00110011001100110011001100110011".U)
      dut.io.b.poke("b11010010110100101101001011010010".U)
      dut.io.op.poke(ALUOps.AND)
      dut.io.y.expect("b00010010000100100001001000010010".U)
    }
  }

  it should "return OR of 2 numbers" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b11110000111100001111000011110000".U)
      dut.io.b.poke("b00000000000000000000000000000000".U)
      dut.io.op.poke(ALUOps.OR)
      dut.io.y.expect("b11110000111100001111000011110000".U)
    }
  }

  it should "return XOR of the 2 numbers" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b10010000100100001001000010010000".U)
      dut.io.b.poke("b00000001000000010000000100000001".U)
      dut.io.op.poke(ALUOps.XOR)
      dut.io.y.expect("b10010001100100011001000110010001".U)
    }
  }

  it should "return 1 as a and b is equal" in {
    test(new  ALU) {dut =>
      dut.io.a.poke("b10000000100000001000000010000000".U)
      dut.io.b.poke("b10000000100000001000000010000000".U)
      dut.io.op.poke(ALUOps.EQ)
      dut.io.y.expect(1.U)
    }
  }

  it should "return 1 as a is less than b unsigned" in {
    test(new ALU) {dut =>
      dut.io.a.poke(3.U)
      dut.io.b.poke(4.U)
      dut.io.op.poke(ALUOps.LTU)
      dut.io.y.expect(1.U)
    }
  }

  it should "return 1 as a (signed) is less than b (signed)" in {
    test(new ALU) {dut =>
      dut.io.a.poke("hFFFFFFFB".U) //-5 as 32-bit 2's compliment
      dut.io.b.poke(1)
      dut.io.op.poke(ALUOps.LTS)
      dut.io.y.expect(1.U)
    }
  }

  it should "Shift a left by shamt" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b01000000000000000000000000000000".U)
      dut.io.b.poke("b11100000000000000000000000000001".U)
      dut.io.op.poke(ALUOps.SLL)
      dut.io.y.expect("b10000000000000000000000000000000".U)
    }
  }

  it should "Shift a right by shamt" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b10000000100000001000000010000000".U)
      dut.io.b.poke("b10000000100000001000000010000011".U)
      dut.io.op.poke(ALUOps.SRL)
      dut.io.y.expect("b00010000000100000001000000010000".U)
    }
  }



}
