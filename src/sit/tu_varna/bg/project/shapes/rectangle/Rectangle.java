package sit.tu_varna.bg.project.shapes.rectangle;


import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.FigureException;

import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

/**
 * Клас Правоъгълник за създаване на фигура правоъгълник в SVG
 */
public class Rectangle extends AbstractShape {

    private int initialX;
    private int initialY;
    private int width;
    private int height;
    private int roundCornerX=0;
    private int roundCornerY=0;

    /**
     *Конструктор за създаване на правоъгълник
     * @param fill - Параметър за цввта за запълване на фигурата
     * @param strokeWidth - Параметър за дебелина на линията около създадената фигура
     * @param stroke - Параметър за цввта за линията
     * @param initialX - Начален Х кординат
     * @param initialY - Начален У- кординат
     * @param width - Параметър за широчина на фигурата
     * @param height - Параметър за височина на фигурата
     */
    public Rectangle(NamedColors fill, int strokeWidth, NamedColors stroke,int initialX, int initialY, int width, int height) throws FigureException {
        super(fill, strokeWidth, stroke);
        setInitialX(initialX);
        setInitialY(initialY);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Втори конструктор който ще отговаря за създаването на закръглен правоъгълник
     * @param fill - Параметър за цввта за запълване на фигурата
     * @param strokeWidth - Параметър за дебелина на линията около създадената фигура
     * @param stroke - Параметър за цввта за линията
     * @param initialX - Начален Х кординат
     * @param initialY - Начален У- кординат
     * @param width - Параметър за широчина на фигурата
     * @param height - Параметър за височина на фигурата
     * @param roundCornerX - Параметър за закръгленост по Х абсицата
     * @param roundCornerY - Параметър за закръгленост по У ординатата
     */
    public Rectangle(NamedColors fill, int strokeWidth, NamedColors stroke,int initialX, int initialY, int width, int height,int roundCornerX,int roundCornerY) throws FigureException {
        super(fill, strokeWidth, stroke);
        setInitialX(initialX);
        setInitialY(initialY);
        setWidth(width);
        setHeight(height);
        setRoundCornerX(roundCornerX);
        setRoundCornerY(roundCornerY);

    }

    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * [superMethod резултат]  [x]  [y] [широчина] [дебелина] [закръгленост по Х] [закръгленост по Y]
     * Методът не използва параметри
     * @return Низ презентиращ SVG команда за генериране на правоъгълник по указани параметри
     */
    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<rect ").append(super.convertIntoString());
        if (roundCornerY > 0 && roundCornerX > 0) {
            sb.append(" x=\"").append(initialX).append("\"")
                    .append(" y=\"").append(initialY).append("\"")
                    .append(" width=\"").append(width).append("\"")
                    .append(" height=\"").append(height).append("\"")
                    .append(" rx=\"").append(roundCornerX).append("\"")
                    .append(" ry=\"").append(roundCornerY).append("\"");
        } else {
            sb.append(" x=\"").append(initialX).append("\"")
                    .append(" y=\"").append(initialY).append("\"")
                    .append(" width=\"").append(width).append("\"")
                    .append(" height=\"").append(height).append("\"");
        }
        sb.append(" />");
        return sb.toString();
    }

    /**
     * Транслира фигура по Х кординат
     * @param sx - изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) throws FigureException,IllegalArgumentException {
        setInitialX(getInitialX()+sx);
    }

    /**
     * Транслира фигура по У кординат
     * @param sy - изместване по У ординатата
     */
    @Override
    public void translateY(int sy) throws FigureException {
        setInitialY(getInitialY()+sy);
    }


    /**
     * Проверява дали дадената фигура ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2=R^2
     * @param region представлява регионът който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(CircleRegion region) {
        double equation1=Math.pow(initialX- region.getX(),2)+Math.pow(initialY- region.getY(),2);
        double equation2=Math.pow(initialX+width- region.getX(),2)+Math.pow(initialY+height- region.getY(),2);
        return(equation1<=Math.pow(region.getRadius(), 2) && equation2<=Math.pow(region.getRadius(), 2));
    }
    /**
     * Проверява дали дадената фигура ще е попадне в правоъгълен регион
     * @param region представлява регионът който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(RectangleRegion region) {
        boolean xCheck= (initialX <= region.getX()+ region.getWidth() && initialX>= region.getX());
        boolean yCheck= (initialY<=region.getY()+region.getHeight() && initialY>= region.getY());
        return (xCheck && yCheck);
    }

    /**
     * Превръща атрибутите на класа, лесно четими за потребителя
     * @return Низ представляваш лесно прочитаема команда от окото на потребителя
     */
    @Override
    public String toUser() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("rectangle ").append(super.toUser()).append(" ").append(initialX)
                .append(" ").append(initialY).append(" ").append(width).append(" ").append(height);
        if(roundCornerY>0 && roundCornerX>0){
            sb1.append(" ").append(roundCornerX).append(" ").append(roundCornerY);
            return sb1.toString();
        }
        return sb1.toString();
    }

    /**
     * Гетър на кординат Х1
     * @return цяло число отнасящо Х-кордината на първата точка
     */
    public int getInitialX() {
        return initialX;
    }

    /**
     * Задава кординат Х1
     * @param initialX новия кординат
     */
    public void setInitialX(int initialX) throws FigureException,IllegalArgumentException {
        if(initialX<0){
            throw new FigureException("Illegal initialX");
        }
        this.initialX = initialX;
    }

    /**
     * Гетър на кординат У1
     * @return цяло число отнасящо У-кордината на първата точка
     */
    public int getInitialY() {
        return initialY;
    }

    /**
     * Задава кординат Х1
     * @param initialY новия кординат
     */
    public void setInitialY(int initialY) throws FigureException,IllegalArgumentException {
        if(initialY<0){
            throw new FigureException("Illegal initialY");
        }
        this.initialY = initialY;
    }

    /**
     * Гетър на широчина
     * @return широчината като цяло число
     */
    public int getWidth() {
        return width;
    }

    /**
     * Задава нова стойност на широчината
     * @param width представлява широчината
     */
    public void setWidth(int width) throws FigureException,IllegalArgumentException{
        if(width<0){
            throw new FigureException("Illegal width");
        }
        this.width = width;
    }


    /**
     * Метод за получаване на текущата височина на правоъгълника.
     * @return текущата височина
     */
    public int getHeight() {
        return height;
    }

    /**
     * Метод за задаване на височина на правоъгълника.
     * @param height - новата височина
     */
    public void setHeight(int height) throws FigureException,IllegalArgumentException {
        if(height<0){
            throw new FigureException("Illegal height");
        }
        this.height = height;
    }

    /**
     * Метод за получаване на радиуса на закръгленост по оста X на правоъгълника.
     * @return радиуса на закръгленост по X
     */
    public int getRoundCornerX() {
        return roundCornerX;
    }

    /**
     * Метод за задаване на радиуса на закръгленост по оста X на правоъгълника.
     * @param roundCornerX - новият радиус на закръгленост по X
     */
    public void setRoundCornerX(int roundCornerX) throws FigureException,IllegalArgumentException {
        if(roundCornerX<0){
            throw new FigureException("Illegal roundCornerX");
        }
        this.roundCornerX = roundCornerX;
    }

    /**
     * Метод за получаване на радиуса на закръгленост по оста Y на правоъгълника.
     * @return радиуса на закръгленост по Y
     */
    public int getRoundCornerY() {
        return roundCornerY;
    }

    /**
     * Метод за задаване на радиуса на закръгленост по оста Y на правоъгълника.
     * @param roundCornerY - новият радиус на закръгленост по Y
     */
    public void setRoundCornerY(int roundCornerY) throws FigureException,IllegalArgumentException {
        if(roundCornerY<0){
            throw new FigureException("Illegal roundCornerY");
        }
        this.roundCornerY = roundCornerY;
    }
}
