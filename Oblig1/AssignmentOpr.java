class AssignmentOpr{
    String opr;

    public AssignmentOpr(String o){
        opr = o;
    }

    public String toString(){
        return opr;
    }

    public String getType(){
        return "AssignmentOpr";
    }

    public void ASTprint(String s){
        System.out.println(s + "<AssignmentOpr>");
        System.out.println(s + "  " + opr);
        System.out.println(s + "</AssignmentOpr>");
    }
}
