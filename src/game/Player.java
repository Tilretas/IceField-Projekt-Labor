package game;

import java.util.Scanner;

public class Player

{
	/**
	 * A j�t�koshoz tartoz� piece
	 */
	private Piece piece;
	
	/**
	 * A j�t�koshoz tartoz� sz�n
	 */
	private Colour colour;

	/**
	 * A Player oszt�ly konstruktora, inicializ�lja a colour attrib�tumot
	 * 
	 * @param c A Player sz�ne
	 */
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
	
	/**
	 * A param�terk�nt kapott mez�re l�pteti a piece-t
	 * 
	 * @param t A mez�, ahova l�pni akarunk
	 */
	public void move(Tile t)
	{
		getPiece().moved(t);
	}
	
	/**
	 * A felhaszn�l�i input bek�r�s��rt �s v�grehajt�s��rt felel
	 */
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
				System.out.println("\nNext player is: " + colour + ", standing on row: " + (Game.getInstance().getBoard().getTiles().indexOf(piece.getTile()) / 5 + 1) + " and col: " + (Game.getInstance().getBoard().getTiles().indexOf(piece.getTile()) % 5 + 1) + ", with " + piece.getActionPoints() +" action points.");
				System.out.println("What do you want to do?\\n 1: Move | 2: Dig | 3: Ability | 4: Use Item | 5: Pick up Item\n");
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
	
	/**
	 * A felhaszn�l� �ltal megadott mez�re l�pteti a piece-t, ha az szomsz�dos a jelenlegi mez�j�vel
	 */
	private void move() 
	{
		System.out.println("Where do you want to move? (1: up | 2: right | 3: down | 4: left) ");
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		if(idx < 1 || idx > 4) 
		{			
			System.out.println("There are only four directions...");
			return;
		}
		while(piece.getTile().getNeighbor(Direction.values()[idx-1]) == null)
		{
			System.out.println("There is no tile in that direction! Try again...");
			idx = sc.nextInt();
		}
		piece.moved(piece.getTile().getNeighbor(Direction.values()[idx-1]));
	}
	
	/**
	 * 1 h�mennyis�get �s a piece jelenlegi mez�j�n
	 */
	private void dig() 
	{
		piece.dig();
	}
	
	/**
	 * A piece haszn�lja a k�pess�g�t
	 */
	private void useAbility()
	{
		piece.ability();
	}
	
	/**
	 * Mekk�rd�zi a felhaszn�l�t�l, hogy melyik t�rgyat akarja haszn�lni, majd haszn�lja
	 */
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
	
	/**
	 * Felvesz egy t�rgyat
	 */
	private void pickUpItem()
	{
		if (piece.getTile().getItem() == null)
			System.out.println("There is no item to pick up!");
		else
			piece.pickUp();
	}
}
