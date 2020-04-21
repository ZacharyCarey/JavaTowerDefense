package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;

import static helpers.Artist.*;

import java.util.ArrayList;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private int index;
	private WaveManager waveManager;
	private ArrayList<TowerCannon> towerList;
	private boolean leftMouseButtonDown;
	
	
	public Player(TileGrid grid, WaveManager waveManager){
		this.grid = grid;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<TowerCannon>();
		this.leftMouseButtonDown = false;
	}
	
	public void update(){
		for(TowerCannon t : towerList){
			t.update();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemies());
		}
		
		
		//Handle mouse input
		if(Mouse.isButtonDown(0) && !leftMouseButtonDown){
			towerList.add(new TowerCannon(LoadTexture("cannonBase"), grid.getTile((int) Math.floor(Mouse.getX() / 64), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/ 64)), 10, 1000, waveManager.getCurrentWave().getEnemies()));
			//SetTile();
		}
		
		leftMouseButtonDown = Mouse.isButtonDown(0);
		
		//Handle Keyboard Input
		while(Keyboard.next()){
			if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
				Clock.ChangeMultiplier(0.2f);
			}
			if(Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()){
				Clock.ChangeMultiplier(-0.2f);
			}
			if(Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()){
				
			}
		}
	}
}
