class Stop extends Statement {

    @Override
    public void interpret(){
        return;
    }

    @Override
    public RuntimeValue interpret(Position p){
        return null;
    }

    @Override
    public String getType(){
        return "stop";
    }

    @Override
    public String toString(){
        return "stop";
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<Stop>");
        System.out.println(s + "</Stop>");
    }
}
