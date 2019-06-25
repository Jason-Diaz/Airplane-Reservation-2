package proj6;
/**
 * <p>Title: proj6 - Airplane Class<p>
 * 
 * <p>Description: The Airplane Class creates an array of Seat objects. It refers to the seat class
 * and creates methods to provide certain behaviors.
 * @author Jason Diaz
 *
 */
public class Airplane {

	Seat[] airplane = new Seat[10];

	/**
	 * Default Airplane constructor -
	 * creates an airplane with 10 seats. The first 4 seats are first class,
	 * the last 6 seats are coach class.
	 */
	public Airplane()
	{
		for(int i = 0; i<10; i++)

			if(i<4)
				airplane[i] = new Seat(1,(i+1));
			else
				airplane[i] = new Seat(2,(i+1));
	}

	/**
	 * assign method -
	 * Assign's the next available first or coach class seat.
	 * @param classNum, passes which class the passenger wants to fly in, 1 for first, 2 for coach.
	 * @return int, which contains the passengers seat number,
	 * if there is no seats available the method returns -1.
	 */
	public int assign(int classNum)
	{
		for(int i = 0; i<airplane.length; i++) 
		{
			if(airplane[i].getTypeSeat() == classNum && airplane[i].occupated == false)
			{
				airplane[i].reserveSeat();
				int fly = airplane[i].getSeatNum();
				i = airplane.length;
				return fly;
			}
		}
		return -1;
	}

	/**
	 * cancel method -
	 * cancel method cancels the seat that the person reserved.
	 * @param whichSeat, accepts the seat number the will be set back to empty.
	 * @return boolean, true represents that the process has been done,
	 * false represents that the seat was never reserved.
	 */
	public boolean cancel(int whichSeat)
	{
		if(airplane[whichSeat-1].occupated == true)
		{
			airplane[whichSeat-1].cancelRes();
			return true;
		}
		return false;
	}

	/**
	 * toString method -
	 * returns a reference to a string containing the state of the Airplane.
	 * @return String, refers back to the tostring in the seat class and is called on the entire airplane.
	 */
	public String toString()
	{
		String str = new String();
		for(int i =0; i<airplane.length; i++)
			str = str + airplane[i].toString() + "\n";
		return str;

	}
}
