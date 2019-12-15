class AritOpr {
    protected String value;

    public AritOpr (String val){
        value = val;
    }

    public String getVal(){
        return value;
    }

    public String toString(){
        return value;
    }

    public void ASTprint(String s){
        System.out.println(s + "<AritOpr>");
        System.out.println(s + "  " + value);
        System.out.println(s + "</AritOpr>");
    }

}
