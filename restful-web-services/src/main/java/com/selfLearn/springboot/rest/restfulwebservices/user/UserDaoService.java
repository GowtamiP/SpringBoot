package com.selfLearn.springboot.rest.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	//JPA/Hibernate > Database
	//UserDaoService > Static List
	private static List<User> users = new ArrayList<>();
	private static int countUsers = 0;
	
	static {
		users.add(new User(++countUsers, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++countUsers, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++countUsers, "Jim", LocalDate.now().minusYears(20)));
	}
	public List<User> findAll(){
		return users;
	}
	public User findUser(int id) {
		// TODO Auto-generated method stub
		/*for(User userBean : users) {
			if(userBean.getId() == id)
				return userBean;
		}*/
		//functional programming using streams and lambda expression
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public User addUser(User user) {
		user.setId(++countUsers);
		users.add(user);
		return user;
		
	}
	public void deleteUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		// TODO Auto-generated method stub
	}

}
