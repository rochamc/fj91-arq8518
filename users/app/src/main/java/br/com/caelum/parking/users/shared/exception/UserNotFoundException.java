package br.com.caelum.parking.users.shared.exception;

public final class UserNotFoundException extends IllegalArgumentException {
	
	private static final long serialVersionUID = -2146089306671128540L;

	public UserNotFoundException(Long userId) {
        super(String.format("Could not find user with id %s", userId));
    }
}