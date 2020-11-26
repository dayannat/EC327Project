public class App {

    /*Current functions:
    public void restart()
    public void retrieveData()
    public void saveData()
    */

    public static void main(String[] args) throws Exception {

        /*Eventually, a loading data system will have to be made.*/
        Player_Profile Daniel = new Player_Profile("Daniel");
        /*But for now I can make a Player_Profile for testing.*/

        /*test code below*/
        Daniel.newClass("Calculus");
        System.out.println(Daniel.getByName("Calculus").getName());
    }

    /*This function resets the points var to 0 and removes all classes:
    A complete reset*/
    public void restart()
    {
        /*Code*/
    }

    public void saveData()
    {
        /*Save all classes array into an XML file*/
    }

    public void loadData()
    {
        /*Recovers all data from previous time the program was opened*/
    }
}
