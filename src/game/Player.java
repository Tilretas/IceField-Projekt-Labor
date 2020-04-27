package game;

import java.util.Scanner;

public class Player

{
	private Piece piece;
	private Colour colour;

	//public Player(Colour c) { colour = c; } nem tom hogy kell az enummal dolgozni és nem tuidom megnézni mert upc
	
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
		Scanner sc = new Scanner(System.in);
		int cmd;
		boolean wrong = true;
		
		while(wrong) {
			wrong = false;
			System.out.println("What do you want to do?\n 1: Move | 2: Dig | 3: Ability | 4: Use Item | 5: Pick up Item\n");
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
				
			default:
				wrong = true;
				System.out.println("Incorrect input!");
				break;
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
		piece.moved(Game.getInstance().getBoard().getTiles().get(idx));
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
		System.out.println("Which item do you want to use? | Item index(0-"+ piece.getInventory().size() + "): ");
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
		Tile t = piece.getTile();
		Item i = t.getItem();
		if (i == null) { System.out.println("There is no item to pick up!"); }
		t.setItem(null);
		piece.getInventory().add(t.getItem());
	}
}
