abstract class Statement implements Robol {
    public abstract RuntimeValue interpret(Position p);
    public abstract String getType();
    public abstract String toString();
    public abstract void ASTprint(String s);
}
