package Test;
import javax.swing.JOptionPane;


public class drawZwin {
	public static void main(String[] args) {
	int inputk = Integer.parseInt(JOptionPane.showInputDialog(
			"Give me a number ",4));
	String first="";
	
	if(inputk<4 || inputk>30){
		JOptionPane.showMessageDialog(null,"wrong number.Correct numbers 4-30");
		System.exit(1);}

	else{
		while (inputk >=4  && inputk <= 30){
	
	for (int x = 0; x < inputk; x++) {
		first+="*";
	}
	
	first+="\n";
	for (int x = inputk-3; x >= 0; x--) {
		
		for (int y = x; y >= 0; y--) {
	    	first+=" ";}
		
		first+="*\n";}
	
	
	
	for (int x = 0; x < inputk; x++) {
		first+="*";;
	}
	JOptionPane.showMessageDialog (null,first,"Z letter",JOptionPane.INFORMATION_MESSAGE);
	int inputk1 = Integer.parseInt(JOptionPane.showInputDialog(
			"Give me a number ",4));
	inputk=inputk1;
	first="";
if(inputk<4 || inputk>30){
	JOptionPane.showMessageDialog(null,"wrong number");
	System.exit(1);
}
	 }

		
	}}}
