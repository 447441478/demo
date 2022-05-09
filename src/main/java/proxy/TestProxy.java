package proxy;

import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    //-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
    public static void main(String[] args) {
        System.out.println();
        final B b = new B();
        A proxy = (A)Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{A.class}, new InvocationHandler() {
            private Object src = b;

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });
        proxy.aaa();
    }


    interface  A{
        void aaa();
    }

    static  class B implements A{

        @Override
        public void aaa() {
            System.out.println("bbbbbbbbbbbb");
        }
    }
}
