package data;

public class WaveManager {

	private float timeSinceLastWave, timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy enemyType;
	private Enemy enemyType2;
	private Wave currentWave;
	
	public WaveManager(Enemy enemyType, Enemy enemyType2, float timeBetweenEnemies, int enemiesPerWave){
		this.enemyType = enemyType;
		this.enemyType2 = enemyType2;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		
		this.currentWave = null;
		
		newWave();
	}
	
	public void update(){
		if(!currentWave.isCompleted())
			currentWave.update();
		else
			newWave();
	}
	
	private void newWave(){
		if(waveNumber > 10) {
			currentWave = new Wave(enemyType2, timeBetweenEnemies, enemiesPerWave);
		}else {
			currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave);
		}
		waveNumber++;
		System.out.println("Beginning Wave " + waveNumber);
	}
	
	public Wave getCurrentWave(){
		return currentWave;
	}
}
