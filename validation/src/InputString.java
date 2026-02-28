import java.util.Scanner;

public class InputString {
    Scanner sc = new Scanner(System.in);
    public String regex = "[a-zA-Z]+$";
    public String output ;


    public void inputType(){
        String inputType;
        while(true){
            System.out.print("==> Chose an option: ");
            inputType = sc.nextLine();
            System.out.println();
            if(inputType.matches(regex)){
                this.output = inputType;
                break;
            }
            else{
                System.out.println(Colors.red + "Please folow the command instruction" + Colors.reset);
            }
        }
    }
}
