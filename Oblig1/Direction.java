public enum Direction {
    north("north"),
    south("south"),
    east("east"),
    west("west");

    String image;

    Direction(String s){
        image = s;
    }

    public String toString(){
        return image;
    }

    public static Direction getDirection(String dir){
        for (Direction d : Direction.values()){
            if(dir.equals(d.toString())) return d;
        }
        return null;
    }

    public void ASTprint(String s){
        System.out.println(s + "<Direction>");
        System.out.println(s + "  " + image);
        System.out.println(s + "</Direction>");
    }
}
