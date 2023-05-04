
public class Player {
	private int number;
	private Room currentRoom;
	private boolean toolsCollected;
	private Part lastMachinePartCollected;
	
	public Player(int num, Room startingRoom)
	{
		this.number = num;
		this.currentRoom = startingRoom;
		this.toolsCollected = false;
		this.lastMachinePartCollected = null;
	}
	/**
	 * this method gets last part collected, 
	 * Part type from Part class
	 * @return
	 */
	public Part getLMPC()
	{
		return lastMachinePartCollected;
	}
	
	/**
	 * This method shows the player where they are
	 * currently at in the game
	 * @return
	 */
	public Room getcurrentRoom()
	{
		return currentRoom;
	}
	/**
	 * This method shows player whether they
	 * have a tool. If it's true or false.
	 * @return
	 */
	public boolean hasTools()
	{
		return toolsCollected;
	}
	/** 
	 * this method displays whether player goes into
	 * a place that has no door. 
	 * @param direction
	 * @return
	 */
	public String move(Direction direction) {
        Door door = currentRoom.getDoor(direction);
        if (door == null) {
            return "No door in this direction";
        } else {
            currentRoom = door.getDestination();
            return currentRoom.printMessage();
        }
    }

	/**
	 * The collect part method is when the player 
	 * checks to see if they have the parts collected. Checks to see
	 * if parts are collected in order.
	 * @return
	 */
    public String collectPart() {
        if (!currentRoom.hasParts()) {
            return "There are no machine parts in this room";
        }
        Part part = currentRoom.getPart();
        if (lastMachinePartCollected == null && part.getNumber() != 1) {
            return "You must collect the parts in order";
        } else if (lastMachinePartCollected != null && part.getNumber() != lastMachinePartCollected.getNumber() + 1) {
            return "You must collect the parts in order";
        } else if (lastMachinePartCollected != null && part.getNumber() == lastMachinePartCollected.getNumber() + 1 && lastMachinePartCollected.isCollected()) {
            return "You have already collected this part";
        } else {
            lastMachinePartCollected = part;
            part.setCollected(true);
            return "You have successfully collected part " + part.getNumber();
        }
    }
    /**
     * This method allows player to collect tools.
     * @return
     */
    public String collectTools() {
        if (!currentRoom.hasTools()) {
            return "There are no tools in this room";
        } else if (toolsCollected) {
            return "You have already collected the tools";
        } else {
            toolsCollected = true;
            return "You have successfully collected the tools";
        }
    }
    /**
     * this method checks if task is completed
     * @return
     */
    public String build() {
        if (currentRoom.getName().equals("Workshop")) {
            if (lastMachinePartCollected == null || lastMachinePartCollected.getNumber() != 6 || !toolsCollected) {
                return "You do not have all the required parts and tools to build the machine";
            } else {
                return "Task Completed! You Win!!!!";
            }
        } else {
            return "You must be in the Workshop to build the machine";
        }
    }

}
