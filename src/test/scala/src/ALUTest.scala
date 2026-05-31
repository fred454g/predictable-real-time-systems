package src

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

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
}
