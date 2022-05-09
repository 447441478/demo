package extend;

public class Parent {
    private static final String SIMPLE_NAME = Parent.class.getSimpleName() + ":";
    public Parent() {
        cover();
        noCover();
    }

    public void cover(){
        System.out.println(SIMPLE_NAME+"cover");
    }

    public void noCover(){
        System.out.println(SIMPLE_NAME+"noCover");
    }
}
