package in.codekamp.reviewrating;

/**
 * Created by cerebro on 19/09/17.
 */

public class Dog {

    private static Dog singleton;

    private Dog() {

    }


    public static Dog getDog() {
        if(singleton == null) {
            synchronized (Dog.class) {
                if(singleton == null) {
                    singleton = new Dog();
                }
            }
        }

        return singleton;
    }
}
