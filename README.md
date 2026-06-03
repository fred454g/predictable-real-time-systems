# Time Predictable Risc V core


This is used as a learning project to further build upon the learnings @DTU about Risc V as well as aiming towards
time predictability. This stems from the analysis of the trajectory of the world of physical AI. 
It seems like we need systems that are not only correct, but correct in due time.
I hope to be able to make this an artifact that will eventually make it from silicon to intelligence. 

Meaning that eventually this will unfold into a real world system, either within robotics or other autonomous usecases.


## V1
Arithmetic/logical:
ADD, SUB, AND, OR, XOR

Shifts:
SLL, SRL, SRA

Comparisons:
SLT, SLTU

Immediate arithmetic:
ADDI, ANDI, ORI, XORI, SLTI, SLTIU

Memory:
LW, SW

Branches:
BEQ, BNE, BLT, BGE, BLTU, BGEU

Jumps:
JAL, JALR

Upper immediates:
LUI, AUIPC

## Architecture
## Directory Structure

```text
src/main/scala/riscv/                 ← main hardware source code
├── core/                             ← top-level CPU structure
│   ├── Core.scala                    ← top-level core wrapper
│   ├── Datapath.scala                ← wires PC, register file, ALU, memory, etc.
│   └── Control.scala                 ← decodes instructions into control signals
│
├── components/                       ← reusable CPU building blocks
│   ├── ALU.scala                     ← arithmetic, logic, shifts, comparisons
│   ├── RegisterFile.scala            ← 32 × 32-bit RISC-V register file
│   ├── ImmediateGenerator.scala      ← extracts/sign-extends immediates
│   ├── ProgramCounter.scala          ← holds and updates the PC
│   └── BranchUnit.scala              ← decides whether branches are taken
│
├── memory/                           ← simple fixed-latency memories
│   ├── InstructionMemory.scala       ← instruction fetch memory
│   └── DataMemory.scala              ← load/store data memory
│
├── isa/                              ← RISC-V constants and encodings
│   ├── Instructions.scala            ← instruction-level helpers/patterns
│   ├── ALUOps.scala                  ← internal ALU operation codes
│   ├── Opcodes.scala                 ← RISC-V opcode constants
│   ├── Funct3.scala                  ← funct3 constants
│   └── Funct7.scala                  ← funct7 constants
│
└── util/                             ← shared utilities/constants
    └── Constants.scala               ← global widths, reset values, config constants


src/test/scala/riscv/                 ← test source code
├── components/                       ← unit tests for individual modules
│   ├── ALUTest.scala                 ← ALU operation tests
│   ├── RegisterFileTest.scala        ← register read/write tests
│   ├── ImmediateGeneratorTest.scala  ← immediate decoding tests
│   └── BranchUnitTest.scala          ← branch condition tests
│
└── core/                             ← integration-level tests
    └── CoreTest.scala                ← tests for complete core behavior

```




## To generate verilog:

```bash
make
```

Run the tests with:
```bash
make test
```

Cleanup the repository with:
```bash
make clean
```
## rules for the project:
- no LLMs, no copy paste, only hand written code.

## sources
Started from this empty Chisel repo: https://github.com/schoeberl/chisel-empty
Chisel book: https://github.com/schoeberl/chisel-book
Patterson & Hennessy computer organization and design - Risc-V edition
From the original course i took: https://github.com/schoeberl/risc-v-lab
