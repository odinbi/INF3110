public class RunIntVal extends RuntimeValue{
    protected int value;

    @Override
    public String typeName(){
        return "integer";
    }

    @Override
    public String toString(){
        return "" + value;
    }

    @Override
    public int getIntValue() {
        return value;
    }

    public RunIntVal(int i){
        value = i;
    }

    @Override
    public RuntimeValue evalEqual(RuntimeValue rv) {
        if(value == rv.getIntValue()){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalLess(RuntimeValue rv) {
        if(value < rv.getIntValue()){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalLessEqual(RuntimeValue rv) {
        if(value <= rv.getIntValue()){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalGreater(RuntimeValue rv) {
        if(value > rv.getIntValue()){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalGreaterEqual(RuntimeValue rv) {
        if(value >= rv.getIntValue()){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalAdd(RuntimeValue rv) {
        int temp;
        temp = value + rv.getIntValue();
        return new RunIntVal(temp);
    }

    @Override
    public RuntimeValue evalSubtract(RuntimeValue rv) {
        int temp;
        temp = value - rv.getIntValue();
        return new RunIntVal(temp);
    }

    @Override
    public RuntimeValue evalMultiply(RuntimeValue rv) {
        int temp;
        temp = value * rv.getIntValue();
        return new RunIntVal(temp);
    }

    @Override
    public RuntimeValue evalDivide(RuntimeValue rv) {
        int temp;
        temp = value / rv.getIntValue();
        return new RunIntVal(temp);
    }

}
