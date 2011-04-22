package ru.nsu.ci.common;

public class RubicsCube implements  RubiksCubeInterface {
    public int [][][] cube =new int[3][3][6];
    int l;
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
		
		int n;
	for (int l=0;l<3;l++){//Запоминаем верхнюю строку
		povorcube[l]=cube[l][0][k];
	}
	
	if (goriz>0){
	for(int l=0;l<2;l++){
		cube[0][l][k]=cube[2-1][0][k];
	    cube[2-l][0][k]=cube[2][2-l][k];
	    cube[2][2-l][k]=cube[l][2][k];
	   cube[l][2][k]=povorcube[l];
	}
	
	switch(k){
	case 0 :
		 for(l=0;l<3;l++)
	    {
	        n=cube[2][l][1];
	        cube[2][l][1]=cube[2-l][0][5];
	        cube[2-l][0][5]=cube[2][2-l][3];
	        cube[2][2-l][3]=cube[l][0][4];
	        cube[l][0][4]=n;
	    }//������ ���������
	case 1 :
		for(l=0;l<3;l++)
	    {
	        n=cube[0][l][2];
	        cube[0][l][2]=cube[0][l][5];
	        cube[0][l][5]=cube[0][2-l][0];
	        cube[0][2-l][0]=cube[0][2-l][4];
	        cube[0][2-l][4]=n;
	    } //������ ���������
	case 2 :    for(l=0;l<3;l++)
	    {
	        n=cube[0][l][1];
	        cube[0][l][1]=cube[2-l][2][5];
	        cube[2-l][2][5]=cube[0][2-l][3];
	        cube[0][2-l][3]=cube[l][2][4];
	        cube[l][2][4]=n;
	    } //������ ���������
	case 3 :    for(l=0;l<3;l++)
	    {
	        n=cube[2][l][2];
	        cube[2][l][2]=cube[2][l][5];
	        cube[2][l][5]=cube[2][2-l][0];
	        cube[2][2-l][0]=cube[2][2-l][4];
	        cube[2][2-l][4]=n;
	    } //��������� ���������
	case 4 :    for(l=0;l<3;l++)
	    {
	        n=cube[2-l][2][1];
	        cube[2-l][2][1]=cube[2-l][2][0];
	        cube[2-l][2][0]=cube[l][2][3];
	        cube[l][2][3]=cube[l][2][2];
	        cube[l][2][2]=n;
	    } //����� ���������
	case 5 :     for(l=0;l<3;l++)
	    {
	        n=cube[2-l][0][1];
	        cube[2-l][0][1]=cube[2-l][0][0];
	        cube[2-l][0][0]=cube[l][0][3];
	        cube[l][0][3]=cube[l][0][2];
	        cube[l][0][2]=n;
	    } //������ ���������
	
	
	
	
	
	}
	    
	}else
	{
		for (l=0;l<2;l++)
		{
			cube[l][0][k]=cube[0][2-l][k];
			cube[0][2-l][k]=cube[2-l][2][k];
			cube[2-l][2][k]=cube[2][l][k];
			cube[2][l][k]=povorcube[l];
		}
		switch(k){
		case 0 :
			 for(l=0;l<3;l++)
		    {
		        n=cube[2][l][1];
		        cube[2][l][1]=cube[l][0][4]; 
		        cube[l][0][4]=cube[2][2-l][3]; 
		        cube[2][2-l][3]=cube[2-l][0][5];
		        cube[2-l][0][5]=n;
		    }//������ ���������
		case 1 :
			for(l=0;l<3;l++)
		    {
		        n=cube[0][l][2];
		        cube[0][l][2]=cube[0][2-l][4]; 
		        cube[0][2-l][4]=cube[0][2-l][0]; 
		        cube[0][2-l][0]=cube[0][l][5];
		        cube[0][l][5]=n;
		    } //������ ���������
		case 2 :    for(l=0;l<3;l++)
		    {
		        n=cube[0][l][1];
		        cube[0][l][1]=cube[l][2][4]; 
		        cube[l][2][4]=cube[0][2-l][3]; 
		        cube[0][2-l][3]=cube[2-l][2][5];
		        cube[2-l][2][5]=n;
		    } //������ ���������
		case 3 :    for(l=0;l<3;l++)
		    {
		        n=cube[2][l][2];
		        cube[2][l][2]=cube[2][2-l][4]; 
		        cube[2][2-l][4]=cube[2][2-l][0]; 
		        cube[2][2-l][0]=cube[2][l][5];
		        cube[2][l][5]=n;
		    } //��������� ���������
		case 4 :    for(l=0;l<3;l++)
		    {
		        n=cube[2-l][2][1];
		        cube[2-l][2][1]=cube[l][2][2]; 
		        cube[l][2][2]=cube[l][2][3]; 
		        cube[l][2][3]=cube[2-l][2][0];
		        cube[2-l][2][0]=n;
		    } //����� ���������
		case 5 :     for(l=0;l<3;l++)
		    {
		        n=cube[2-l][0][1];
		        cube[2-l][0][1]=cube[l][0][2]; 
		        cube[l][0][2]=cube[l][0][3];
		        cube[l][0][3]=cube[2-l][0][0];
		        cube[2-l][0][0]=n;
		    } //������ ���������
		}
	}
	
	}

	@Override
	public void turnVert(int i, int j, int k, byte vert) {
	
		
	}

}

