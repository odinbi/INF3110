class VarDecl {
    protected Identifier ID;
    protected Expression body;

    public VarDecl(Identifier i, Expression e){
        i.assign(e);
        ID = i;
        body = e;
    }

    public Identifier getID(){
        return ID;
    }

    public String getType(){
        return "VarDecl";
    }

    public void ASTprint(String s){
        System.out.println(s + "<Var-Decl>");
        ID.ASTprint(s + "  ");
        body.ASTprint(s + "  ");
        System.out.println(s + "</Var-Decl>");
    }

    public String toString(){
        return "var " + ID.toString() + " = " + body.toString();
    }
}
