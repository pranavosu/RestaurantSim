package resource;

import env.Order;

public class FriesMachine extends Machine {

	@Override
	public
	boolean isAvailable() {
		// TODO Auto-generated method stub
		return isAvailable;
	}

	@Override
	public
	Order fulfil(Order o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public
	void setAvailable(boolean available) {
		// TODO Auto-generated method stub
		isAvailable = available;
	}

}
