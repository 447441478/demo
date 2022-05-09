package extend;

public class Child extends Parent {
    private static final String SIMPLE_NAME = Child.class.getSimpleName()+":";

    @Override
    public void cover(){
        System.out.println(SIMPLE_NAME+"cover");
    }
}
