class Position {

    protected RuntimeValue xAxis;
    protected RuntimeValue yAxis;
    protected Grid grd;

    public Position(int x, int y, Grid g){
        xAxis = new RunIntVal(x);
        yAxis = new RunIntVal(y);
        grd = g;
    }

    public void assignGrid(Grid g){
        grd = g;
    }

    public RuntimeValue getX(){
        return xAxis;
    }

    public RuntimeValue getY(){
        return yAxis;
    }

    public RuntimeValue notOut(RuntimeValue rv, String d){
        RuntimeValue tmpBool = rv.evalGreaterEqual(new RunIntVal(0));

        if(tmpBool.getBoolVal()){
            if(d.equals("x")){
                tmpBool = rv.evalLessEqual(grd.getX());
            }
            if(d.equals("y")){
                tmpBool = rv.evalLessEqual(grd.getY());
            }
        }
        return tmpBool;

    }

    public RuntimeValue north(RuntimeValue y){
        RuntimeValue temp = yAxis.evalAdd(y);
        RuntimeValue tmpBool = notOut(temp, "y");

        if(tmpBool.getBoolVal()){
            yAxis = temp;
        }

        return tmpBool;
    }

    public RuntimeValue south(RuntimeValue y){
        RuntimeValue temp = yAxis.evalSubtract(y);
        RuntimeValue tmpBool = notOut(temp, "y");

        if(tmpBool.getBoolVal()){
            yAxis = temp;
        }
        return tmpBool;
    }

    public RuntimeValue east(RuntimeValue x){
        RuntimeValue temp = xAxis.evalAdd(x);
        RuntimeValue tmpBool = notOut(temp, "x");

        if(tmpBool.getBoolVal()){
            xAxis = temp;
        }
        return tmpBool;
    }

    public RuntimeValue west(RuntimeValue x){
        RuntimeValue temp = xAxis.evalSubtract(x);
        RuntimeValue tmpBool = notOut(temp, "x");

        if(tmpBool.getBoolVal()){
            xAxis = temp;
        }
        return tmpBool;
    }

    public String toString(){
        return "(" + xAxis.toString() + ", " + yAxis.toString() + ")";
    }

    public String errorMsg(){
        return "(" + xAxis.toString() + ", " + yAxis.toString() + ")" + " in a grid with " + grd.toString();
    }
}
