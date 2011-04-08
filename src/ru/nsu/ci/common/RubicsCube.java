package ru.nsu.ci.common;

public class RubicsCube implements  RubiksCubeInterface {
    int [][][] cube =new int[3][3][6];
    int [] povorcube =new int [3];
	@Override
	public void abortStep(int step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void choice(int side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
	
		
	}

	@Override
	public void load(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnGoriz(int i, int j, int k, byte goriz) {
		
	for (int l=0;l<3;l++){//Запоминаем верхнюю строку
		povorcube[l]=cube[l][0][k];
	}
	if (goriz>0){
	for(;++)	
	}else
	
	for (--)	
		
	}

	@Override
	public void turnVert(int i, int j, int k, byte vert) {
		// TODO Auto-generated method stub
		
	}

}
