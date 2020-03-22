package marsRover;

import java.util.ArrayList;

public class MarsRover {

	public MarsRover() {
		// TODO Auto-generated constructor stub
	}

	public static void findFinalPosition(ArrayList<Integer> list) {

		boolean command = true;
		int direction = 1;
//		int distanceX = 0;
//		int distanceY = 0;

		for (int i = 0; i < list.size(); i++) {
			int integer = list.get(i);

			if (command && integer == 1) {
				i++;
				switch (direction) {

				case 1:
//					distanceX += list.get(i);
					break;

				case 2:
//					distanceY += list.get(i);
					break;

				case 3:
//					distanceX -= list.get(i);
					break;

				case 4:
//					distanceY -= list.get(i);
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + direction);
				}
			} else if (command && integer == 2) {
				direction--;
				if (direction == 0) {
					direction = 4;
				}
			} else if (command && integer == 2) {
				direction++;
				if (direction == 5) {
					direction = 1;
				}
			} 
		}
	}

}
