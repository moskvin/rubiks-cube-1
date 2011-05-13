package ru.nsu.ci.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import ru.nsu.ci.NumStorError;
public class RubicsCube implements  RubiksCubeInterface {
	 private static Random random = new Random();
	 Deque<Integer> deque = new ArrayDeque<Integer>();
	 File save = new File("save.txt");
	 File restart = new File("restart.txt");
		FileOutputStream fos; 		
		DataOutputStream dos;
		FileInputStream pos; 
		DataInputStream kos;


	public int [][][] cube =new int[3][3][6];
    int[] povorcube =new int [3];
	@Override
	public void abortStep(int step) {
		int k;
		int goriz;
		
		if ((2*step>deque.size())||(deque.isEmpty())){
			throw new NumStorError("Значение больше допустимого");
		}
		else
		{
		for (int l=0;l<step;l++){
		turnGoriz(k=deque.pollFirst(),goriz=deque.pollFirst()*(-1));
		deque.removeFirst();
		deque.removeFirst();
				
		
		}
			
		}
		
		
		
	}

	
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
	if (flag==54){
		throw new NumStorError("Поздравляем победа!!!");
		
		}
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
		
		for (int l=0;l<18;l++){
			int k=random.nextInt(6);
			int goriz=random.nextInt(10)-5;
			turnGoriz(k,goriz);			
			 }
		deque.clear();		
		restart();
		
		
	}

	@Override
	public void load(String filename) {
	
		try {
			pos = new FileInputStream(save);
			kos = new DataInputStream(pos);
			for(int[][] subArray:cube)
			{
				for(int[] subsub:subArray)
				{
					for(int n:subsub)
					{
						 n =kos.readInt();
						
					
						
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	

	@Override
	public void save(String filename) {
				try {
					
			fos = new FileOutputStream(save);
			dos = new DataOutputStream(fos);
			for(int[][] subArray:cube)
			{
				for(int[] subsub:subArray)
				{
					for(int n:subsub)
					{
						dos.writeInt(n);
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveStep( int k,int goriz) {
	  
		deque.addFirst(goriz);
		deque.addFirst(k);
		if (deque.size()>20){
			deque.pollLast();
			deque.pollLast();
		}
		
	}
	public void restart(){
		try {
			fos = new FileOutputStream(restart);
			dos = new DataOutputStream(fos);
			for(int[][] subArray:cube)
			{
				for(int[] subsub:subArray)
				{
					for(int n:subsub)
					{
						dos.writeInt(n);
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void delsavefile(){
	if	(save.exists()){
		save.delete();
		
	}
	}	
	public void delrestartfile(){
		if	(restart.exists()){
			restart.delete();
			
		}
		}	
		
		
		
		
	

	@Override
	public void turnGoriz( int k, int goriz) {
		int l;
		int n;
		
    if (goriz!=0){
    	saveStep( k, goriz);
    	for (l=0;l<3;l++){//Запоминаем верхнюю строку
		povorcube[l]=cube[0][l][k];
	}
	
	if (goriz>0){
	for(l=0;l<2;l++){
		cube[0][l][k]=cube[2-l][0][k];
	    cube[2-l][0][k]=cube[2][2-l][k];
	    cube[2][2-l][k]=cube[l][2][k];
	   cube[l][2][k]=povorcube[l];
	}
	
	switch(k){
	case 0 :
		 for( l=0;l<3;l++)
	    {
	        n=cube[2][l][1];
	        cube[2][l][1]=cube[2-l][2][5];
	        cube[2-l][2][5]=cube[0][2-l][3];
	        cube[0][2-l][3]=cube[l][0][4];
	        cube[l][0][4]=n;
	    }//0 нулевая плоскость 
		 break;
	case 1 :
		for( l=0;l<3;l++)
	    {
	        n=cube[0][2-l][2];
	        cube[0][2-l][2]=cube[0][2-l][5];
	        cube[0][2-l][5]=cube[0][2-l][0];
	        cube[0][2-l][0]=cube[0][2-l][4];
	        cube[0][2-l][4]=n;
	    } //1 первая плоскость
		break;
	case 2 :    for(l=0;l<3;l++)
	    {
	        n=cube[0][2-l][1];
	        cube[0][2-l][1]=cube[2-l][2][4];
	        cube[2-l][2][4]=cube[2][l][3];
	        cube[2][l][3]=cube[l][0][5];
	        cube[l][0][5]=n;
	    } //2 вторая плоскость
		break;
	case 3 :    for(l=0;l<3;l++)
	    {
	        n=cube[2][l][0];
	        cube[2][l][0]=cube[2][l][5];
	        cube[2][l][5]=cube[2][l][2];
	        cube[2][l][2]=cube[2][l][4];
	        cube[2][l][4]=n;
	    } //3 третья плоскость
	break;
	case 4 :    for(l=0;l<3;l++)
	    {
	        n=cube[2-l][2][1];
	        cube[2-l][2][1]=cube[2-l][2][0];
	        cube[2-l][2][0]=cube[2-l][2][3];
	        cube[2-l][2][3]=cube[l][0][2];
	        cube[l][0][2]=n;
	    } //4 четвёртая плоскость
	break;
	case 5 :     for(l=0;l<3;l++)
	    {
	        n=cube[l][0][1];
	        cube[l][0][1]=cube[2-l][2][2];
	        cube[2-l][2][2]=cube[l][0][3];
	        cube[l][0][3]=cube[l][0][0];
	        cube[l][0][0]=n;
	    } //5 пятая плоскость
	break;
	
	
	
	
	}
	    
	}else
	{
		for (l=0;l<2;l++)
		{
			cube[0][l][k]=cube[l][2][k];
			cube[l][2][k]=cube[2][2-l][k];
			cube[2][2-l][k]=cube[2-l][0][k];
			cube[2-l][0][k]=povorcube[l];
		}
		switch(k){
		case 0 :
			 for( l=0;l<3;l++)
		    {
		        n=cube[2][l][1];
		        cube[2][l][1]=cube[l][0][4]; 
		        cube[l][0][4]=cube[0][2-l][3]; 
		        cube[0][2-l][3]=cube[2-l][2][5];
		        cube[2-l][2][5]=n;
		    }//0 нулевая плоскость 
			 break;
		case 1 :
			for( l=0;l<3;l++)
		    {
		        n=cube[0][2-l][2];
		        cube[0][2-l][2]=cube[0][2-l][4]; 
		        cube[0][2-l][4]=cube[0][2-l][0]; 
		        cube[0][2-l][0]=cube[0][2-l][5];
		        cube[0][2-l][5]=n;
		    } //1 первая плоскость 
			break;
		case 2 :    for(l=0;l<3;l++)
		    {
		        n=cube[0][2-l][1];
		        cube[0][2-l][1]=cube[l][0][5]; 
		        cube[l][0][5]=cube[2][l][3]; 
		        cube[2][l][3]=cube[2-l][2][4];
		        cube[2-l][2][4]=n;
		    } //2 вторая плоскость
		break;
		case 3 :    for(l=0;l<3;l++)
		    {
		        n=cube[2][l][0];
		        cube[2][l][0]=cube[2][l][4]; 
		        cube[2][l][4]=cube[2][l][2]; 
		        cube[2][l][2]=cube[2][l][5];
		        cube[2][l][5]=n;
		    } //3 третья плоскость
		break;
		case 4 :    for(l=0;l<3;l++)
		    {
		        n=cube[2-l][2][1];
		        cube[2-l][2][1]=cube[l][0][2]; 
		        cube[l][0][2]=cube[2-l][2][3]; 
		        cube[2-l][2][3]=cube[2-l][2][0];
		        cube[2-l][2][0]=n;
		    } //4 четвёртая плоскость
		break;
		case 5 :     for(l=0;l<3;l++)
		    {
		        n=cube[l][0][1];
		        cube[l][0][1]=cube[l][0][0]; 
		        cube[l][0][0]=cube[l][0][3]; 
		        cube[l][0][3]=cube[2-l][2][2];
		        cube[2-l][2][2]=n;
		    } //5 пятая плоскость
		break;
		 
	}
		check();
	}
	}

	}


}
