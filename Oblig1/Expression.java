abstract class Expression {
    public abstract RuntimeValue interpret(Position p);
    public abstract String getType();
    public abstract String toString();
    public abstract void ASTprint(String s);
}
