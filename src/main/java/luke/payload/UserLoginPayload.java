package luke.payload;

import lombok.Getter;

@Getter
public class UserLoginPayload {
	String email;
	String password;
}
