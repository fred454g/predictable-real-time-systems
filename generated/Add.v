module Add(
  input        clock,
  input        reset,
  input  [7:0] io_a, // @[src/main/scala/empty/Add.scala 14:14]
  input  [7:0] io_b, // @[src/main/scala/empty/Add.scala 14:14]
  output [7:0] io_c // @[src/main/scala/empty/Add.scala 14:14]
);
`ifdef RANDOMIZE_REG_INIT
  reg [31:0] _RAND_0;
`endif // RANDOMIZE_REG_INIT
  reg [7:0] reg_; // @[src/main/scala/empty/Add.scala 20:20]
  wire [7:0] _reg_T_1 = io_a + io_b; // @[src/main/scala/empty/Add.scala 21:15]
  assign io_c = reg_; // @[src/main/scala/empty/Add.scala 23:8]
  always @(posedge clock) begin
    if (reset) begin // @[src/main/scala/empty/Add.scala 20:20]
      reg_ <= 8'h0; // @[src/main/scala/empty/Add.scala 20:20]
    end else begin
      reg_ <= _reg_T_1; // @[src/main/scala/empty/Add.scala 21:7]
    end
  end
// Register and memory initialization
`ifdef RANDOMIZE_GARBAGE_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_INVALID_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_REG_INIT
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_MEM_INIT
`define RANDOMIZE
`endif
`ifndef RANDOM
`define RANDOM $random
`endif
`ifdef RANDOMIZE_MEM_INIT
  integer initvar;
`endif
`ifndef SYNTHESIS
`ifdef FIRRTL_BEFORE_INITIAL
`FIRRTL_BEFORE_INITIAL
`endif
initial begin
  `ifdef RANDOMIZE
    `ifdef INIT_RANDOM
      `INIT_RANDOM
    `endif
    `ifndef VERILATOR
      `ifdef RANDOMIZE_DELAY
        #`RANDOMIZE_DELAY begin end
      `else
        #0.002 begin end
      `endif
    `endif
`ifdef RANDOMIZE_REG_INIT
  _RAND_0 = {1{`RANDOM}};
  reg_ = _RAND_0[7:0];
`endif // RANDOMIZE_REG_INIT
  `endif // RANDOMIZE
end // initial
`ifdef FIRRTL_AFTER_INITIAL
`FIRRTL_AFTER_INITIAL
`endif
`endif // SYNTHESIS
endmodule
