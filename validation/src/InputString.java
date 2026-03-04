import java.util.Scanner;
import java.util.regex.Pattern;

public class InputString {
    Scanner sc = new Scanner(System.in);
    public String regex = "[a-zA-Z]+$";
    public String output ;

    public void inputType(){
        String inputType;
        while(true){
            System.out.print(Colors.purple+"==> Chose an option: "+Colors.reset);
            inputType = sc.nextLine();
            System.out.println();
            if(inputType.matches(regex)){
                this.output = inputType;
                break;
            }
            else{
                System.out.println(Colors.red + "Please follow the command instruction" + Colors.reset);
            }
        }
    }

    public boolean idValidate(String id){
        return Pattern.matches("^[0-9]+$",id);
    }

}
