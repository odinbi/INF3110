public abstract class RuntimeValue {
    abstract protected String typeName();
    abstract public String toString();

    public boolean getBoolVal() {
        return true;
    }

    public int getIntValue() {
        return 0;
    }


    public RuntimeValue evalAnd(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalOr(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalEqual(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalLess(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalLessEqual(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalGreater(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalGreaterEqual(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalAdd(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalSubtract(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalMultiply(RuntimeValue rv) {
        return null;
    }

    public RuntimeValue evalDivide(RuntimeValue rv) {
        return null;
    }

}
