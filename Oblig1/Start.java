class Start{

    protected int xAxis;
    protected int yAxis;

    public Start(int x, int y){
        xAxis = x;
        yAxis = y;
    }

    public RuntimeValue getX(){
        return new RunIntVal(xAxis);
    }

    public RuntimeValue getY(){
        return new RunIntVal(yAxis);
    }

    public Position interpret(Grid g){
        return new Position(xAxis, yAxis, g);
    }

    public void ASTprint(String s){
        System.out.println(s + "<Start>");
        System.out.println(s + "  (" + xAxis + ", " + yAxis + ")");
        System.out.println(s + "</Start>");
    }

    public String toString(){
        return "start(" + xAxis + ", " + yAxis + ")";
    }
}
