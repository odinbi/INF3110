class BoolExp extends Expression{
    protected Expression left;
    protected Expression right;

    protected BoolOpr opr;

    BoolExp(BoolOpr o, Expression l, Expression r){
        opr = o; left = l; right = r;
    }

    @Override
    public String toString(){
        String tmp = "(" + opr.getVal() + " " + left.toString() + " " + right.toString() + ")";
        return tmp;
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<BoolExp>");
        opr.ASTprint(s + "  ");
        left.ASTprint(s + "  ");
        right.ASTprint(s + "  ");
        System.out.println(s + "</BoolExp>");
    }

    @Override
    public RuntimeValue interpret(Position p){
        RuntimeValue temp = null;

        RuntimeValue rl = left.interpret(p);
        RuntimeValue rr = right.interpret(p);

        if(opr.getVal().equals(">")){
            temp = rl.evalGreater(rr);
        } else if(opr.getVal().equals("<")){
            temp = rl.evalLess(rr);
        } else if(opr.getVal().equals("=")){
            temp = rl.evalEqual(rr);
        } else{
            temp = null;
        }

        return temp;
    }

    @Override
    public String getType(){
        return "BoolExp";
    }
}
