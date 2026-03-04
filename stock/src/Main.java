

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);



//        main program

        while(true){
            NumberDisplay numberDisplay = new NumberDisplay();

            InputString input = new InputString();
            System.out.println();
            System.out.println(Colors.purple + "\t\t---------Stock Management---------\t\t"+ Colors.reset);
            Pagination.displayProductName();
            System.out.println();
            System.out.println(Colors.cyan+"\t\t\t---------Menu---------\t\t"+Colors.reset);
            System.out.println();

            System.out.println(Colors.green+ "\t N. Next Page \t P. Previous Page\t F. First page\t L. Last page\t "+Colors.reset);
            System.out.println();
            System.out.println(Colors.blue+"W) Write \t R) Read\t Up) Update\t D) Delete\t S) Search (name)\t Se) Set rows "+Colors.reset);
            System.out.println();
            System.out.println(Colors.yellow+"Sa) Save \t Un) Unsave\t Ba) Backup\t Re) Restore "+Colors.reset);
            System.out.println();
            System.out.println("\t\t----------------------------------------");
            System.out.println();

//        regex validation
            input.inputType();
            if(input.output.equalsIgnoreCase("n")){
                Pagination.nextPage();


            }
            else if(input.output.equalsIgnoreCase("p")){



            }
            else if(input.output.equalsIgnoreCase("f")){
                Pagination.firstPage();


            }
            else if(input.output.equalsIgnoreCase("l")){
                Pagination.lastPage();

            }
            else if(input.output.equalsIgnoreCase("w")){

                break;
            }
            else if(input.output.equalsIgnoreCase("r")){
                ReadProductByid pr = new ReadProductByid();
                pr.displayProductById();

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
