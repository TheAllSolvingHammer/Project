package sit.tu_varna.bg.project.shapes.polygon;


import sit.tu_varna.bg.project.enums.NamedColors;

import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

import java.util.List;

/**
 * Клас многоъгълник
 */
public class Polygon extends AbstractShape {

    private List<Integer> arrayOfCoordinates;

    /**
     *Конструктор за създаване на многоъгълник
     * @param fill - Запълване на многоъгълника
     * @param strokeWidth - дебелина на линията описваща многоъгълника
     * @param stroke - цвят на линията
     * @param arrayOfCoordinates - масив от кординати , редувайки двойката (х,у)
     */
    public Polygon(NamedColors fill, int strokeWidth, NamedColors stroke,List<Integer> arrayOfCoordinates) throws FigureException {
        super(fill, strokeWidth, stroke);
        setArrayOfCoordinates(arrayOfCoordinates);
    }

    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * [superMethod резултат] [масив от кориднати]
     * Методът не използва параметри
     * @return Низ представляваш SVG команда за създаването на многоъгълник
     */
    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon ").append(super.convertIntoString());

        sb.append (" points=\"");
        if(arrayOfCoordinates.isEmpty()){
            sb.append("\" />");
            return sb.toString();
        }
        for(int i=1;i<arrayOfCoordinates.size();i+=2){
            if(i+1>=arrayOfCoordinates.size()){
                break;
            }
            sb.append(arrayOfCoordinates.get(i-1)).append(",").append(arrayOfCoordinates.get(i)).append(" ");

        }

        //sb.delete(sb.length()-1,sb.length());
        sb.append("\" />");
        return sb.toString();
    }
    /**
     * Транслира фигура по Х кординат
     * @param sx -  изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) throws IllegalArgumentException {
        for(int i=0;i<arrayOfCoordinates.size();i+=2){
            arrayOfCoordinates.set(i,arrayOfCoordinates.get(i)+sx);
        }
    }
    /**
     * Транслира фигура по У кординат
     * @param sy - изместване по У ординатата
     */
    @Override
    public void translateY(int sy) {
        for(int i=1;i<arrayOfCoordinates.size();i+=2){
            arrayOfCoordinates.set(i,arrayOfCoordinates.get(i)+sy);
        }
    }
    /**
     * Проверява дали дадената фигура ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2=R^2
     * @param region представлява регионът, който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(CircleRegion region) {
        boolean flag=true;
        double equation;
        for(int i=0;i< arrayOfCoordinates.size();i+=2){
            equation=Math.pow(arrayOfCoordinates.get(i)- region.getX(),2)+Math.pow(arrayOfCoordinates.get(i+1)- region.getY(),2);
            if(equation>Math.pow(region.getRadius(), 2)){
                flag=false;
                break;
            }
        }
        return flag;
    }
    /**
     * Проверява дали дадената фигура ще е попадне в правоъгълен регион
     * @param region представлява регионът, който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(RectangleRegion region) {
        boolean flag=true;
        boolean xCheck,yCheck;
        for(int i=0;i< arrayOfCoordinates.size();i+=2){
            xCheck= (arrayOfCoordinates.get(i) <= region.getX()+ region.getWidth() && arrayOfCoordinates.get(i)>= region.getX());
            yCheck= (arrayOfCoordinates.get(i+1)<=region.getY()+region.getHeight() && arrayOfCoordinates.get(i+1)>= region.getY());
            if(!(xCheck && yCheck)){
                flag=false;
                break;
            }
        }
        return flag;
    }

    /**
     * Превръща атрибутите на класа, лесно четими за потребителя
     * @return Низ представляваш лесно прочитаема команда от окото на потребителя
     */
    @Override
    public String toUser() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("polygon ").append(super.toUser());
        for(Integer i1:arrayOfCoordinates){
            sb1.append(" ").append(i1);
        }
        return sb1.toString();
    }

    /**
     * Гетър на всички кординати представеня в Списък
     * @return Списък от кординати
     */
    public List<Integer> getArrayOfCoordinates() {
        return arrayOfCoordinates;
    }

    /**
     * Задава нов списък с кординати за Многоъгълник
     * @param arrayOfCoordinates списък от нови кординати като параметър
     * @throws FigureException изключение за неправилен вход, в случая празен масив с кординати
     * @throws IllegalArgumentException изключение за неправилни аргументи
     */
    public void setArrayOfCoordinates(List<Integer> arrayOfCoordinates) throws FigureException,IllegalArgumentException {
        if(arrayOfCoordinates.isEmpty()){
            throw new FigureException("Array of coordinates is empty");
        }
        this.arrayOfCoordinates = arrayOfCoordinates;
    }

}
