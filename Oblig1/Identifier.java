class Identifier extends Expression{
    protected String ID;
    protected Expression body;

    public Identifier(String i){
        ID = i;
    }

    public void assign(Expression e){
        body = e;
    }

    public Expression getCurVal(){
        return body;
    }

    public String fullString(){
        return ID + " = " + body.toString();
    }

    @Override
    public String toString(){
        return ID;
    }

    @Override
    public String getType(){
        return "Identifier";
    }

    @Override
    public RuntimeValue interpret(Position p){
        if (body != null){
            return body.interpret(p);
        }
        return null;
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<Identifier>");
        System.out.println(s + "  " + ID);
        //body.ASTprint(s + "  ");
        System.out.println(s + "</Identifier>");
    }
}
