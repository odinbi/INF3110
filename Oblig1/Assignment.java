class Assignment extends Statement {
    protected Identifier id;
    protected AssignmentOpr opr;

    public Assignment(Identifier i, AssignmentOpr op){
        id = i;
        opr = op;
    }

    @Override
    public String getType(){
        return "Assignment<";
    }

    @Override
    public String toString(){
        return id.toString() + opr.toString();
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<Assignment>");
        id.ASTprint(s + "  ");
        opr.ASTprint(s + "  ");
        System.out.println(s + "</Assignment>");
    }

    @Override
    public void interpret(){
        return;
    }

    @Override
    public RuntimeValue interpret(Position p){
        String op = opr.toString();
        RuntimeValue temp = null;
        RuntimeValue one = new RunIntVal(1);
        Number num;

        if(op.equals("++")){
            temp = id.interpret(p);
            temp = temp.evalAdd(one);
            num = new Number(temp.getIntValue());
            id.assign(num);
        } else if(op.equals("--")){
            temp = id.interpret(p);
            temp = temp.evalSubtract(one);
            num = new Number(temp.getIntValue());
            id.assign(num);
        }
        return temp;
    }
}
