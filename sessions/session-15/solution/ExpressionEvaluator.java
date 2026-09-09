/**
 * Session 15 - Assignment 15 (coding part) reference solution:
 * A tiny expression tree evaluated with sealed types + record patterns.
 */
public class ExpressionEvaluator {

    sealed interface Expr permits Num, Add, Sub, Mul, Neg {}
    record Num(double value)          implements Expr {}
    record Add(Expr left, Expr right) implements Expr {}
    record Sub(Expr left, Expr right) implements Expr {}
    record Mul(Expr left, Expr right) implements Expr {}
    record Neg(Expr operand)          implements Expr {}

    static double eval(Expr e) {
        return switch (e) {
            case Num(double v)          -> v;
            case Add(Expr l, Expr r)    -> eval(l) + eval(r);
            case Sub(Expr l, Expr r)    -> eval(l) - eval(r);
            case Mul(Expr l, Expr r)    -> eval(l) * eval(r);
            case Neg(Expr x)            -> -eval(x);
        };  // exhaustive: Expr is sealed
    }

    static String render(Expr e) {
        return switch (e) {
            case Num(double v)       -> (v == Math.floor(v)) ? String.valueOf((long) v) : String.valueOf(v);
            case Add(Expr l, Expr r) -> "(" + render(l) + " + " + render(r) + ")";
            case Sub(Expr l, Expr r) -> "(" + render(l) + " - " + render(r) + ")";
            case Mul(Expr l, Expr r) -> "(" + render(l) + " * " + render(r) + ")";
            case Neg(Expr x)         -> "-" + render(x);
        };
    }

    public static void main(String[] args) {
        // (3 + 4) * -(2 - 5)
        Expr expr = new Mul(
            new Add(new Num(3), new Num(4)),
            new Neg(new Sub(new Num(2), new Num(5)))
        );

        System.out.println(render(expr) + " = " + eval(expr));

        Expr simple = new Add(new Num(10), new Mul(new Num(2), new Num(6)));
        System.out.println(render(simple) + " = " + eval(simple));
    }
}
