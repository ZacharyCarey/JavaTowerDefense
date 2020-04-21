package data;

import java.util.ArrayList;

import static helpers.Clock.*;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private int enemiesPerWave;
	private boolean waveCompleted;
	
	
	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave){
		this.spawnTime = spawnTime;
		this.enemyType = enemyType;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastSpawn = 0;
		this.enemyList = new ArrayList<Enemy>();
		this.waveCompleted = false;
		
		Spawn();
	}
	
	public void update(){
		boolean allEnemiesDead = true;
		if(enemyList.size() < enemiesPerWave){
			timeSinceLastSpawn += Delta();
			if(timeSinceLastSpawn > spawnTime){
				Spawn();
				timeSinceLastSpawn = 0;
			}
		}
		for(Enemy e: enemyList){
			if(e.isAlive()){
				allEnemiesDead = false;
				e.update();
				e.Draw();
			}
		}
		if(allEnemiesDead){
			waveCompleted = true;
		}
	}
	
	private void Spawn(){
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(), 64, 64, enemyType.getSpeed(), enemyType.getHealth()));
	}
	
	public boolean isCompleted(){
		return waveCompleted;
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemyList;
	}
}
