package riscv.components

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import riscv.ALU

class ALUTest extends AnyFlatSpec with ChiselScalatestTester {
  "ALU" should "perform addition of 2 numbers corectly" in {
    test(new ALU) { dut =>
      dut.io.a.poke(5.U)
      dut.io.b.poke(3.U)
      dut.io.op.poke(0.U)
      dut.io.y.expect(8.U)
    }
  }

  it should "subtract 2 numbers correctly" in {
    test(new ALU) { dut =>
      dut.io.a.poke(4.U)
      dut.io.b.poke(3.U)
      dut.io.op.poke(1.U)
      dut.io.y.expect(1.U)
    }
  }

  it should "return AND of 2 numbers" in {
    test(new ALU) { dut =>
      dut.io.a.poke("b00110011".U)
      dut.io.b.poke("b11010010".U)
      dut.io.op.poke(2.U)
      dut.io.y.expect("b00010010".U)
    }
  }

  it should "return OR of 2 numbers" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b11110000".U)
      dut.io.b.poke("b00000000".U)
      dut.io.op.poke(3.U)
      dut.io.y.expect("b11110000".U)
    }
  }

  it should "return XOR of the 2 numbers" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b10010000".U)
      dut.io.b.poke("b00000001".U)
      dut.io.op.poke(4.U)
      dut.io.y.expect("b10010001".U)
    }
  }

  it should "return not of a" in {
    test(new  ALU) {dut =>
      dut.io.a.poke("b10010001".U)
      dut.io.op.poke(5.U)
      dut.io.y.expect("b01101110".U)
    }
  }

  it should "Shift a left by one" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b01000000".U)
      dut.io.op.poke(6.U)
      dut.io.y.expect("b10000000".U)
    }
  }

  it should "Shift a right by one" in {
    test(new ALU) {dut =>
      dut.io.a.poke("b10000000".U)
      dut.io.op.poke(7.U)
      dut.io.y.expect("b01000000".U)
    }
  }


}
