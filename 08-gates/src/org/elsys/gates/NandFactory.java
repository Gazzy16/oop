package org.elsys.gates;

public abstract class NandFactory {
	
	public static Gate makeNotGate(Wire in, Wire out, String Name){
		NandGate n = new NandGate(in, in, out);
		return n;
	}

	public static Gate makeNotGate(Wire in, Wire out) {
		return makeNotGate(in, out, "NandNot");
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate andGate = new CompositeGate(name);
		Wire out2 = new Wire("out2");
		
		andGate.addInput(in1);
		andGate.addInput(in2);
		andGate.addOutput(out2);
		
		NandGate a = new NandGate(in1, in2, out2);
		NandGate n = new NandGate(out2, out2, out);
		
		andGate.addGate(a);
		andGate.addGate(n);
		
		return andGate;
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
		return makeAndGate(in1, in2, out, "NandAnd");
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate orGate = new CompositeGate(name);
		Wire out2 = new Wire("out2");
		Wire out3 = new Wire("out3");
		
		orGate.addInput(in1);
		orGate.addInput(in2);
		orGate.addOutput(out2);
		orGate.addOutput(out3);
		
		NandGate nand1 = new NandGate(in1, in1, out2);
		NandGate nand2 = new NandGate(in2, in2, out3);
		NandGate nand3 = new NandGate(out2, out3, out);
		
		orGate.addGate(nand1);
		orGate.addGate(nand2);
		orGate.addGate(nand3);
		
		return orGate;
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
		return makeOrGate(in1, in2, out, "NandOr");
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate xorGate = new CompositeGate(name);
		Wire out2 = new Wire("out2");
		Wire out3 = new Wire("out3");
		Wire out4 = new Wire("out4");
		
		xorGate.addInput(in1);
		xorGate.addInput(in2);
		xorGate.addOutput(out2);
		xorGate.addOutput(out3);
		xorGate.addOutput(out4);
		
		NandGate nand1 = new NandGate(in1, in2, out2);
		NandGate nand2 = new NandGate(in1, out2, out3);
		NandGate nand3 = new NandGate(in2, out2, out4);
		NandGate nand4 = new NandGate(out4, out3, out);
		
		xorGate.addGate(nand1);
		xorGate.addGate(nand2);
		xorGate.addGate(nand3);
		xorGate.addGate(nand4);
		
		return xorGate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "NandXor");
	}

}
