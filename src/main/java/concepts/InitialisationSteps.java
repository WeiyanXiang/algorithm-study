package concepts;/**
 * @author Weiyan Xiang on 2022/1/12
 */

public class InitialisationSteps {
    static{
        System.out.println("static block");
    }
    private static String s = "dsa";
    private String s2 = "dsadsa";
    private String s3 ;
    {
        System.out.println("Anonymous instance block");
    }

    public InitialisationSteps(){
        System.out.println("hahaha");
        s3 = "dsadas";
    }
    public static void main(String[] args) {
        InitialisationSteps test = new InitialisationSteps();
    }

}
