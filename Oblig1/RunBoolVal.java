public class RunBoolVal extends RuntimeValue{
    protected boolean val;

    @Override
    public String typeName(){
        return "boolean";
    }

    @Override
    public String toString(){
        return "" + val;
    }

    public RunBoolVal(boolean v){
        val = v;
    }

    @Override
    public boolean getBoolVal(){
        return val;
    }

    @Override
    public RuntimeValue evalEqual(RuntimeValue rv) {
        if (rv.getBoolVal() == val) {
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalAnd(RuntimeValue rv) {
        if (rv.getBoolVal() && val){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }

    @Override
    public RuntimeValue evalOr(RuntimeValue rv) {
        if (val || rv.getBoolVal()){
            return new RunBoolVal(true);
        }
        return new RunBoolVal(false);
    }
}
