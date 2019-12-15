class Program implements Robol{
    Grid grid;
    Robot robot;

    public Program(Grid grid, Robot robot) {
        this.grid = grid; this.robot = robot;
    }

    public void ASTprint(){
        System.out.println("<Program>");
        grid.ASTprint("  ");
        robot.ASTprint("  ");
        System.out.println("</Program>");
    }

    public void interpret() {
        robot.interpret();
    }
}
