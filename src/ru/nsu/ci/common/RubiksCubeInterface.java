package ru.nsu.ci.common;
/**
 * Здесь вы должны поместить ваш интерфейс!
 */
public interface RubiksCubeInterface {
	public void init(); //Инициализация массива
	public void choice(int k );//Выбор фронтальной плоскости
    public void turnGoriz(int k,int goriz);//Поворот по горизонтали 
    public void check();//Проверка на выигрыш
    public void save(String filename);//Сохранить
    public void load(String filename);//Загрузить
    public void abortStep(int step);//Отмена ходов 
    public void saveStep();//Сохранение ходов 
	
}
