package ru.nsu.ci.common;

public class RubicsCube implements  RubiksCubeInterface {
    int [][][] cube =new int[3][3][6];
    int[] povorcube =new int [3];
	@Override
	public void abortStep(int step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void check() {
	int flag=0;	
	for(int k=0;k<6;k++){
	for (int i=0;i<3;i++){
	for (int j=0;j<3;j++){
	if (cube [0][0][k]==cube [i][j][k]){
		flag++;
	}
		else {break;
			
		
	} 	
	}
		
	}
	}
	if (flag==54){//победа
		}
	}
	

	@Override
	public void choice(int side) {
    		
		
	}

	@Override
	public void init() {
		for(int k=0;k<6;k++){
			for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
			cube [i][j][k]=k;			
			}			 	
			}			
			}	
		
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
		
		
	}

	@Override
	public void turnGoriz(int i, int j, int k, byte goriz) {
		
	for (int l=0;l<3;l++){//Запоминаем верхнюю строку
		povorcube[l]=cube[l][0][k];
	}
	
	if (goriz>0){
	for(int l=0;l<2;l++){
		cube[0][l][k]=cube[3-1][0][k];
	    cube[3-l][0][k]=cube[2][3-l][k];
	    cube[2][3-l][k]=cube[l][2][k];
	   cube[l][2][k]=povorcube[l];
	}
	
	switch(k){
	case 0 :
		for (int l=0;l<=2;l++)
		{
			povorcube[l]=cube[l][0][1];
		}
		for(int l=0;l<3;l++)
		{
			cube[2][l][1]=cube[3-l][2][4];                 
			cube[3-l][2][4]=cube[2][3-l][3];
			cube[2][3-l][3]=cube[l][0][2];                     
			cube[l][0][2]=povorcube[l];
		}
	case 1:
		for (int l=0;l<=2;l++)
		{
			povorcube[l]=cube[l][0][5];
		}
		for(int l=0;l<3;l++)
		{
			cube[2][l][5]=cube[3-l][2][4];                 
			cube[3-l][2][4]=cube[2][3-l][0];
			cube[2][3-l][0]=cube[l][0][2];                     
			cube[l][0][2]=povorcube[l];
		}
	
	
	
	
	
	}
	    for(int l=0;l<3;l++)
	{
		cube[2][l][1]=cube[3-l][2][4];                 
		cube[3-l][2][4]=cube[2][3-l][3];
		cube[2][3-l][3]=cube[l][0][2];                     
		cube[l][0][2]=povorcube[l];
	}
	}else
	{
		for (int l=0;l<2;l++)
		{
			cube[l][0][k]=cube[0][3-l][k];
			cube[0][3-l][k]=cube[3-l][2][k];
			cube[3-l][2][k]=cube[2][l][k];
			cube[2][l][k]=povorcube[l];
		}
		for (int l=0;l<=2;l++)
		{
			povorcube[l]=cube[2][l][1];
		}
		for(int l=0;l<3;l++)
		{
			cube[2][l][1]=cube[l][0][2];
			cube[l][0][2]=cube[2][3-l][3];
			cube[2][3-l][3]=cube[3-l][2][4];
			cube[3-l][2][4]=povorcube[l];
		}
		 
	}
	
	}

	@Override
	public void turnVert(int i, int j, int k, byte vert) {
	
		
	}

}
