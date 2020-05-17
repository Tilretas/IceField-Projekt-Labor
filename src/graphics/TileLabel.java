package graphics;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Ice;

/**
 * 1 mezõ kinézetét tárolja
 * 
 *
 */
public class TileLabel extends JLabel
{
	private TileGraphics tileIcon;
	
	public void Draw(JPanel tp, game.Tile t)
	{
		int i = 0;
		i += t.getType() * 100;
		if (t.getBear())
			i += 10;
		if(t.getShelter() != null) {
			if(t.getShelter().defend()) {
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
	}
}
