import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        NumberDisplay numberDisplay = new NumberDisplay();

        InputString input = new InputString();
        System.out.println();
        System.out.println("\t\t---------Stock Management---------\t\t");
        numberDisplay.displayProductName();
        System.out.println();
        System.out.println("\t\t\t---------Menu---------\t\t");
        System.out.println();

        System.out.println("\t N. Next Page \t P. Previous Page\t F. First page\t L. Last page\t ");
        System.out.println();
        System.out.println("W) Write \t R) Read\t Up) Update\t D) Delete\t S) Search (name)\t Se) Set rows ");
        System.out.println();
        System.out.println("Sa) Save \t Un) Unsave\t Ba) Backup\t Re) Restore ");
        System.out.println();
        System.out.println("\t\t----------------------------------------");
        System.out.println();



//        main program

        while(true){
//        regex validation
            input.inputType();
            if(input.output.equalsIgnoreCase("n")){
                NextPage.nextPage();


            }
            else if(input.output.equalsIgnoreCase("p")){

                break;

            }
            else if(input.output.equalsIgnoreCase("f")){

                break;

            }
            else if(input.output.equalsIgnoreCase("l")){

                break;

            }
            else if(input.output.equalsIgnoreCase("w")){

                break;
            }
            else if(input.output.equalsIgnoreCase("r")){

                break;
            }
            else if(input.output.equalsIgnoreCase("up")){

                break;
            }
            else if(input.output.equalsIgnoreCase("d")){

                break;
            }
            else if(input.output.equalsIgnoreCase("s")){

                break;
            }
            else if(input.output.equalsIgnoreCase("se")){

                break;
            }
            else if(input.output.equalsIgnoreCase("sa")){

                break;
            }
            else if(input.output.equalsIgnoreCase("un")){

                break;
            }
            else if(input.output.equalsIgnoreCase("ba")){

                break;
            }
            else if(input.output.equalsIgnoreCase("re")){

                break;
            }
            else{
                System.out.println(Colors.red+"invalid type input, please try again " + Colors.reset);
            }

        }

    }
}