package data;

import static helpers.Artist.LoadTexture;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	public static final int TILE_SIZE = 64;

	public Game(int[][] map){
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(LoadTexture("UFO"), grid.getTile(10, 8), grid, 64, 64, 70, 25), 2, 2);
		player = new Player(grid, waveManager);
		
		
	}
	
	public void update(){
		grid.Draw();
		waveManager.update();
		player.update();
	}
}
