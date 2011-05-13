package ru.nsu.ci.common;
public interface RubiksCubeInterface {
	public void init(); //Инициализация массива
	public void turnGoriz(int k,int goriz);//Поворот по горизонтали 
    public void check();//Проверка на выигрыш
    public void save(String filename);//Сохранить
    public void load(String filename);//Загрузить
    public void abortStep(int step);//Отмена ходов 
    public void saveStep(int k,int goriz);//Сохранение ходов 
	public void restart();//заново.
	public void delsavefile();//удаляем сэйвы 
	public void delrestartfile();//удаляем "заново" 
	
	
}
