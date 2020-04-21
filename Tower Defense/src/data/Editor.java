package data;

import static helpers.Artist.HEIGHT;
import static helpers.Artist.LoadTexture;
import static helpers.Leveler.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;

public class Editor {

	private TileGrid grid;
	private TileType[] types;
	private int index;

	public Editor() {
		this.grid = new TileGrid(TileType.Grass);
		//this.grid = loadMap("mapTest");
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.index = 0;
	}

	public void update() {

		// Handle mouse input
		if (Mouse.isButtonDown(0)) {
			SetTile();
		}

		// Handle Keyboard Input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				MoveIndex(1);
			}else if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				MoveIndex(-1);
			}
			
			if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				saveMap("mapTest", grid);
			}else if (Keyboard.getEventKey() == Keyboard.KEY_L && Keyboard.getEventKeyState()) {
				//loadMap("mapTest");
				grid = loadMap("mapTest");
			}
		}
		
		grid.Draw();
	}

	private void SetTile() {
		grid.setTile((int) Math.floor(Mouse.getX() / 64), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64), types[index]);
	}
	
	private void MoveIndex(int i){
		index += i;
		if(index > types.length - 1)
			index = 0;
		if(index < 0)
			index = types.length - 1;
	}
}
