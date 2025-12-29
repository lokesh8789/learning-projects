package com.jpa;

import java.util.List;
//import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entities.User;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
		UserRepository bean = context.getBean(UserRepository.class);
		/*create 
		User user=new User();
		user.setName("lokesh");
		user.setCity("dhanbad");
		user.setStatus("good");
		//save single object
		User r1 = bean.save(user);
		System.out.println(r1);
		
		
		User user2=new User();
		user2.setName("lokesh");
		user2.setCity("dhanbad");
		user2.setStatus("good");
		
		User user3=new User();
		user3.setName("lokesh");
		user3.setCity("dhanbad");
		user3.setStatus("good");

		List<User> list=List.of(user2,user3);
		//save multiple object
		Iterable<User> all = bean.saveAll(list);
		all.forEach(user->System.out.println(user));
		*/
		/* update and get
		Optional<User> res = bean.findById(6);
		User user = res.get();
		user.setName("ankit");
		user.setCity("bhagalpur");
		User save = bean.save(user);
		System.out.println(save);
	
		Iterable<User> itr = bean.findAll();
		itr.forEach(ur->System.out.println(ur));
		*/
		/*delete
		bean.deleteById(7);
		System.out.println("deleted");
		*/
		List<User> list = bean.findByName("lokesh");
		list.forEach(e->System.out.println(e));
		
		List<User> l=bean.findByNameAndCity("ankit","bhagalpur");
		l.forEach(e->System.out.println(e));
		
		List<User> list2 = bean.findByNameContaining("k");
		list2.forEach(e->System.out.println(e));
		
		List<User> allUser = bean.getAllUser();
		allUser.forEach(e->System.out.println(e));
		
		List<User> userByName = bean.getUserByName("lokesh");
		userByName.forEach(e->System.out.println(e));
		
		bean.getUsers().forEach(e->System.out.println(e));
	}

}
