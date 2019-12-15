import java.util.ArrayList;

public class Oblig1 {

    public static void main(String[] args){

        TestCode test = new TestCode();

        if(args.length > 1 && args[1].equals("ASTon")){
            test.astPrt = true;
        }


        switch(args.length > 0 ? args[0] : "" ) {
            case "1" :
                test.runProgram1(); return;
            case "2" :
                test.runProgram2(); return;
            case "3" :
                test.runProgram3(); return;
            case "4" :
                test.runProgram4(); return;
            case "all" :
                test.runAll(); return;
            default :
                System.out.println("USAGE: java Oblig1 1|2|3|4|all <ASTon>"); return;
        }
    }
}

class TestCode {
    Grid grid;
    Start start;
    ArrayList<Statement> statements;
    ArrayList<VarDecl> vars;
    Program pro;
    Robot rob;

    boolean astPrt = false;

    void runProgram1(){
        statements = new ArrayList<>();
        vars = new ArrayList<>();

        grid = new Grid(64, 64);
        start = new Start(23,30);
        statements.add(new Move(Direction.getDirection("west"), new Number(15)));
        statements.add(new Move(Direction.getDirection("south"), new Number(15)));
        statements.add(new Move(Direction.getDirection("east"),
                new AritExpr(new AritOpr("+"), new Number(2), new Number(3))));
        statements.add(new Move(Direction.getDirection("north"),
                new AritExpr(new AritOpr("+"), new Number(10), new Number(27))));
        statements.add(new Stop());

        rob = new Robot(vars, start, statements, grid);
        pro = new Program(grid, rob);

        System.out.println("\n**************************************\n" +
        "Test Program 1");

        if(astPrt){
            pro.ASTprint();
        } else{
            pro.interpret();
        }
    }

    void runProgram2(){
        statements = new ArrayList<>();
        vars = new ArrayList<>();

        grid = new Grid(64, 64);
        Identifier i = new Identifier("i"); Identifier j = new Identifier("j");
        vars.add(new VarDecl(i, new Number(5)));
        vars.add(new VarDecl(j, new Number(3)));
        start = new Start(23,6);
        statements.add(new Move(Direction.getDirection("north"),
                    new AritExpr(new AritOpr("*"), new Number(3), i)));
        statements.add(new Move(Direction.getDirection("east"), new Number(15)));
        statements.add(new Move(Direction.getDirection("south"), new Number(4)));
        statements.add(new Move(Direction.getDirection("west"),
            new AritExpr(new AritOpr("+"),
                new AritExpr(new AritOpr("*"), new Number(2), i),
                new AritExpr(new AritOpr("*"), new Number(3), j))));
        statements.add(new Stop());

        rob = new Robot(vars, start, statements, grid);
        pro = new Program(grid, rob);

        System.out.println("\n**************************************\n" +
        "Test Program 2");

        if(astPrt){
            pro.ASTprint();
        } else{
            pro.interpret();
        }
    }

    void runProgram3(){
        statements = new ArrayList<>();
        vars = new ArrayList<>();

        grid = new Grid(64, 64);

        Identifier i = new Identifier("i"); Identifier j = new Identifier("j");
        vars.add(new VarDecl(i, new Number(5)));
        vars.add(new VarDecl(j, new Number(3)));

        start = new Start(23,6);

        statements.add(new Move(Direction.getDirection("north"),
                    new AritExpr(new AritOpr("*"), new Number(3), i)));
        statements.add(new Move(Direction.getDirection("west"), new Number(15)));
        statements.add(new Move(Direction.getDirection("east"), new Number(4)));

        ArrayList<Statement> loopStmts = new ArrayList<>();
        loopStmts.add(new Move(Direction.getDirection("south"), j));
        loopStmts.add(new Assignment(j, new AssignmentOpr("--")));
        Loop loop = new Loop(new BoolExp(new BoolOpr("<"), j, new Number(1)), loopStmts);
        statements.add(loop);

        statements.add(new Stop());


        rob = new Robot(vars, start, statements, grid);
        pro = new Program(grid, rob);

        System.out.println("\n**************************************\n" +
        "Test Program 3");

        if(astPrt){
            pro.ASTprint();
        } else{
            pro.interpret();
        }
    }

    void runProgram4(){
        statements = new ArrayList<>();
        vars = new ArrayList<>();

        grid = new Grid(64, 64);

        Identifier j = new Identifier("j");
        vars.add(new VarDecl(j, new Number(3)));

        start = new Start(1,1);

        ArrayList<Statement> loopStmts = new ArrayList<>();
        loopStmts.add(new Move(Direction.getDirection("north"), j));
        Loop loop = new Loop(new BoolExp(new BoolOpr(">"), j, new Number(100)), loopStmts);
        statements.add(loop);

        statements.add(new Stop());

        rob = new Robot(vars, start, statements, grid);
        pro = new Program(grid, rob);

        System.out.println("\n**************************************\n" +
        "Test Program 4");

        if(astPrt){
            pro.ASTprint();
        } else{
            pro.interpret();
        }
    }

    void runAll(){
        runProgram1();
        runProgram2();
        runProgram3();
        runProgram4();
    }
}
