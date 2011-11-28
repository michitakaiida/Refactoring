import java.util.Enumeration;
import java.util.Vector;


public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	//���N�K�L
	public Customer(String name){
		_name = name;
	}
	
	public void addRental(Rental arg){
		_rentals.addElement(arg);
	}
	public String getName(){
		return _name;
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
	
			//�����^���|�C���g�����Z
			frequentRenterPoints ++;
			//�V���2���ȏォ��؂肽�ꍇ�̓{�[�i�X�|�C���g
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)frequentRenterPoints ++;
			
			//���݂̑��o���Ɋւ��鐔�l�̕\��1
			result += "\t" + each.getMovie().getTitle() + "\t" +
					String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
			
		}
		
		//�t�b�^�ǉ�
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + 
				" frequent renter points";
		return result;
	}
	
}
