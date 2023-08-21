package luke;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import luke.entities.User;
import luke.payload.NewUserPayload;
import luke.repositories.UserRepository;
import luke.service.UsersService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	UsersService userService;
	
	 @Autowired
	    UserRepository utenteRepo;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));
		
		 List<User> utentiDb = utenteRepo.findAll();
	        if (utentiDb.isEmpty()) {

		for (int i = 0; i < 10; i++) {
			String username = faker.funnyName().name();
			String name = faker.name().firstName();
			String surname = faker.name().lastName();
			String email = faker.internet().emailAddress();
			String password = "1234";
			NewUserPayload user = new NewUserPayload(username, name, surname, email, password);
			userService.save(user);
			
		}
		}

	}

}
