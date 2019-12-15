class BoolOpr {
    String value;

    BoolOpr(String v){
        value = v;
    }

    public String getVal(){
        return value;
    }

    public void ASTprint(String s){
        System.out.println(s + "<BoolOpr>");
        System.out.println(s + "  " + value);
        System.out.println(s + "</BoolOpr>");
    }
}
