package proj6;
/**
 * <p>Title: proj6 - App Class<p>
 * 
 * <p>Description: This class allows for the user to make a reservation, cancel a reservation, and display a seating chart.
 * To do so it uses the methods in the Airplane class. The user can chose a first class seat or a coach seat. If there is
 * room the user will get a seat number, if not they will get a prompt explaining there is no more room in that class.
 * When the user wants to cancel a reservation, the user must input the seat number. If it is a valid number and the seat
 * was reserved the user will be prompted that it was successful. If the user inputed invalid information the appropriate
 * error message will appear. The display a seating chart displays the entire plane, each seat number, each class type, and
 * there occupation. 
 * @author Jason Diaz
 *
 */
import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args)
	{
		Airplane airline = new Airplane();
		int choice=0;
		{
			String[] choices = {"Make a reservation", "Cancel a reservation","Display a seating chart","Quit"};
			while(choice != 3)
			{
				choice = JOptionPane.showOptionDialog(null,"Thank you for flying with Jason Airlines","Main Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
				{
					if(choice == 0)
					{
						String[] choices2 = {"First class", "Coach class"};
						int choice2 = JOptionPane.showOptionDialog(null,"Which class would you like to fly in?","Make a reservation", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices2,choices2[0]);
						int aSeat = airline.assign(choice2+1);
						{
							if(aSeat == -1)
							{
								JOptionPane.showMessageDialog(null,"Sorry this class is fully booked.","Make a reservation",JOptionPane.INFORMATION_MESSAGE);
							}					
							else
							{
								if(choice2 == 0 && (aSeat-1)<=4)
									JOptionPane.showMessageDialog(null,"Your reservation is complete." + "\nYour first class seat number is " + aSeat,"Make a reservation",JOptionPane.INFORMATION_MESSAGE);
								else
									JOptionPane.showMessageDialog(null,"You reservation is complete." + "\nYour coach class seat number is " + aSeat,"Make a reservation",JOptionPane.INFORMATION_MESSAGE);
							}

						}
					}
					if(choice == 1)
					{
						int canSeat = Integer.parseInt(JOptionPane.showInputDialog("Which seat would you like to cancel?"));

						if(canSeat<=0 || canSeat>=11)
						{
							JOptionPane.showMessageDialog(null,"Invalid seat number.","Cancel reservation",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							boolean cane = airline.cancel(canSeat);
							if(cane == false)
								JOptionPane.showMessageDialog(null,"Sorry seat number " + canSeat + " was never reserved.","Cancel reservation",JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,"Cancellation for seat number " + canSeat + " has been completed.\nSorry for the inconvenience. We hope you fly with us again.",
										"Cancel reservation",JOptionPane.INFORMATION_MESSAGE);
						}

					}
					if(choice==2)
					{
						JOptionPane.showMessageDialog(null,airline.toString(),"Seating chart",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
	}
}