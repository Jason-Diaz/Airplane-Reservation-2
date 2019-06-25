package proj6;
/**
 * <p>Title: proj6 - Seat Class<p>
 * 
 * <p>Description: This class creates seats, which can have a number, a class (first, or coach),
 *  and whether the seat is empty or occupied.
 * @author Jason Diaz
 *
 */
public class Seat {

	int type;
	boolean occupated;
	int seatNum=0;

	/**
	 * Parameterized Seat constructor -
	 * accepts values for the seat number, the type of seat, and sets the seat to empty.
	 * @param classNum, passes what class the seat is.
	 * @param numSeat, passes what seat number the seat is.
	 */
	public Seat(int classNum,int numSeat)
	{
		type = classNum;
		occupated = false;
		seatNum= numSeat;
	}

	/**
	 * getSeatNum method -
	 * returns the individual seat number of a seat.
	 * @return int, which is the seat number.
	 */
	public int getSeatNum()
	{
		return seatNum;
	}

	/**
	 * getTypeSeat method -
	 * returns the type of seat(first or coach) on the seat that it is called on.
	 * @return int, 1 representing first class, 2 representing coach class.
	 */
	public int getTypeSeat()
	{
		return type;
	}

	/**
	 * occupation method -
	 * returns if the seat is empty or occupied.
	 * @return boolean, true if the seat is occupied, false if the seat is empty.
	 */
	public boolean occupation()
	{
		return occupated;
	}

	/**
	 * reserveSeat method -
	 * changes the status of the seat to occupied.
	 */
	public void reserveSeat()
	{
		occupated = true;
	}

	/**
	 * cancelRes method -
	 * changes the status of the seat to empty.
	 */
	public void cancelRes()
	{
		occupated = false;
	}

	/**
	 * toStiring method -
	 * returns a reference to a string containing the state of the seat.
	 * @return String, which contains the seat number, a comma, the class, comma,
	 * and if it's occupation.
	 */
	public String toString()
	{
		String str=new String();
		String whichClass=new String();
		String taken=new String();

		if(occupated == false)
		{
			taken = "Empty";
		}
		else
		{
			taken = "Occupied";
		}
		if(type == 1)
		{
			whichClass = "First class";
		}
		else
		{
			whichClass = "Coach class";
		}
		str = seatNum + ", " + whichClass + ", " + taken;

		return str;
	}
}
