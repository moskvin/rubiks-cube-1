package ru.nsu.ci.common;
/**
 * Здесь вы должны поместить ваш интерфейс!
 */
public interface RubiksCubeInterface {
	public void init(); //Инициализация массива
//	public void draw(int i,int j,int k);//Рисование
	public void choice(int side );//Выбор фронтальной плоскости
	public void turnVert(int i,int j,int k,byte vert);//Поворот по вертикали одной секции (i,j,k координаты в массиве)
    public void turnGoriz(int i,int j,int k,byte goriz);//Поворот по горизонтали (i,j,k координаты в массиве)
    public void check();//Проверка на выигрыш
    public void save(String filename);//Сохранить
    public void load(String filename);//Загрузить
    public void abortStep(int step);//Отмена ходов 
    public void saveStep();//Сохранение ходов 
	
}
