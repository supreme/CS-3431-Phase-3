import org.cs3431.Query;
import org.cs3431.SQLConnector;

/**
 * @author Stephen Andrews
 * @since 10/4/16
 */
public class p3 {

    /**
     * Length of args array when user enters nothing but username and password.
     */
    private static final int NO_ARGS = 2;
    
    /**
     * Start the program.
     * @param args Username and password for database connection.
     */
    public static void main(String[] args) {
        String[] cArgs = {"sandrews", "SANDREWS", "1"};
        String username = cArgs[0];
        String password = cArgs[1];

        //No additional arguments for the menu
        if (cArgs.length == NO_ARGS) {
            System.out.println("1 - Report Health Provider Information");
            System.out.println("2 - Report Health Service Information");
            System.out.println("3 - Report Path Information");
            System.out.println("4 - Update Health Service Information");
            return;
        }

        //Open connection
        SQLConnector connector = new SQLConnector(username, password);
        connector.openConnection();
        Query query = new Query(connector);

        //Switch based on user input
        int menuOption = Integer.valueOf(cArgs[2]);
        switch (menuOption) {
            case 1:
                query.reportProviderInfo(71);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println(menuOption + " - Not a valid menu choice!");
                return;
        }
    }

}
