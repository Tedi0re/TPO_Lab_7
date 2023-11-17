public class Calculator {
    public static float Sum(float x, float y) throws Exception {
        if(x + y > Float.MAX_VALUE || x + y < -Float.MAX_VALUE)
            throw new Exception("Float.VALUE");
        return x + y;
    }

    public static float Sub(float x, float y) throws Exception {
        if(x - y > Float.MAX_VALUE || x - y < -Float.MAX_VALUE)
            throw new Exception("Float.VALUE");
        return x - y;
    }

    public static float Mul(float x, float y) throws Exception{
        if(x * y > Float.MAX_VALUE || x * y < -Float.MAX_VALUE)
            throw new Exception("Float.VALUE");
        return  x * y;
    }

    public static float Div(float x, float y) throws Exception{
        if(y == 0)
            throw new Exception("y == 0");
        if(x / y > Float.MAX_VALUE || x / y < -Float.MAX_VALUE)
            throw new Exception("Float.VALUE");
        return x / y;
    }
}
