class Grid {

    protected int xAxis;
    protected int yAxis;

    public Grid(int x, int y){
        xAxis = x;
        yAxis = y;
    }

    public RuntimeValue getX(){
        RuntimeValue ret = new RunIntVal(xAxis);
        return ret;
    }

    public RuntimeValue getY(){
        RuntimeValue ret = new RunIntVal(yAxis);
        return ret;
    }

    public void ASTprint(String s){
        System.out.println(s + "<Grid>");
        System.out.println(s + "  " + toString());
        System.out.println(s + "</Grid>");
        return;
    }

    public String toString(){
        return "size(" + xAxis + "*" + yAxis + ")";
    }
}
