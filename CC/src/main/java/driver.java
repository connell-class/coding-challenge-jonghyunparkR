import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.dao.GroceryRepo;
import com.project.pojo.GroceryList;

public class driver {
	
	private static ApplicationContext ac = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static GroceryRepo gr = ac.getBean(GroceryRepo.class);
	
	public static void main(String[] args) {
		insertGL();
	}
	
	public static void insertGL() {
//		GroceryList gl1 = new GroceryList(1,"egg");
		GroceryList gl2 = new GroceryList(2,"Laptop");
		GroceryList gl3 = new GroceryList(3,"Pillow");
//		gr.insertGL(gl1);
		gr.insertGL(gl2);
		gr.insertGL(gl3);
	}
}
