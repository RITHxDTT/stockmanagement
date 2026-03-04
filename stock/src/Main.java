import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        ProductList pr =  new ProductList();

        Pagination p1 = new Pagination();


        System.out.println(Colors.cyan+"\t\t---------Stock Management---------\t\t"+Colors.reset);
        Pagination.loadProducts();


//        main program
        while(true){

            InputString input = new InputString();
            System.out.println();

            System.out.println();
            System.out.println(Colors.purple+"\t\t\t---------Menu---------\t\t"+Colors.reset);
            System.out.println();

            System.out.println(Colors.blue+"\t N. Next Page \t P. Previous Page\t F. First page\t L. Last page\t "+Colors.reset);
            System.out.println();
            System.out.println(Colors.green+"W) Write \t R) Read\t Up) Update\t D) Delete\t S) Search (name)\t Se) Set rows "+Colors.reset);
            System.out.println();
            System.out.println(Colors.cyan+"Sa) Save \t Un) Unsave\t Ba) Backup\t Re) Restore "+Colors.reset);
            System.out.println();
            System.out.println("\t\t----------------------------------------");
            System.out.println();


//        regex validation
            input.inputType();
            if(input.output.equalsIgnoreCase("n")){
                Pagination.nextPage();


            }
            else if(input.output.equalsIgnoreCase("p")){
                Pagination.previousPage();


            }
            else if(input.output.equalsIgnoreCase("f")){
                Pagination.firstPage();


            }
            else if(input.output.equalsIgnoreCase("l")){
                Pagination.lastPage();

            }
            else if(input.output.equalsIgnoreCase("w")){
                pr.addProduct();
                Pagination.loadProducts();

            }
            else if(input.output.equalsIgnoreCase("r")){
                ReadById r = new ReadById();
                r.displayProductById();

            }
            else if(input.output.equalsIgnoreCase("up")){
                System.out.println();
                pr.updateProduct();
                Pagination.loadProducts();

            }
            else if(input.output.equalsIgnoreCase("d")){
                pr.deleteProduct();
                Pagination.loadProducts();
            }
            else if(input.output.equalsIgnoreCase("s")){
                SearchByName.search();
                Pagination.loadProducts();

            }
            else if(input.output.equalsIgnoreCase("se")){
                Pagination se = new Pagination();
                while (true) {
                    System.out.print(Colors.blue + "Enter number of rows to display: " + Colors.reset);
                    String rowNumber = sc.nextLine();
                    try {
                        int row = Integer.parseInt(rowNumber);
                        se.setRow(row);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(Colors.red + "Please Enter Number Only :)." + Colors.reset);
                    }
                }

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
