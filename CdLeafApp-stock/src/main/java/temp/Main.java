package temp;

import com.cdleaf.controller.HelloController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        HelloController controller = ctx.getBean(HelloController.class);


        System.out.println(controller);



    }
}
