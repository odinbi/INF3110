public class Move extends Statement{

    protected Direction dir;
    protected Expression expr;

    public Move(Direction d, Expression e){
        dir = d;
        expr = e;
    }

    @Override
    public String getType(){
        return "Move";
    }

    @Override
    public String toString(){
        return dir.toString() + " " + expr.toString();
    }

    @Override
    public void interpret(){
        return;
    }

    @Override
    public RuntimeValue interpret(Position p){
        RuntimeValue tmpBool = new RunBoolVal(false);
        RuntimeValue tmp = expr.interpret(p);
        switch(dir){
            case north:
                tmpBool = p.north(tmp); break;
            case south:
                tmpBool = p.south(tmp); break;
            case east:
                tmpBool = p.east(tmp); break;
            case west:
                tmpBool = p.west(tmp); break;
        }
        return tmpBool;

    }

    @Override
    public void ASTprint(String s){
        System.out.println(s + "<Move>");
        dir.ASTprint(s + "  ");
        expr.ASTprint(s + "  ");
        System.out.println(s + "</Move>");
    }
}
