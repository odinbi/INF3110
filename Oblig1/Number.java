class Number extends Expression{
    protected int value;

    public Number (int val){
        value = val;
    }

    @Override
    public RuntimeValue interpret(Position p){
        return new RunIntVal(value);
    }

    @Override
    public String toString(){
        return "" + value;
    }

    @Override
    public String getType(){
        return "Number";
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<Number>");
        System.out.println(s + "  " + value);
        System.out.println(s + "</Number>");
    }
}
