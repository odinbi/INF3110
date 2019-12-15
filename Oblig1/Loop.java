import java.util.ArrayList;

class Loop extends Statement {
    BoolExp condition;
    ArrayList<Statement> Statements;

    public Loop(BoolExp cond, ArrayList<Statement> stmts){
        condition = cond;
        Statements = stmts;
    }

    @Override
    public void interpret(){
        return;
    }

    @Override
    public RuntimeValue interpret(Position p){
        RuntimeValue cond = null;
        RuntimeValue temp = null;

        while(true){
            cond = condition.interpret(p);

            if(cond.getBoolVal()){
                break;
            }

            for(Statement s : Statements){
                temp = s.interpret(p);
                if(!temp.getBoolVal()){
                    return temp;
                }
            }
        }
        return temp;
    }

    @Override
    public String getType(){
        return "loop";
    }

    @Override
    public String toString(){

        String s = "loop\n{\n  break-if " + condition.toString();
        for(Statement stmt : Statements){
            s = s + "\n  " + stmt.toString();
        }
        s = s + "\n}";
        return s;
    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<Loop>");
        condition.ASTprint(s + "  ");
        for(Statement st : Statements){
            st.ASTprint(s + "  ");
        }
        System.out.println(s + "</Loop>");
    }
}
