import java.util.ArrayList;

class Robot implements Robol {
    protected ArrayList<VarDecl> vars;
    protected Start start;
    protected ArrayList<Statement> stmts;
    protected Grid grid;

    public Robot(ArrayList<VarDecl> vLst, Start s, ArrayList<Statement> stmtLst, Grid g){
        vars = vLst;
        start = s;
        stmts = stmtLst;
        grid = g;
    }

    public String toString(){
        String str = grid.toString() + "\n";
        for(VarDecl v : vars){
            str = str + v.toString() + "\n";
        }
        str = str + start.toString() + "\n";

        for (Statement stmt : stmts){
            str = str + stmt.toString() + "\n";
        }

        return str;
    }

    public void ASTprint(String s){
        System.out.println(s + "<Robot>");
        for(VarDecl vd : vars){
            vd.ASTprint(s + "  ");
        }
        start.ASTprint(s + "  ");

        for(Statement st : stmts){
            st.ASTprint(s + "  ");
        }
        System.out.println(s + "/<Robot>");
    }

    public void robotPrint(boolean error, Position p){
        System.out.println(toString() + "**************************************");
        if(error){
            System.out.println("Error: Robot trying to go out of bounds at position: " + p.errorMsg());
        } else{
            System.out.println("The result is " + p.toString());
        }
    }

    @Override
    public void interpret() {
        String type;
        RuntimeValue retVal;
        Boolean error = false;
        Position p = start.interpret(grid);

        for (Statement s : stmts){
            type = s.getType();

            if(type.equals("stop")){
                break;
            }

            retVal = s.interpret(p);

            if(type.equals("move") && !retVal.getBoolVal()){
                error = true; break;
            } else if(type.equals("loop") && !retVal.getBoolVal()){
                error = true; break;
            }
        }
        robotPrint(error, p);
    }
}
