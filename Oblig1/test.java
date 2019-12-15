import java.util.ArrayList;

public class test {

    public static void runTest(){
        System.out.println("==RunValTests==");
        RunIntVal rv1 = new RunIntVal(10);
        System.out.println(">rv1: " + rv1.getIntValue());

        RunBoolVal rv2 = new RunBoolVal(true);
        System.out.println(">rv2: " + rv2.getBoolVal());

        RuntimeValue rv3 = new RunIntVal(20);
        System.out.println(">rv3: " + rv3.getIntValue());

        RuntimeValue rv4 = rv1.evalAdd(rv3);
        System.out.println("> " + rv1.getIntValue() + " + " + rv3.getIntValue() +
        " = " + rv4.getIntValue());

        RuntimeValue rv5 = rv4.evalDivide(rv1);
        System.out.println("> " + rv4.getIntValue() + " / " + rv1.getIntValue() +
        " = " + rv5.getIntValue());

        rv4 = rv5.evalMultiply(rv1);
        System.out.println("> " + rv5.getIntValue() + " * " + rv1.getIntValue() +
        " = " + rv4.getIntValue());

        RuntimeValue rv6 = rv1.evalEqual(rv1);
        System.out.println("> " + rv1.getIntValue() + " == " + rv1.getIntValue() +
        " -> " + rv6.getBoolVal());

        rv6 = rv1.evalLess(rv1);
        System.out.println("> " + rv1.getIntValue() + " < " + rv1.getIntValue() +
        " -> " + rv6.getBoolVal());

        rv6 = rv3.evalGreater(rv1);
        System.out.println("> " + rv3.getIntValue() + " > " + rv1.getIntValue() +
        " -> " + rv6.getBoolVal());
    }

    public static void expressionTest(){
        System.out.println("==ExprTests==");
        //Litteral a = new Litteral(new RunIntVal(2));
        //Litteral b = new Litteral(new RunIntVal(5));
        Number a = new Number(2);
        Number b = new Number(5);
        BoolOpr bo = new BoolOpr(">");
        BoolOpr eq = new BoolOpr("=");

        BoolExp be = new BoolExp(bo, a, b);
        BoolExp eb = new BoolExp(bo, b, a);
        BoolExp bb = new BoolExp(bo, b, b);
        BoolExp aa = new BoolExp(eq, a, a);
        RuntimeValue v = be.interpret(null);

        System.out.println(be.toString() + " -> " + v.getBoolVal());

        v = eb.interpret(null);
        System.out.println(eb.toString() + " -> " + v.getBoolVal());

        v = bb.interpret(null);
        System.out.println(bb.toString() + " -> " + v.getBoolVal());

        v = aa.interpret(null);
        System.out.println(aa.toString() + " -> " + v.getBoolVal());

    }

    public static void aritTest(){
        System.out.println("==AritTests==");
        AritOpr op1 = new AritOpr("+");
        AritOpr op2 = new AritOpr("-");
        AritOpr op3 = new AritOpr("*");
        Number n1 = new Number(1);
        Number n2 = new Number(2);
        Number n3 = new Number(3);

        AritExpr ae1 = new AritExpr(op1, n1, n2);
        AritExpr ae2 = new AritExpr(op2, n3, n1);
        AritExpr ae3 = new AritExpr(op3, n3, n3);

        RuntimeValue rv = ae1.interpret(null);
        System.out.println(ae1.toString() + " = " + rv.getIntValue());

        rv = ae2.interpret(null);
        System.out.println(ae2.toString() + " = " + rv.getIntValue());

        rv = ae3.interpret(null);
        System.out.println(ae3.toString() + " = " + rv.getIntValue());
    }

    public static void assignTest(){
        System.out.println("==AssignmentTests==");

        AssignmentOpr pp = new AssignmentOpr("++");
        AssignmentOpr mm = new AssignmentOpr("--");

        Identifier i1 = new Identifier("i1");
        Identifier i2 = new Identifier("i2");

        Expression num = new Number(5);
        Expression add = new AritExpr(new AritOpr("+"), new Number(3), new Number (4));

        VarDecl vd1 = new VarDecl(i1, num);
        System.out.println(vd1.toString());

        VarDecl vd2 = new VarDecl(i2, add);
        System.out.println(vd2.toString());

        Assignment pi1 = new Assignment(i1, pp);
        System.out.println(pi1.toString());

        pi1.interpret(null);
        System.out.println(i1.fullString());

        pi1.interpret(null);
        System.out.println(i1.fullString());

        pi1.interpret(null);
        System.out.println(i1.fullString());

        Assignment pi2 = new Assignment(i2, mm);
        System.out.println(pi2.toString());

        pi2.interpret(null);
        System.out.println(i2.fullString());

        pi2.interpret(null);
        System.out.println(i2.fullString());

        pi2.interpret(null);
        System.out.println(i2.fullString());
    }

    public static void loopTest(){
        System.out.println("==LoopTests==");
        Identifier i = new Identifier("i");
        Expression num = new Number(5);

        Identifier in = new Identifier("in");
        Expression n = new Number(0);

        VarDecl vd = new VarDecl(i, num);
        VarDecl vd2 = new VarDecl(in, n);

        AssignmentOpr pp = new AssignmentOpr("++");
        AssignmentOpr mm = new AssignmentOpr("--");
        Assignment a1 = new Assignment(i, mm);
        Assignment a2 = new Assignment(in, pp);

        ArrayList<Statement> stmts = new ArrayList<>();
        stmts.add(a1); stmts.add(a2);

        BoolOpr bo = new BoolOpr(">");
        Number end = new Number(0);

        BoolExp cond = new BoolExp(bo, i, in);

        System.out.println(i.fullString());
        System.out.println(in.fullString());

        Loop lp = new Loop(cond, stmts);

        System.out.println(lp.toString());

        RuntimeValue dummy = lp.interpret(null);

        System.out.println(i.fullString());
        System.out.println(in.fullString());
    }

    public static void moveTest(){
        System.out.println("==MoveTests==");
        Grid grd = new Grid(64, 64);
        Start strt = new Start(4, 60);
        Position pos = strt.interpret(grd);

        Expression e1 = new Number(1);

        Move nor = new Move(Direction.getDirection("north"), e1);
        Move wes = new Move(Direction.getDirection("west"), e1);

        System.out.println("Grid: " + grd.toString());
        System.out.println(strt.toString());
        System.out.println("Position: " + pos.toString());
        System.out.println("Move: " + nor.toString());
        System.out.println("Move: " + wes.toString());

        RuntimeValue bool = nor.interpret(pos);
        while(true){
            if(bool.getBoolVal()){
                System.out.println("Position: " + pos.toString());
            } else{
                System.out.println("Error: Robot trying to go out of bounds at position: " + pos.errorMsg());
                break;
            }
            bool = nor.interpret(pos);
        }

        while(true){
            bool = wes.interpret(pos);
            if(bool.getBoolVal()){
                System.out.println("Position: " + pos.toString());
            } else{
                System.out.println("Error: Robot trying to go out of bounds at position: " + pos.errorMsg());
                break;
            }
        }

        pos = new Position(60, 4, grd);

        Move sth = new Move(Direction.getDirection("south"), e1);
        Move est = new Move(Direction.getDirection("east"), e1);

        System.out.println("Grid: " + grd.toString());
        System.out.println("Position: " + pos.toString());
        System.out.println("Move: " + sth.toString());
        System.out.println("Move: " + est.toString());

        while(true){
            bool = sth.interpret(pos);
            if(bool.getBoolVal()){
                System.out.println("Position: " + pos.toString());
            } else{
                System.out.println("Error: Robot trying to go out of bounds at position: " + pos.errorMsg());
                break;
            }
        }

        while(true){
            bool = est.interpret(pos);
            if(bool.getBoolVal()){
                System.out.println("Position: " + pos.toString());
            } else{
                System.out.println("Error: Robot trying to go out of bounds at position: " + pos.errorMsg());
                break;
            }
        }
    }

    public static void main(String[] args){
        runTest();

        expressionTest();

        aritTest();

        assignTest();

        loopTest();

        moveTest();
    }
}
