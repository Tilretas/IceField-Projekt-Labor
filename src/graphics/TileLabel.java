package graphics;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import game.Ice;
import game.Tile;

/**
 * 1 mezõ kinézetét tárolja
 * 
 *
 */
public class TileLabel extends JLabel
{
	private TileGraphics tileIcon;
	private Tile tile;
	
	public void Draw(Tile t) { 
		tile = t; 
		Refresh();
	}
	
	public void Refresh()
	{
		int i = 0;
		i += tile.getType() * 100;
		if (tile.getBear())
			i += 10;
		if(tile.getShelter() != null) {
			if(tile.getShelter().defend()) {
				i += 1;
			}
			else i += 2;
		}
		
		switch (i) {
		case 100:
			tileIcon = TileGraphics.Ice;
			break;
			
		case 101:
			tileIcon = TileGraphics.IceIgloo;
			break;
			
		case 102:
			tileIcon = TileGraphics.IceTent;
			break;

		case 110:
			tileIcon = TileGraphics.IceBear;
			break;

		case 111:
			tileIcon = TileGraphics.IceBearIgloo;
			break;

		case 112:
			tileIcon = TileGraphics.IceBearTent;
			break;
			
		case 200:
			tileIcon = TileGraphics.Item;
			break;
			
		case 201:
			tileIcon = TileGraphics.ItemIgloo;
			break;
			
		case 202:
			tileIcon = TileGraphics.ItemTent;
			break;

		case 210:
			tileIcon = TileGraphics.ItemBear;
			break;

		case 211:
			tileIcon = TileGraphics.ItemBearIgloo;
			break;

		case 212:
			tileIcon = TileGraphics.ItemBearTent;
			break;

		case 300:
			tileIcon = TileGraphics.Hole;
			break;
			
		case 310:
			tileIcon = TileGraphics.HoleBear;
			break;

		default:
			break;
		}
		
		setIcon(new ImageIcon(tileIcon + "png")); // 50 x 50
	}
}
