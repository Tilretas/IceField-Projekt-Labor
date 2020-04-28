package game;

import java.util.Scanner;

public class Player

{
	private Piece piece;
	private Colour colour;

	public Player(Colour c) { colour = c; }
	
	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() 
	{
		return piece;
	}
	
	public void move(Tile t)
	{
		getPiece().moved(t);
	}
	
	public void playerInput() 
	{
		if(Game.getInstance().stop == true)
			return;
		Scanner sc = new Scanner(System.in);
		int cmd;
		boolean wrong = true;
		piece.setActionPoints(4);
		if (piece.getInWater()) 
		{
			if (piece.getSuffocate())
				piece.die();
			else piece.setSuffocate(true);
		}
		
		while(piece.getActionPoints() > 0) 
		{
			Game.getInstance().getBoard().drawBoard();
			wrong = true;
			while(wrong) {
				wrong = false;
				System.out.println("\nNext player is: " + colour + ", standing on tile: " + Game.getInstance().getBoard().getTiles().indexOf(piece.getTile()) + ", with " + piece.getActionPoints() +" action points.\nWhat do you want to do?\n 1: Move | 2: Dig | 3: Ability | 4: Use Item | 5: Pick up Item\n");
				cmd = sc.nextInt();
				
				switch (cmd) {
				case 1:
					System.out.println("Moving...");
					move();				
					break;

				case 2:
					System.out.println("Digging...");
					dig();				
					break;
					
				case 3:
					System.out.println("Abiliting...");
					useAbility();				
					break;
					
				case 4:
					System.out.println("Iteming...");
					useItem();				
					break;
					
				case 5:
					System.out.println("Pick upping...");
					pickUpItem();				
					break;
					
				case 0:
					piece.setActionPoints(0);
					break;
					
				case -1:
					piece.setActionPoints(0);
					Game.getInstance().stop = true;
					Game.getInstance().testStart = true;
					break;
					
				default:
					wrong = true;
					System.out.println("Incorrect input!");
					break;
				}
			}
		}
	}
	
	private void move() 
	{
		System.out.println("Where do you want to move? | Tile index(0-24): ");
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		while(idx < 0 || idx > 24)
		{
			System.out.println("Incorrect tile index!");
			idx = sc.nextInt();
		}
		if(piece.getTile().isNeighbor(Game.getInstance().getBoard().getTiles().get(idx)))
			piece.moved(Game.getInstance().getBoard().getTiles().get(idx));
		else
			System.out.println("You can only move to a neighboring tile!");
	}
	
	private void dig() 
	{
		piece.dig();
	}
	
	private void useAbility()
	{
		piece.ability();
	}
	
	private void useItem()
	{
		System.out.println("Which item do you want to use? | Item index(0-"+ (piece.getInventory().size()-1) + "):\n");
		for (int i = 0; i < piece.getInventory().size(); i++)
			System.out.print(i + ": " + piece.getInventory().get(i).getName() + " | ");
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		while(idx < 0 || idx > piece.getInventory().size() - 1)
		{
			System.out.println("Incorrect item index!");
			idx = sc.nextInt();
		}
		piece.useItem(piece.getInventory().get(idx));
	}
	
	private void pickUpItem()
	{
		if (piece.getTile().getItem() == null)
			System.out.println("There is no item to pick up!");
		else
			piece.pickUp();
	}
}
