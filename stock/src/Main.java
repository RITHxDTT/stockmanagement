import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        ProductList pr =  new ProductList();

        Pagination p1 = new Pagination();


        System.out.println("\t\t---------Stock Management---------\t\t");
        Pagination.loadProducts();


//        main program
        while(true){

            InputString input = new InputString();
            System.out.println();

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
                int count = 0 ;
                if(count ==1){
                    ProductList p = new ProductList();

                }
                pr.deleteProduct();
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
