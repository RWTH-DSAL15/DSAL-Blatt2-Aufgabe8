/*
/  SkipListElement
/  Created by : Orion
/  Created on : 5-5-2015
*/

public class SkipListElement {

    public static int MAX_HEIGHT = 2;

    private int iHeight = 1;
    private SkipListElement[] iNextElements = new SkipListElement[MAX_HEIGHT];

    private int iContent = -1;

    public SkipListElement()
    {

    }

    public int getContent()
    {
        return iContent;
    }


    public SkipListElement chainElementIntoList(SkipList pList, SkipListElement pNewElement)
    {
        return pNewElement;
    }

    public SkipListElement getNextElement(int pHeight)
    {
        if(iNextElements.length>=pHeight)
        {
            return null;
        }
        return iNextElements[pHeight];
    }

    public void setHeight(int pNewHeight)
    {

    }

    public int getHeight()
    {
        return iHeight;
    }
}
