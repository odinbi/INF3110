class AritExpr extends Expression {
    protected AritOpr opr;
    protected Expression left;
    protected Expression right;

    public AritExpr (AritOpr op, Expression l, Expression r){
        opr = op; left = l; right = r;
    }

    @Override
    public RuntimeValue interpret(Position p){
        String op = opr.getVal();
        RuntimeValue l = left.interpret(p);
        RuntimeValue r = right.interpret(p);
        if(op.equals("+")){
            return l.evalAdd(r);
        } else if(op.equals("-")){
            return l.evalSubtract(r);
        } else if(op.equals("*")){
            return l.evalMultiply(r);
        } else{
            return null;
        }
    }

    @Override
    public String toString(){
        return "(" + opr.toString() + " " + left.toString() + " " + right.toString() + ")";
    }

    @Override
    public String getType(){
        return "AritExpr";
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<AritExpr>");
        opr.ASTprint(s + "  ");
        left.ASTprint(s + "  ");
        right.ASTprint(s + "  ");
        System.out.println(s + "</AritExpr>");
    }
}
