MANDATOR EXERCISE 1 - INF 3110
==============================
_Odin Birkeflet - odinbi_
---

# Designfile for Robol

    Implemented in Java
        -Compiled and run with:
            java version "1.8.0_161"
            Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
        -State of delivery:
            Working with implemented tests


### Main method in:

    Oblig1.java


### Compile and run code:

    Compile:
    > javac Oblig1.java

    Run:
    > java Oblig1 [args]
        [args]: 1|2|3|4|all <ASTon>
            <ASTon> - optional argument that will print the AST
            without interpreting it.

## Class Hierarchy:

    <Oblig1>

    <Robol>
        <Program>
            <Robot>
        <Statement>
            <Loop>
            <Assignment>
            <Move>
            <Stop>
    <Expression>
        <AritExpr>
        <BoolExp>
        <Number>
        <Identifier>
    <RuntimeValue>
        <RunIntVal>
        <RunBoolVal>
    <VarDecl>
    <Direction>
    <Start>
    <Grid>
    <Position>
    <AritOpr>
    <BoolOpr>
    <AssignmentOpr>


## The Interpreter

The main idea behind the interpreter is to let the sub-class(es) and the contained
objects do the work, i.e. the Program class calls interpret on the robot when
itself receives an interpret call. For classes such as Robot that have lists of
uninterpreted objects the order of the interpretation is important. Robot should
first interpret the Start object so that it retrieves the Position object, which
should be considered a runtime variable as Position only exists during runtime
and is mutable. After retrieving the Position the Robot should interpret all the
statements it contains sequentially. Like Program the Robot will call interpret
on contained objects to resolve their interpretation.

Each type of statement (Loop, Assignment, Move and Stop) have their own
implementation of the interpret method to correspond with the functionality they
should hold. A loop should loop through a set of statements until the exit
condition is met. To resolve the contained statement and exit condition Loop
like Robot and Program have to rely on the contained objects to return their
interpretation. The only statement class that does not rely on calling interpret
on a contained object is the Stop class, which itself can be viewed as a return/
end statement of sorts, that indicates the end of the Robot execution, when
reached the Robot will stop interpreting statements and return after printing
the current state.

The interpret calls will go through statements to the expression classes where
in turn cases like the Arithmetic and Boolean expressions will rely on sub
expressions to return their own interpretation. These nested calls will finally
resolve in a Number expression which can be interpreted as a number literal and
will upon interpretation return a RuntimeValue of itself.

The RuntimeValue objects are the real workers of the model as both the Boolean
and the Arithmetic expression class rely on the RuntimeValue to return an
evaluation of the given expression. In other words, when an AritExpr wants to
add the left expression with the right expression, it has to first check what
the operator is, then it asks the right and left to return an interpretation of
themselves, which will resolve in a RuntimeValue, then AritExpr will determine
what evaluation method to call on the RuntimeValues depending on the operator.
In the case of addition, AritExpr will have the RuntimeValues preform the
addition and not preform the addition itself.

As mentioned above Position should be considered a Runtime value of sorts,
not a sub-type of RuntimeValue but it behaves similar. It only comes into
existence during runtime, it also takes hand of doing the calculation for other
classes (Move).
