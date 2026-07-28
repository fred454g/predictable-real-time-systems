package riscv.components

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import riscv.isa.BranchOps

class BranchUnitTest extends AnyFlatSpec with ChiselScalatestTester {
  "BranchUnit" should "BEQ" in {
    test(new BranchUnit) { dut =>
      dut.io.a.poke(4.U)
      dut.io.b.poke(4.U)
      dut.io.branch.poke(true)
      dut.io.funct3.poke(0.U)
    }
  }
}
